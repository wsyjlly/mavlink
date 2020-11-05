package cn.swyan.mavlink.descriptor;

import cn.swyan.mavlink.protocol.util.StringModel;
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

/**********************************
 * @Author YSW
 * @Description
 * @Date 2020.10.26 - 14:42
 **********************************/

public class EnumDescriptor implements MavlinkDescriptor{
	private static final Logger log = Logger.getLogger(FileGenerator.class);

	@Override
	public void descriptor(String srcFile, String targetFolder) {
		try {
			Document doc = new SAXReader().read(new File((srcFile)));
			Element messages = doc.getRootElement().elements("enums").get(0);
			List<Element> elements = messages.elements("enum");
			HashMap<String, Object> enumMap = new LinkedHashMap<>(10);
			for (Element enumeration: elements){
				String enumName = enumeration.attributeValue("name");
				String bitmask = enumeration.attributeValue("bitmask");
				Element description = enumeration.element("description");
				if (Objects.nonNull(description)){
					String descriptionText = description.getTextTrim();
					enumMap.put("description", descriptionText);
				}
				enumMap.put("name", enumName);
				enumMap.put("bitmask", bitmask);
				String className = StringModel.lineToBigHump(enumName);
				enumMap.put("className", className);
				HashMap<String, HashMap<String, Object>> valuesMap = new LinkedHashMap<>(10);
				List<Element> entryList = enumeration.elements("entry");
				for (Element entry:entryList){
					HashMap<String, Object> valueMap = new LinkedHashMap<>(10);
					String entryValue = entry.attributeValue("value");
					String entryName = entry.attributeValue("name");
					valueMap.put("value",entryValue);
					valueMap.put("name",entryName);
					description = entry.element("description");
					if (Objects.nonNull(description)){
						String valueDescription = description.getTextTrim();
						valueMap.put("description",valueDescription);
					}
					valuesMap.put(entryName,valueMap);
				}
				enumMap.put("valuesMap",valuesMap);
				createEnumJavaFile(enumMap,targetFolder);
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

	private static void createEnumJavaFile(HashMap<String, Object> enumMap, String targetFolder) {
		int packageNameStartIndex = targetFolder.indexOf("src\\main\\java\\");
		String packageName = targetFolder.substring(packageNameStartIndex + "src\\main\\java\\".length()).replaceAll("\\\\",".");
		Object name = enumMap.get("name");
		Object className = enumMap.get("className");
		String description = (String) enumMap.get("description");
		if (Objects.nonNull(description)){
			description = description.replaceAll("\"", "'");
		}
		description = description.replaceAll("\"", "'");
		Object bitmask = enumMap.get("bitmask");
		HashMap<String, HashMap<String, Object>> valuesMap = (HashMap<String, HashMap<String, Object>>) enumMap.get("valuesMap");
		StringBuffer sb = new StringBuffer();
		SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd - hh:mm");
		File file = new File(targetFolder+"\\"+className+".java");
		sb.append("package ").append(packageName).append(";\n\n");
		sb.append("import cn.swyan.mavlink.annotation.MavlinkEnum;\n" + "import cn.swyan.mavlink.annotation.MavlinkEnumEntry;\n" + "\n" + "/**********************************\n" + " * @Author YSW\n" + " * @Description\n" + " * @Date ").append(format.format(new Date())).append("\n").append(" *\n").append(" **********************************/\n").append("\n");
		sb.append("@MavlinkEnum(name = \"").append(name).append("\"");
		if (Objects.nonNull(bitmask)){
			sb.append(", bitmask = \"").append(bitmask).append("\"");
		}
		sb.append(")\n");
		sb.append("public enum  ").append(className).append(" {\n");
		valuesMap.forEach((key,value)->{
			Object name1 = value.get("name");
			Object value1 = value.get("value");
			String valueDescription = (String) value.get("description");
			if (Objects.nonNull(valueDescription)){
				valueDescription = valueDescription.replaceAll("\"", "'");
			}
			if (Objects.nonNull(valueDescription) && Objects.nonNull(value1)){
				sb.append("\t\n" + "\t/**\n" + "\t * ").append(valueDescription).append("\n").append("\t */\n").append("\t@MavlinkEnumEntry(value = ").append(value1).append(",description = \"").append(valueDescription).append("\")\n").append("\t").append(name1).append("(),\n");
			} else if (Objects.isNull(valueDescription) && Objects.nonNull(value1)){
				sb.append("\t\n" + "\t/**\n" + "\t * ").append(name1).append("\n").append("\t */\n").append("\t@MavlinkEnumEntry(value = ").append(value1).append(")\n").append("\t").append(name1).append("(),\n");
			} else if (Objects.nonNull(valueDescription)){
				sb.append("\t\n" + "\t/**\n" + "\t * ").append(valueDescription).append("\n").append("\t */\n").append("\t@MavlinkEnumEntry(description = \"").append(valueDescription).append("\")\n").append("\t").append(name1).append("(),\n");
			} else{
				sb.append("\t\n" + "\t/**\n" + "\t * ").append(name1).append("\n").append("\t */\n").append("\t@MavlinkEnumEntry()\n").append("\t").append(name1).append("(),\n");
			}
		});
		sb.append("}");
		String logMessage = className + ".java Create Success!------------------------------------------------------------";
		if (logMessage.getBytes().length > 75){
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
