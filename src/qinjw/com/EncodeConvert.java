package qinjw.com;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;

public class EncodeConvert {

	/**
	 * java&jsp ת����ʽ( Ĭ��: UTF-8 2 GBK )
	 * 
	 * @param inpath
	 * @param outpath
	 * @author qinjw
	 * @date 2016-05-25 14:12:07
	 */
	public void convertUTF82GBK(String inpath, String outpath) {
		convert(inpath, outpath, EncodeType.UFT8, EncodeType.GBK, new String[]{ "java", "jsp" });
	}
	
	/**
	 * inFileType ת����ʽ( Ĭ��: UTF-8 2 GBK )
	 * 
	 * @param inpath
	 * @param outpath
	 * @param inFileType
	 * @author qinjw
	 * @date 2016-05-25 14:46:05
	 */
	public void convertUTF82GBK(String inpath, String outpath, String[] inFileType) {
		convert(inpath, outpath, EncodeType.UFT8, EncodeType.GBK, inFileType);
	}
	
	/**
	 * java ת����ʽ( Ĭ��: UTF-8 2 GBK )
	 * 
	 * @param inpath
	 * @param outpath
	 * @author qinjw
	 * @date 2016-05-25 14:46:23
	 */
	public void convertUTF82GBK_JAVA(String inpath, String outpath) {
		convert(inpath, outpath, EncodeType.UFT8, EncodeType.GBK, new String[]{ "java" });
	}
	
	/**
	 * jsp ת����ʽ( Ĭ��: UTF-8 2 GBK )
	 * 
	 * @param inpath
	 * @param outpath
	 * @author qinjw
	 * @date 2016-05-25 14:46:40
	 */
	public void convertUTF82GBK_JSP(String inpath, String outpath) {
		convert(inpath, outpath, EncodeType.UFT8, EncodeType.GBK, new String[]{ "jsp" });
	}
	
	/**
	 * java ת����ʽ( Ĭ��: GBK 2 UTF-8 )
	 * 
	 * @param inpath
	 * @param outpath
	 * @author qinjw
	 * @date 2016-05-25 14:46:40
	 */
	public void convertGBK2UTF8_JAVA(String inpath, String outpath) {
		convert(inpath, outpath, EncodeType.GBK, EncodeType.UFT8, new String[]{ "java" });
	}
	/**
	 * jsp ת����ʽ( Ĭ��: GBK 2 UTF-8 )
	 * 
	 * @param inpath
	 * @param outpath
	 * @author qinjw
	 * @date 2016-05-25 14:46:40
	 */
	public void convertGBK2UTF8_JSP(String inpath, String outpath) {
		convert(inpath, outpath, EncodeType.GBK, EncodeType.UFT8, new String[]{ "jsp" });
	}
	
	/**
	 * java&jsp ת����ʽ( Ĭ��: GBK 2 UTF-8 )
	 * 
	 * @param inpath
	 * @param outpath
	 * @author qinjw
	 * @date 2016-05-25 14:12:07
	 */
	public void convertGBK2UTF8(String inpath, String outpath) {
		convert(inpath, outpath, EncodeType.GBK, EncodeType.UFT8, new String[]{ "java", "jsp" });
	}
	
	/**
	 * inFileType ת����ʽ( Ĭ��: UTF-8 2 GBK )
	 * 
	 * @param inpath
	 * @param outpath
	 * @param inFileType
	 * @author qinjw
	 * @date 2016-05-25 14:46:05
	 */
	public void convertGBK2UTF8(String inpath, String outpath, String[] inFileType) {
		convert(inpath, outpath, EncodeType.GBK, EncodeType.UFT8, inFileType);
	}
	
	public void convert(String inpath, String outpath, EncodeType inEncodeType, EncodeType outEncodeType, String[] inFileType) {
		try {
			Assert.assertNotNull("�ļ���׺Ϊ��!", inFileType);
			Assert.assertNotNull("Դ�ļ�·��Ϊ��!", inpath);
			Assert.assertNotNull("����ļ�·��Ϊ��!", outpath);
			Assert.assertNotNull("Դ�ļ������ʽΪ��!", inEncodeType);
			Assert.assertNotNull("����ļ������ʽΪ��!", outEncodeType);
			
			Collection<File> inFileCol = FileUtils.listFiles(new File(inpath), inFileType, true);
			for (File inFile : inFileCol) {
				String outFilePath = outpath + inFile.getAbsolutePath().substring(inpath.length());
				FileUtils.writeLines(new File(outFilePath), outEncodeType.getValue(), FileUtils.readLines(inFile, inEncodeType.getValue()));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new EncodeConvert().convertUTF82GBK("D:\\workspace\\workspace_6.5.0\\interface-master\\ssm3", "D:\\workspace\\workspace_6.5.0\\interface-master\\ssm3_bak");
	}
}

enum EncodeType {
	UFT8( "UTF-8", "UTF-8" ),
	GBK( "GBK", "GBK" ),
	GB2312( "GB2312", "GB2312" )
	;
	private String name;
	private String value;
	
	EncodeType(String name, String value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}
	
	public String getValue() {
		return value;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setValue(String value) {
		this.value = value;
	}
}
