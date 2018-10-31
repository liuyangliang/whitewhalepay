package com.scut.whitewhalepay.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.apache.commons.io.FileUtils;

public class PicUtil {
	/**
	 * 保存图片
	 * 
	 * @param srcPic  	  源图片
	 * @param srcPicName 图片名称
	 * @return
	 * @throws Exception
	 */
	public static String save(File srcPic, String srcPicName) throws Exception{
		//需要自己定义图片保存路径
		String path = "W:/eclipse-workspace/whitewhalepay/src/main/webapp/img/"+new SimpleDateFormat("YYYY/MM/dd").format(new Date())+"/";
		File pathFile = new File(path);
		if (!pathFile.exists()) pathFile.mkdirs();
		String destPicName = UUID.randomUUID().toString() + srcPicName.substring(srcPicName.lastIndexOf("."));
		File destPic = new File(path + destPicName);
		destPic.createNewFile();
		FileUtils.copyFile(srcPic, destPic);
		return (path + destPicName);
	}
	
	/**
	 * 检测是否为图片（后缀名为.jpg/.jpeg/.png）
	 * 
	 * @param srcPicName 图片名称
	 * @return
	 */
	public static boolean isPic(String srcPicName) {
		if (srcPicName.substring(srcPicName.lastIndexOf(".")).equals(".jpg") || srcPicName.substring(srcPicName.lastIndexOf(".")).equals(".jpeg")
				|| srcPicName.substring(srcPicName.lastIndexOf(".")).equals(".png")) return true;
		return false;
	}
}
