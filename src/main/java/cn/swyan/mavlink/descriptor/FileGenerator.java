package cn.swyan.mavlink.descriptor;

/**********************************
 * @Author YSW
 * @Description
 * @Date 2020.10.29 - 20:42
 **********************************/

public class FileGenerator {

	/*public static void main(String[] args) {
		generator("D:\\IDEA\\SpringBoot\\mavlink\\src\\main\\resources\\minimal.xml",
				"D:\\IDEA\\SpringBoot\\mavlink\\src\\main\\java\\cn\\swyan\\mavlink\\common");
		generator("D:\\IDEA\\SpringBoot\\mavlink\\src\\main\\resources\\common-v1.xml",
				"D:\\IDEA\\SpringBoot\\mavlink\\src\\main\\java\\cn\\swyan\\mavlink\\common");
	}*/

	public static void generator(String srcFile, String targetFolder){
		new EnumDescriptor().descriptor(srcFile, targetFolder+"\\enums");
		new MavCmdEnumDescriptor().descriptor(srcFile, targetFolder+"\\enums\\mav\\cmd");
		new MessageDescriptor().descriptor(srcFile, targetFolder+"\\messages");
	}
}
