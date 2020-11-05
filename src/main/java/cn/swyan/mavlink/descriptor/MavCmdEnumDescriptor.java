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

public class MavCmdEnumDescriptor implements MavlinkDescriptor{
	private static final Logger log = Logger.getLogger(FileGenerator.class);

	@Override
	public void descriptor(String srcFile, String targetFolder) {
		try {
			Document doc = new SAXReader().read(new File((srcFile)));
			Element messages = doc.getRootElement().elements("enums").get(0);
			List<Element> elements = messages.elements("enum");
			elements.forEach(enumeration -> {
				if ("MAV_CMD".equals(enumeration.attributeValue("name"))){
					HashSet<HashMap<String, Object>> entrySet = new LinkedHashSet<>(10);
					List<Element> entryList = enumeration.elements("entry");

					for (Element entry:entryList){
						HashMap<String, Object> entryMap = new LinkedHashMap<>(10);
						entry.attributes().forEach( attribute -> {
							entryMap.put(attribute.getName(),attribute.getValue());
						});
						String className = StringModel.lineToBigHump(entry.attribute("name").getValue());
						entryMap.put("className",className);
						Element description = entry.element("description");
						if (Objects.nonNull(description)){
							String valueDescription = description.getTextTrim();
							entryMap.put("description",valueDescription);
						}
						List<Element> params = entry.elements("param");
						HashMap<String,HashMap<String, Object>> paramsMap = new LinkedHashMap<>(10);
						if (params.size() > 0) {
							params.forEach((value)->{
								HashMap<String, Object> paramMap = new LinkedHashMap<>(10);
								value.attributes().forEach(attrValue->{
									paramMap.put(attrValue.getName(),attrValue.getValue());
								});
								paramMap.put("description",value.getTextTrim());
								paramsMap.put(value.attribute("index").getValue(),paramMap);
							});
							entryMap.put("params",paramsMap);
						}
						entrySet.add(entryMap);
						createMacCmdEnumJavaFile(entryMap,targetFolder);
					}
				}
			});
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

	private static void createMacCmdEnumJavaFile(HashMap<String, Object> entryMap, String targetFolder) {
		int packageNameStartIndex = targetFolder.indexOf("src\\main\\java\\");
		String packageName = targetFolder.substring(packageNameStartIndex + "src\\main\\java\\".length()).replaceAll("\\\\",".");
		Object value = entryMap.get("value");
		Object name = entryMap.get("name");
		Object className = entryMap.get("className");
		Object hasLocation = entryMap.get("hasLocation");
		Object isDestination = entryMap.get("isDestination");
		String description = (String) entryMap.get("description");
		if (Objects.nonNull(description)){
			description = description.replaceAll("\"", "'");
		}
		HashMap<String,HashMap<String, Object>> paramsMap= (HashMap<String,HashMap<String, Object>>) entryMap.get("params");
		ArrayList<String> enumList = new ArrayList<>();
		if (Objects.nonNull(paramsMap)){
			for (int i = 1; i <= paramsMap.size(); i++) {
				HashMap<String, Object> param = paramsMap.get(Integer.toString(i));
				if (Objects.nonNull(param)){
					param.forEach((attrKey,attrValue)->{
						if ("enum".equals(attrKey)){
							enumList.add(StringModel.lineToBigHump((String) attrValue));
						}
					});
				}
			}
		}
		StringBuffer sb = new StringBuffer();
		SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd - hh:mm");
		File file = new File(targetFolder+"\\"+className+".java");
		sb.append("package "+packageName+";\n\n");
		sb.append("import cn.swyan.mavlink.annotation.MavlinkEnumMavCmdEntry;\n" +
				"import cn.swyan.mavlink.annotation.MavlinkEnumMavCmdEntryParam;\n");
		enumList.forEach(enumClass->{
			sb.append("import cn.swyan.mavlink.common.enums."+enumClass+";\n");
		});
		sb.append("\n" +
				"/**********************************\n" +
				" * @Author YSW\n" +
				" * @Description\n" +
				" * @Date "+format.format(new Date())+"\n" +
				" **********************************/\n" +
				"\n" +
				"@MavlinkEnumMavCmdEntry(");
		sb.append("value = "+value+"");
		sb.append(", name = \""+name+"\"");
		sb.append(", hasLocation = \""+hasLocation+"\"");
		sb.append(", isDestination = \""+isDestination+"\"");
		sb.append(", description = \""+description+"\"");
		sb.append(")\n" +
				"public enum "+className+" {\n");
		if (Objects.nonNull(paramsMap)){
			for (int i = 1; i <= paramsMap.size(); i++) {
				HashMap<String, Object> param = paramsMap.get(Integer.toString(i));
				if (Objects.nonNull(param)){
					String paramDescription = (String) param.get("description");
					if (Objects.nonNull(paramDescription)){
						paramDescription = paramDescription.replaceAll("\"", "'");
					}
					sb.append("\n\t/**\n" +
							"\t * "+paramDescription+"\n" +
							"\t */\n");
					sb.append("\t@MavlinkEnumMavCmdEntryParam(");
					sb.append("index = ").append(param.get("index"));
					param.forEach((attrKey,attrValue)->{
						if ("minValue".equals(attrKey) || "maxValue".equals(attrKey) || "increment".equals(attrKey)){
							sb.append(", ").append(attrKey).append(" = ").append(attrValue);
						} else if ("enum".equals(attrKey)){
							sb.append(", enum0 = ").append(StringModel.lineToBigHump((String) attrValue)).append(".class");
						} else if ("default".equals(attrKey)){
							sb.append(", default0 = \"").append(attrValue).append("\"");
						} else if("reserved".equals(attrKey) || "units".equals(attrKey) || "label".equals(attrKey)){
							sb.append(", ").append(attrKey).append(" = \"").append(attrValue).append("\"");
						}
					});
					sb.append(")\n");
					sb.append("\tPARAM_").append(param.get("index")).append("(),\n");
				}
			}
		}
		sb.append("}");
		String logMessage = className + ".java Create Success!------------------------------------------------------------";
		if (logMessage.getBytes().length > 85){
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
