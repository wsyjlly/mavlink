package cn.wsyjlly.mavlink.descriptor;

import cn.wsyjlly.mavlink.protocol.util.StringModel;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**********************************
 * Author YSW
 * Description
 * Date 2020.10.26 - 14:43
 **********************************/

public class MessageDescriptor implements MavlinkDescriptor{
	private static final Logger log = Logger.getLogger(FileGenerator.class);

	@Override
	public void descriptor(String srcFile, String targetFolder) {
		try {
			Document doc = new SAXReader().read(new File((srcFile)));
			Element messages = doc.getRootElement().elements("messages").get(0);
			List<Element> elements = messages.elements("message");
			HashMap<String, Object> messageMap = new HashMap<>(10);
			for (Element message : elements) {
				String id = message.attributeValue("id");
				String messageName = message.attributeValue("name");
				String className = StringModel.lineToBigHump(messageName);
				messageMap.put("id", id);
				messageMap.put("messageName", messageName);
				messageMap.put("className", className);
				Element desc = message.element("description");
				if (Objects.nonNull(desc)){
					String description = desc.getTextTrim();
					messageMap.put("description", description);
				}
				List<Element> fields = message.elements("field");
				int messageLength = 0;
				HashMap<String, HashMap<String, Object>> fieldsMap = new LinkedHashMap<>(10);
				for (Element field : fields) {
					HashMap<String, Object> paramMap = new HashMap<>(10);
					field.attributes().forEach(attribute -> {
						String value = attribute.getValue();
						if ("enum".equals(attribute.getName())){
							value = StringModel.lineToBigHump(attribute.getValue());
						}
						paramMap.put(attribute.getName(), value);
					});
					String fieldText = field.getTextTrim();

					String type = field.attributeValue("type");
					String fieldName = field.attributeValue("name");
					if (Objects.nonNull(type)) {
						MavlinkType mavlinkType = MavlinkType.of(type);
						paramMap.put("arrayLength", mavlinkType.getArrayLength());
						paramMap.put("type", mavlinkType.getTypeName());
						paramMap.put("mavlinkType", mavlinkType.getMavlinkType());
						paramMap.put("isArray", mavlinkType.isArray());
						paramMap.put("length", mavlinkType.getLength());
						paramMap.put("streamLength", mavlinkType.getStreamLength());
						messageLength += mavlinkType.getStreamLength();
					}
					if (Objects.nonNull(fieldName)) {
						paramMap.put("smallHumpName", StringModel.lineToHump(fieldName));
						paramMap.put("bigHumpName", StringModel.lineToBigHump(fieldName));
					}
					if (Objects.nonNull(fieldText)) {
						paramMap.put("description", fieldText);
					}
					fieldsMap.put(fieldName, paramMap);
				}
				messageMap.put("params", fieldsMap);
				messageMap.put("messageLength", messageLength);
				createMessageJavaFile(messageMap,targetFolder);
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

	private static void createMessageJavaFile(HashMap<String, Object> messageMap,String targetFolder) {
		int packageNameStartIndex = targetFolder.indexOf("src\\main\\java\\");
		String packageName = targetFolder.substring(packageNameStartIndex + "src\\main\\java\\".length()).replaceAll("\\\\",".");
		String parantPackageName = packageName.substring(0,packageName.lastIndexOf("."));
		StringBuffer sb = new StringBuffer();
		Object id = messageMap.get("id");
		Object messageLength = messageMap.get("messageLength");
		Object className = messageMap.get("className");
		String description = (String) messageMap.get("description");
		description = description.replaceAll("\"", "'");
		AtomicReference<Boolean> hasBigInteger = new AtomicReference<>(false);
		AtomicReference<Boolean> hasArray = new AtomicReference<>(false);
		HashMap<String, Object> params = (HashMap<String, Object>) messageMap.get("params");
		AtomicInteger paramCount = new AtomicInteger();
		HashSet<String> enumSet = new HashSet<>();
		params.forEach((key, value) -> {
			paramCount.getAndIncrement();
			HashMap<String, Object> paramMap = (HashMap<String, Object>) value;
			Object type = paramMap.get("type");
			if ("BigInteger".equals(type)) {
				hasBigInteger.set(true);
			}
			boolean isArray = (boolean) paramMap.get("isArray");
			if (isArray){
				hasArray.set(true);
			}
			paramMap.forEach((paramKey,paramValue)->{
				if ("enum".equals(paramKey)){
					  enumSet.add((String) paramValue);
				}
			});
		});
		sb.append("package ").append(packageName).append(";\n\n");
		SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd - hh:mm");
		File file = new File(targetFolder+"\\" + className + ".java");
		sb.append("import cn.wsyjlly.mavlink.annotation.MavlinkMessage;\n" + "import cn.wsyjlly.mavlink.annotation.MavlinkMessageParam;\n" + "import cn.wsyjlly.mavlink.common.Message;\n");
		for (String enum0: enumSet){
			sb.append("import ").append(parantPackageName).append(".enums.").append(enum0).append(";\n");
		}
		sb.append("import cn.wsyjlly.mavlink.protocol.ByteArray;\n" +
				"import cn.wsyjlly.mavlink.protocol.util.ByteModel;\n");
		sb.append("\n" +
				"import java.util.Objects;\n");
		if (hasArray.get()) {
			sb.append("import java.util.Arrays;\n");
		}if (hasBigInteger.get()) {
			sb.append("import java.math.BigInteger;\n");
		}
		sb.append("/**********************************\n" + " * Author YSW\n" + " * Description\n" + " * Date ").append(format.format(new Date())).append("\n").append(" **********************************/\n\n");
		sb.append("@MavlinkMessage(\n" + "\t\tid = ").append(id).append(",\n").append("\t\tmessagePayloadLength = ").append(messageLength).append(",\n").append("\t\tdescription = \""+description+"\"\n").append(")\n").append("public class ").append(className).append(" implements Message {\n");
		AtomicInteger index = new AtomicInteger();
		//实例字段声明
		params.forEach((key, value) -> {
			index.getAndIncrement();
			HashMap<String, Object> paramMap = (HashMap<String, Object>) value;
			boolean isArray = (boolean)paramMap.get("isArray");
			Object arrayLength = paramMap.get("arrayLength");
			Object type = paramMap.get("type");
			Object mavlinkType = paramMap.get("mavlinkType");
			Object length = paramMap.get("length");
			Object streamLength = paramMap.get("streamLength");
			Object units = paramMap.get("units");
			Object smallHumpName = paramMap.get("smallHumpName");
			Object enum0 = paramMap.get("enum");
			String desc = ((String) paramMap.get("description")).replaceAll("\"", "'");
			sb.append("\t@MavlinkMessageParam(");
			sb.append("mavlinkType = \"").append(mavlinkType).append("\"");
			sb.append(", position = ").append(index);
			sb.append(", typeSize = ").append(length);
			sb.append(", streamLength = ").append(streamLength);
			sb.append(", description = \"").append(desc).append("\"");
			if (Objects.nonNull(enum0)){
				sb.append(", enum0 = ").append(enum0).append(".class");
			}
			if (units != null) {
				sb.append(", units = \"").append(units).append("\")\n");
			} else {
				sb.append(")\n");
			}
			if ("char".equals(type)) {
				sb.append("\tprivate String ").append(smallHumpName).append(";\n\n");
			} else {
				if (isArray){
					sb.append("\tprivate ").append(type).append("[] ").append(smallHumpName).append(" = new "+type+"["+arrayLength+"]").append(";\n\n");
				} else {
					sb.append("\tprivate ").append(type).append(" ").append(smallHumpName).append(";\n\n");
				}
			}
		});
		sb.append("\tprivate final int messagePayloadLength = ").append(messageLength).append(";\n\n").append("\tprivate byte[] messagePayload = new byte[messagePayloadLength];\n").append("\n");
		sb.append("\tpublic ").append(className).append("(");
		params.forEach((key, value) -> {
			HashMap<String, Object> paramMap = (HashMap<String, Object>) value;
			boolean isArray = (boolean) paramMap.get("isArray");
			Object type = paramMap.get("type");
			Object smallHumpName = paramMap.get("smallHumpName");
			if ("char".equals(type)) {
				sb.append("String ").append(smallHumpName).append(", ");
			} else {
				if (isArray){
					sb.append(type).append("[] ").append(smallHumpName).append(", ");
				} else {
					sb.append(type).append(" ").append(smallHumpName).append(", ");
				}
			}
		});
		sb.delete(sb.lastIndexOf(", "), sb.lastIndexOf(", ") + 2);
		sb.append(") {\n");
		params.forEach((key, value) -> {
			HashMap<String, Object> paramMap = (HashMap<String, Object>) value;
			Object smallHumpName = paramMap.get("smallHumpName");
			sb.append("\t\tthis.").append(smallHumpName).append(" = ").append(smallHumpName).append(";\n");
		});
		sb.append("\t}\n" +
				"\n");
		sb.append("\tpublic ").append(className).append("(byte[] messagePayload) {\n" +
				"\t\tif (messagePayload.length != messagePayloadLength){\n" +
				"\t\t\tthrow new IllegalArgumentException(\"Byte array length is not equal to " + messageLength + "！\");\n" +
				"\t\t}\n" +
				"\t\tmessagePayload(messagePayload);\n");
		sb.append("\t}\n\n");
		sb.append("\tpublic ")
				.append(className)
				.append("(){ }\n")
				.append("\n\t@Override\n")
				.append("\tpublic void messagePayload(byte[] messagePayload) {\n")
				.append("\t\tthis.messagePayload = messagePayload;\n")
				.append("\t\tByteArray byteArray = new ByteArray(messagePayload);\n");
		index.set(0);
		params.forEach((key, value) -> {
			HashMap<String, Object> paramMap = (HashMap<String, Object>) value;
			int streamLength = (int) paramMap.get("streamLength");
			boolean isArray = (boolean) paramMap.get("isArray");
			Object arrayLength = paramMap.get("arrayLength");
			Object smallHumpName = paramMap.get("smallHumpName");
			String mavlinkType = paramMap.get("mavlinkType").toString();
			if (mavlinkType.startsWith("int")) {
				mavlinkType = mavlinkType.substring(0, mavlinkType.indexOf("_"));
				mavlinkType = "getInt" + mavlinkType.substring(3);
			} else if (mavlinkType.startsWith("uint")) {
				mavlinkType = mavlinkType.substring(0, mavlinkType.indexOf("_"));
				mavlinkType = "getUnsignedInt" + mavlinkType.substring(4);
			} else if ("float".equals(mavlinkType)) {
				mavlinkType = "getFloat";
			} else if ("double".equals(mavlinkType)) {
				mavlinkType = "getDouble";
			} else if ("char".equals(mavlinkType)) {
				mavlinkType = "getChars";
			}
			if ("getChars".equals(mavlinkType)) {
				sb.append("\t\t").append(smallHumpName).append(" = byteArray.")
						.append(mavlinkType).append("(").append(index).append(",").append(arrayLength).append(");\n");
			} else {
				if (isArray){
					sb.append("\t\t").append(smallHumpName).append(" = byteArray.")
							.append(mavlinkType).append("Array(").append(index).append(",").append(arrayLength).append(");\n");
				} else {
					sb.append("\t\t").append(smallHumpName).append(" = byteArray.")
							.append(mavlinkType).append("(").append(index).append(");\n");
				}
			}
			index.set(index.get() + streamLength);
		});
		sb.append("\t}\n")
				.append("\n\t@Override\n")
				.append("\tpublic byte[] messagePayload() {\n")
				.append("\t\tByteArray byteArray = new ByteArray(messagePayload);\n");
		index.set(0);
		params.forEach((key, value) -> {
			HashMap<String, Object> paramMap = (HashMap<String, Object>) value;
			boolean isArray = (boolean) paramMap.get("isArray");
			int streamLength = (int) paramMap.get("streamLength");
			Object smallHumpName = paramMap.get("smallHumpName");
			String mavlinkType = paramMap.get("mavlinkType").toString();
			if (mavlinkType.startsWith("int")) {
				mavlinkType = mavlinkType.substring(0, mavlinkType.indexOf("_"));
				mavlinkType = "putInt" + mavlinkType.substring(3);
			} else if (mavlinkType.startsWith("uint")) {
				mavlinkType = mavlinkType.substring(0, mavlinkType.indexOf("_"));
				mavlinkType = "putUnsignedInt" + mavlinkType.substring(4);
			} else if ("float".equals(mavlinkType)) {
				mavlinkType = "putFloat";
			} else if ("double".equals(mavlinkType)) {
				mavlinkType = "putDouble";
			} else if ("char".equals(mavlinkType)) {
				mavlinkType = "putChars";
			}
			if ("putChars".equals(mavlinkType)) {
				sb.append("\t\tbyteArray.").append(mavlinkType).append("(")
						.append(smallHumpName+",").append(index).append(");\n");
			} else {
				if (isArray){
					sb.append("\t\tbyteArray.").append(mavlinkType).append("Array(")
							.append(smallHumpName+",").append(index).append(");\n");
				} else {
					sb.append("\t\tbyteArray.").append(mavlinkType).append("(")
							.append(smallHumpName+",").append(index).append(");\n");
				}
			}
			index.set(index.get() + streamLength);
		});
		sb.append("\t\treturn messagePayload;\n")
				.append("\t}\n")
				.append("\t\n\t@Override\n")
				.append("\tpublic String hexStringPayload() {\n")
				.append("\t\treturn ByteModel.bytes2HexString(messagePayload);\n")
				.append("\t}\n")
				.append("\n");
		params.forEach((key, value) -> {
			HashMap<String, Object> paramMap = (HashMap<String, Object>) value;
			boolean isArray = (boolean) paramMap.get("isArray");
			Object smallHumpName = paramMap.get("smallHumpName");
			Object bigHumpName = paramMap.get("bigHumpName");
			Object type = paramMap.get("type");
			if ("char".equals(type)) {
				type = "String";
			}else if (isArray){
				type = type + "[]";
			}
			sb.append("\tpublic final ")
					.append(className)
					.append(" set")
					.append(bigHumpName)
					.append("(")
					.append(type)
					.append(" ")
					.append(smallHumpName)
					.append(") {\n").append("\t\tthis.").append(smallHumpName).append(" = ").append(smallHumpName).append(";\n").append("\t\treturn this;\n").append("\t}\n").append("\n");
			sb.append("\tpublic final ").append(type).append(" get").append(bigHumpName).append("() {\n").append("\t\treturn ").append(smallHumpName).append(";\n").append("\t}\n").append("\n");
		});
		sb.append("\t@Override\n" +
				"\tpublic boolean equals(Object o) {\n" +
				"\t\tif (this == o) {\n" +
				"\t\t\treturn true;\n" +
				"\t\t} else if (o != null && this.getClass().equals(o.getClass())) {\n" +
				"\t\t\t").append(className).append(" other = (").append(className).append(")o;\n");
		index.set(0);
		params.forEach((key, value) -> {
			HashMap<String, Object> paramMap = (HashMap<String, Object>) value;
			Object smallHumpName = paramMap.get("smallHumpName");
			int paramIndex = index.incrementAndGet();
			if (paramCount.get() > 1) {
				if (paramIndex == 1) {
					sb.append("\t\t\tif (!Objects.deepEquals(this.").append(smallHumpName).append(", other.").append(smallHumpName).append(")) {\n").append("\t\t\t\treturn false;\n");
				} else if (paramIndex == paramCount.get()) {
					sb.append("\t\t\t} else {\n" + "\t\t\t\treturn Objects.deepEquals(this.").append(smallHumpName).append(", other.").append(smallHumpName).append(");\n").append("\t\t\t}\n");
				} else {
					sb.append("\t\t\t} else if (!Objects.deepEquals(this.").append(smallHumpName).append(", other.").append(smallHumpName).append(")) {\n").append("\t\t\t\treturn false;\n");
				}
			} else if (paramCount.get() == 1) {
				sb.append("\t\t\treturn Objects.deepEquals(this.").append(smallHumpName).append(", other.").append(smallHumpName).append(");");
			}
		});
		sb.append("\t\t} else {\n" +
				"\t\t\treturn false;\n" +
				"\t\t}\n" +
				"\t}\n" +
				"\n");
		sb.append("\t@Override\n" +
				"\tpublic int hashCode() {\n" +
				"\t\tint result = 0;\n");
		params.forEach((key, value) -> {
			HashMap<String, Object> paramMap = (HashMap<String, Object>) value;
			Object smallHumpName = paramMap.get("smallHumpName");
			sb.append("\t\tresult = 31 * result + Objects.hashCode(this.").append(smallHumpName).append(");\n");
		});
		sb.append("\t\treturn result;\n" +
				"\t}\n" +
				"\n");
		sb.append("\t@Override\n" + "\tpublic String toString() {\n" + "\t\treturn \"").append(className).append("{\" +\n");
		index.set(0);
		params.forEach((key, value) -> {
			HashMap<String, Object> paramMap = (HashMap<String, Object>) value;
			Object smallHumpName = paramMap.get("smallHumpName");
			Object type = paramMap.get("type");
			boolean isArray = (boolean) paramMap.get("isArray");
			int paramIndex = index.incrementAndGet();
			String stringValue = (String) smallHumpName;
			if (isArray){
				if (!"char".equals(type)) {
					stringValue= "Arrays.toString("+smallHumpName+")";
				}
			}
			if (paramIndex == 1) {
				sb.append("\t\t\t\t\"").append(smallHumpName).append("=\" + ").append(stringValue).append(" +\n");
			} else {
				sb.append("\t\t\t\t\", ").append(smallHumpName).append("=\" + ").append(stringValue).append(" +\n");
			}
		});
		sb.append("\t\t\t\t'}';\n" +
				"\t}\n" +
				"}");
		String logMessage = className + ".java Create Success!------------------------------------------------------------";
		if (logMessage.getBytes().length > 80){
			logMessage = logMessage.substring(0, 80);
		}
		log.info(logMessage);
		try {
			File targetFolderFile = new File(targetFolder);
			if (!targetFolderFile.exists()){
				targetFolderFile.mkdirs();
			}
			if (file.exists()) {
				file.delete();
			}
			FileOutputStream fos = new FileOutputStream(file);
			fos.write(sb.toString().getBytes());
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}