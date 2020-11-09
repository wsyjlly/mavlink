package cn.swyan.mavlink.descriptor;

import cn.swyan.mavlink.protocol.util.StringModel;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.List;

/**********************************
 * Author YSW
 * Description
 * Date 2020.10.26 - 14:42
 **********************************/

public class MessageMapDescriptor implements MavlinkDescriptor {
	public static void main(String[] args) {
		new MessageMapDescriptor().descriptor(
				"D:\\IDEA\\SpringBoot\\mavlink\\src\\main\\resources\\common-v1.xml",
				"D:\\IDEA\\SpringBoot\\mavlink\\src\\main\\java\\cn\\swyan\\mavlink\\common"
		);
	}


	/**
	 * 解析Mavlink Common.xml minimal.xml 及遵循Mavlink规范的自定义xml ,生成Java 映射类
	 *
	 * param srcFile
	 * param targetFolder
	 */
	@Override
	public void descriptor(String srcFile, String targetFolder) {
		try {
			Document doc = new SAXReader().read(new File((srcFile)));
			Element messages = doc.getRootElement().elements("messages").get(0);
			List<Element> elements = messages.elements("message");
			
			for (Element message: elements){
				System.out.println("MESSAGE_BOX.put("+message.attributeValue("id")+", "+ StringModel.lineToBigHump(message.attributeValue("name")) +".class);");
			}
//			createMessageMapJavaFile()
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
}
