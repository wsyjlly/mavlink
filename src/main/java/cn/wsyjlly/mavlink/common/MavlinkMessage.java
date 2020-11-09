package cn.wsyjlly.mavlink.common;

import cn.wsyjlly.mavlink.protocol.util.StringModel;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.HashMap;
import java.util.List;

/**********************************
 * Author YSW
 * Description
 * Date 2020.10.30 - 12:34
 **********************************/

public class MavlinkMessage {

	public static final HashMap<Integer,Class<? extends Message>> MESSAGE_BOX = new HashMap<>();

	static {
		   readMessageMap("D:\\IDEA\\SpringBoot\\mavlink\\src\\main\\resources\\minimal.xml");
		   readMessageMap("D:\\IDEA\\SpringBoot\\mavlink\\src\\main\\resources\\common-v1.xml");
	}
	private static void readMessageMap(String srcFile){
		try {
			Document doc = new SAXReader().read(new File((srcFile)));
			Element messages = doc.getRootElement().elements("messages").get(0);
			List<Element> elements = messages.elements("message");
			for (Element message: elements){
				Class<? extends Message> messageClass = (Class<Message>) Class.forName("cn.swyan.mavlink.common.messages."+StringModel.lineToBigHump(message.attributeValue("name")));
				MESSAGE_BOX.put(Integer.parseInt(message.attributeValue("id")),messageClass);
			}
		} catch (DocumentException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}