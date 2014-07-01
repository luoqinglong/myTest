/**
 * TODO
 */
package com.xeezee.pic;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

/**
 * @author luoqinglong
 * @date 2012-9-2
 */
public class MyResize {
	private final String srcFile;
	private String destFile;
	private final int width;
	private final int height;
	private final Image img;

	/**
	 * 构造函数
	 * 
	 * @param fileName String
	 * @throws IOException
	 */
	public MyResize(String fileName) throws IOException {
		File _file = new File(fileName); // 读入文件
		this.srcFile = _file.getName();
		this.destFile = "F:/testImg/" + "new_" + this.srcFile;// this.srcFile.substring(0,
																// this.srcFile.lastIndexOf(".")) +"_s.jpg";
		this.img = javax.imageio.ImageIO.read(_file); // 构造Image对象
		this.width = this.img.getWidth(null); // 得到源图宽
		this.height = this.img.getHeight(null); // 得到源图长
	}

	/**
	 * 强制压缩/放大图片到固定的大小
	 * 
	 * @param w int 新宽度
	 * @param h int 新高度
	 * @throws IOException
	 */
	public void resize(int w, int h) throws IOException {

		// BufferedImage _image = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
		// _image.getGraphics().drawImage(this.img, 0, 0, w, h, null); // 绘制缩小后的图
		int staticWidth = 900;
		int staticHeight = 600;
		BufferedImage _image = new BufferedImage(staticWidth, staticHeight, BufferedImage.TYPE_INT_RGB);// 指定画布的大小
		Graphics g = _image.getGraphics();
		// 设置背景色为白色
		g.setColor(Color.white);
		// 设置背景色的填充区域
		g.fillRect(0, 0, staticWidth, staticHeight);
		g.drawImage(this.img, (staticWidth - w) / 2, (staticHeight - h) / 2, w, h, null); // 绘制缩小后的图

		FileOutputStream newimageout = new FileOutputStream(this.destFile); // 输出到文件流
		/*
		 * JPEGImageEncoder 将图像缓冲数据编码为 JPEG 数据流。该接口的用户应在 Raster 或 BufferedImage 中提供图像数据，在 JPEGEncodeParams 对象中设置必要的参数，
		 * 并成功地打开 OutputStream（编码 JPEG 流的目的流）。JPEGImageEncoder 接口可 将图像数据编码为互换的缩略 JPEG 数据流，该数据流将写入提供给编码器的 OutputStream 中。
		 * 注意：com.sun.image.codec.jpeg 包中的类并不属于核心 Java API。它们属于 Sun 发布的 JDK 和 JRE 产品的组成部分。虽然其它获得许可方可能选择发布这些类，但开发人员不能寄
		 * 希望于从非 Sun 实现的软件中得到它们。我们期望相同的功能最终可以在核心 API 或标准扩 展中得到。
		 */
		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(newimageout);
		encoder.encode(_image); // 近JPEG编码
		newimageout.close();
	}

	/**
	 * 按照固定的比例缩放图片
	 * 
	 * @param t double 比例
	 * @throws IOException
	 */
	public void resize(double t) throws IOException {
		int w = (int) (this.width * t);
		int h = (int) (this.height * t);
		this.resize(w, h);
	}

	/**
	 * 以宽度为基准，等比例放缩图片
	 * 
	 * @param w int 新宽度
	 * @throws IOException
	 */
	public void resizeByWidth(int w) throws IOException {
		int h = (this.height * w / this.width);
		this.resize(w, h);
	}

	/**
	 * 以高度为基准，等比例缩放图片
	 * 
	 * @param h int 新高度
	 * @throws IOException
	 */
	public void resizeByHeight(int h) throws IOException {
		int w = (this.width * h / this.height);
		this.resize(w, h);
	}

	/**
	 * 按照最大高度限制，生成最大的等比例缩略图
	 * 
	 * @param w int 最大宽度
	 * @param h int 最大高度
	 * @throws IOException
	 */
	public void resizeFix(int w, int h) throws IOException {
		if (this.width / this.height > w / h) {
			this.resizeByWidth(w);
		} else {
			this.resizeByHeight(h);
		}
	}

	/**
	 * 设置目标文件名 setDestFile
	 * 
	 * @param fileName String 文件名字符串
	 */
	public void setDestFile(String fileName) throws Exception {
		if (!fileName.endsWith(".jpg")) {
			throw new Exception("Dest File Must end with \".jpg\".");
		}
		this.destFile = fileName;
	}

	/**
	 * 获取目标文件名 getDestFile
	 */
	public String getDestFile() {
		return this.destFile;
	}

	/**
	 * 获取图片原始宽度 getSrcWidth
	 */
	public int getSrcWidth() {
		return this.width;
	}

	/**
	 * 获取图片原始高度 getSrcHeight
	 */
	public int getSrcHeight() {
		return this.height;
	}

	/*
	 * 调用测试
	 */
	public static void main(String[] args) throws Exception {
		MyResize ccc = new MyResize("F:/testImg/3333.jpg");
		ccc.resizeFix(600, 300);
		// ccc.test01();
	}

	public void test01() {
		int width = 100;
		int height = 100;
		String s = "你好";
		File file = new File("F:/testImg/image.jpg");
		Font font = new Font("Serif", Font.BOLD, 10);
		// 创建一个画布
		BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB); // 获取画布的画笔
		Graphics2D g2 = (Graphics2D) bi.getGraphics();
		// 开始绘图
		g2.setBackground(Color.WHITE);
		g2.clearRect(0, 0, width, height);
		g2.setPaint(new Color(0, 0, 255));
		g2.fillRect(0, 0, 100, 10);
		g2.setPaint(new Color(253, 2, 0));
		g2.fillRect(0, 10, 100, 10);
		g2.setPaint(Color.red);
		FontRenderContext context = g2.getFontRenderContext();
		Rectangle2D bounds = font.getStringBounds(s, context);
		double x = (width - bounds.getWidth()) / 2;
		double y = (height - bounds.getHeight()) / 2;
		double ascent = -bounds.getY();
		double baseY = y + ascent;
		// 绘制字符串 34.
		g2.drawString(s, (int) x, (int) baseY);
		try {
			// 将生成的图片保存为jpg格式的文件。ImageIO支持jpg、png、gif等格式
			ImageIO.write(bi, "jpg", file);
		} catch (IOException e) {
			System.out.println("生成图片出错........");
			e.printStackTrace();
		}
	}

}
