package cn.wsyjlly.mavlink.descriptor;

/**********************************
 * Author YSW
 * Description
 * Date 2020.10.29 - 20:42
 **********************************/

public class FileGenerator {

	public static void generator(String srcFile, String targetFolder){
		new EnumDescriptor().descriptor(srcFile, targetFolder+"\\enums");
		new MavCmdEnumDescriptor().descriptor(srcFile, targetFolder+"\\enums\\mav\\cmd");
		new MessageDescriptor().descriptor(srcFile, targetFolder+"\\messages");
	}

}
