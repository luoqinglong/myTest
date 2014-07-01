package com.xeezee.img;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

/**
 * gb2312
 * 
 * @author luoqinglong
 * @date 2014-5-18
 */
public class Test
{

	public static void main(String[] args) throws IOException
	{
		BufferedImage source = ImageIO.read(new File("E:\\1-source.jpg"));
		Map<String, String> map = new HashMap<String, String>();
		ImageResizer resizer = new ImageResizer(source);
		resizer.setTargetSize(1000, 700);
		resizer.setUpscale(true);
		resizer.setCrop(true);
		resizer.setCropPosition(-1);
		BufferedImage result = resizer.resize();
		ImageIO.write(result, "jpg", new File("E:\\2-destination.jpg"));
	}
}
