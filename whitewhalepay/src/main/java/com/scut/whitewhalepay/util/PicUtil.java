package com.scut.whitewhalepay.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		String path = "D:/Web/whitewhalepay/src/main/webapp/img/"+new SimpleDateFormat("YYYY/MM/dd").format(new Date())+"/";
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
	
	/**
	 * 
	 * @param addr
	 * @return
	 */
	public static BufferedImage getInputStream(String addr){
        try {
            String imgPath = addr;  
            BufferedImage image = ImageIO.read(new FileInputStream(imgPath));
            return image;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println();
            System.out.println("获取图片异常:java.awt.image.BufferedImage");
            System.out.println("请检查图片路径是否正确，或者该地址是否为一个图片");
        }
        return null;
    }
	
	
	public void getImage( HttpServletRequest request, HttpServletResponse response) {
	    String addr="D:/Web/whitewhalepay/src/main/webapp/img/Alipaycode/hello.png";
        BufferedImage img = new BufferedImage(300, 150, BufferedImage.TYPE_INT_RGB);
        img = PicUtil.getInputStream(addr);
        if(img==null){
            throw new RuntimeException("打印图片异常：com.controller.Business_Ctrl.getImg(String, HttpServletResponse)");
        }
        if(img!=null){
            try {
                ImageIO.write(img, "png", response.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("打印异常:com.controller.Business_Ctrl.getImg(String, HttpServletResponse)");
            }
        }
    }
	
	
}
