package com.xeezee.verify;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

/**
 * TODO
 */

/**
 * 验证码
 * 
 * @author luoqinglong
 * @date 2013-10-11
 */
public class TestCode
{
	public static final String RANDOMCODEKEY = "RANDOMVALIDATECODEKEY";// 放到session中的key
	private final Random random = new Random();
	private final String randString = "23467ABCDEFGHIJKLMNOPQRSTUVWXYZ";// 随机产生的字符串

	private final int width = 120;// 图片宽
	private final int height = 40;// 图片高
	private final int lineSize = 1;// 干扰线数量
	private final int stringNum = 4;// 随机产生字符数量

	/*
	 * 获得颜色
	 */
	private Color getRandColor(int fc, int bc)
	{
		if (fc > 255)
		{
			fc = 255;
		}
		if (bc > 255)
		{
			bc = 255;
		}
		int r = fc + this.random.nextInt(bc - fc - 16);
		int g = fc + this.random.nextInt(bc - fc - 14);
		int b = fc + this.random.nextInt(bc - fc - 18);
		return new Color(r, g, b);
	}

	/**
	 * 生成随机图片
	 */
	public void getRandcode(HttpServletRequest request, HttpServletResponse response)
	{
		HttpSession session = request.getSession();
		// BufferedImage类是具有缓冲区的Image类,Image类是用于描述图像信息的类
		BufferedImage image = new BufferedImage(this.width, this.height, BufferedImage.TYPE_INT_BGR);
		Graphics g = image.getGraphics();// 产生Image对象的Graphics对象,改对象可以在图像上进行各种绘制操作
		g.fillRect(0, 0, this.width, this.height);
		g.setFont(this.getFont());
		g.setColor(this.getRandColor(110, 133));
		// 绘制干扰线
		for (int i = 0; i <= this.lineSize; i++)
		{
			this.drowLine(g);
		}
		// 绘制随机字符
		String randomString = "";
		for (int i = 1; i <= this.stringNum; i++)
		{
			randomString = this.drowString(g);
		}
		session.removeAttribute(TestCode.RANDOMCODEKEY);
		session.setAttribute(TestCode.RANDOMCODEKEY, randomString);
		System.out.println(randomString);
		g.dispose();
		try
		{
			ImageIO.write(image, "JPEG", response.getOutputStream());// 将内存中的图片通过流动形式输出到客户端
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void getRandcode(FileOutputStream fileOutputStream)
	{
		// HttpSession session = request.getSession();
		// BufferedImage类是具有缓冲区的Image类,Image类是用于描述图像信息的类
		BufferedImage image = new BufferedImage(this.width, this.height, BufferedImage.TYPE_INT_BGR);
		Graphics g = image.getGraphics();// 产生Image对象的Graphics对象,改对象可以在图像上进行各种绘制操作
		g.setColor(this.getBackGroudColor());
		g.fillRect(0, 0, this.width, this.height);
		// g.setFont(this.getFont());

		// 绘制随机字符
		String code = this.drowString(g);
		System.out.println(code);
		// 绘制干扰线
		for (int i = 0; i < this.lineSize; i++)
		{
			this.drowLine(g);
		}
		g.dispose();

		try
		{
			ImageIO.write(image, "JPEG", fileOutputStream);// 将内存中的图片通过流动形式输出到客户端
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/*
	 * 绘制字符串
	 */
	private String drowString(Graphics gg)
	{
		Graphics2D g = (Graphics2D) gg;
		String randomString = "";
		for (int i = 1; i <= this.stringNum; i++)
		{

			g.setFont(this.getFont());
			g.setColor(this.getFontColor());
			String rand = String.valueOf(this.getRandomString(this.random.nextInt(this.randString.length())));

			TestCode.changeRotation(g, 20 * i, 25);

			g.drawString(rand, 20 * i, 25);

			randomString += rand;
		}

		// 合并曲线和验证码
		// gg.drawImage(this.drawInterferLine(), 0, 0, null);
		return randomString;
	}

	/*
	 * 绘制干扰线
	 */
	private void drowLine(Graphics g)
	{
		int x = this.random.nextInt(this.width / 4);
		int y = this.random.nextInt(this.height);
		int xl = this.width - x;
		int yl = this.height - y;
		g.setColor(this.getLineColor());
		// 加粗线条
		System.out.println("起点：" + x + "_" + y);
		System.out.println("终点：" + xl + "_" + yl);
		// System.out.println(g.getClipBounds().getX() + "_" + g.getClipBounds().getY());
		for (int i = 0; i < 3; i++)
		{
			// g.drawLine(x + i, y + i, xl + i, yl + i);
			g.drawLine(1, 1, 20, 20);
		}

	}

	/*
	 * 获取随机的字符
	 */
	public String getRandomString(int num)
	{
		return String.valueOf(this.randString.charAt(num));
	}

	/**
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException
	{
		TestCode testCode = new TestCode();
		String parent = "F:\\code";
		File file = new File(parent);
		String fileName = "124.jpg";
		if (!file.exists())
		{
			file.mkdirs();
		}
		FileOutputStream fileOutputStream = new FileOutputStream(new File(parent, fileName));
		testCode.getRandcode(fileOutputStream);
		MessageDigest messageDigest = null;

		try
		{
			messageDigest = MessageDigest.getInstance("MD5");
			byte[] s = messageDigest.digest("1111".getBytes());
			System.out.println(new String(s.toString()));

		}
		catch (NoSuchAlgorithmException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 旋转字符
	 * 
	 * @param g
	 */
	static void changeRotation(Graphics g, int x, int y)
	{
		int[] angles_plus = { 5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55, 60 };
		int[] angles_minus = { -5, -10, -15, -20, -25, -30, -35, -40, -45, -50, -55, -60 };

		Random ra = new Random();
		AffineTransform at = new AffineTransform();
		int[] angles;

		angles = angles_plus;

		int r = ra.nextInt(angles.length);
		// System.out.println(angles[r]);
		at.setToRotation(angles[r] * Math.PI / 180, x, y);
		((Graphics2D) g).setTransform(at);

	}

	/**
	 * 获取随机字体
	 * 
	 * @return
	 */
	public Font getFont()
	{
		Font[] font = GraphicsEnvironment.getLocalGraphicsEnvironment().getAllFonts();
		// 随机名称
		String name = font[this.random.nextInt(font.length - 1)].getFontName();

		return new Font("Tahoma", Font.BOLD, 28);

	}

	public Color getFontColor()
	{
		return new Color(204, 153, 000);
	}

	public Color getBackGroudColor()
	{
		Color[] color = new Color[1];
		// color[0] = new Color(204, 255, 204);
		color[0] = new Color(255, 255, 255);
		return color[this.random.nextInt(color.length)];
	}

	public Color getLineColor()
	{
		return new Color(204, 153, 000);
	}

	/**
	 * 画一条曲线干扰线
	 */
	BufferedImage drawInterferLine()
	{
		BufferedImage image = new BufferedImage(this.width, this.height, BufferedImage.TYPE_INT_BGR);
		Graphics g = image.getGraphics();// 产生Image对象的Graphics对象,改对象可以在图像上进行各种绘制操作
		g.fillRect(0, 0, this.width, this.height);
		g.setFont(this.getFont());
		g.setColor(this.getFontColor());

		double dMultValue = this.random.nextInt(2) + 3;// 波形的幅度倍数，越大扭曲的程序越高，一般为3
		double dPhase = this.random.nextInt(2);// 波形的起始相位，取值区间（0-2＊PI）

		for (int i = 0; i < image.getWidth(); i++)
		{
			for (int j = 0; j < image.getHeight(); j++)
			{
				int nOldX = this.getXPosition4Twist(dPhase, dMultValue, image.getHeight(), i, j);
				int nOldY = j;
				if (nOldX >= 0 && nOldX < image.getWidth() && nOldY >= 0 && nOldY < image.getHeight())
				{
					image.setRGB(nOldX, nOldY, new Color(200, 200, 200).getRGB());
				}
			}
		}

		return image;

	}

	private int getXPosition4Twist(double dPhase, double dMultValue, int height, int xPosition, int yPosition)
	{
		double PI = 3.1415926535897932384626433832799; // 此值越大，扭曲程度越大
		double dx = (PI * yPosition) / height + dPhase;
		double dy = Math.sin(dx);
		return xPosition + (int) (dy * dMultValue);
	}

	/**
	 * 缩放图片
	 * 
	 * @param file1
	 * @param file2
	 */
	public void zoom(String file1, String file2)
	{

		try
		{
			// 读入图片

			File _file = new File(file1);
			Image src = javax.imageio.ImageIO.read(_file); // 构造Image对象

			int width = src.getWidth(null); // 得到图宽

			int height = src.getHeight(null); // 得到图长

			// 图片放缩

			BufferedImage tag = new BufferedImage(width / 2, height / 2, BufferedImage.TYPE_INT_RGB);

			tag.getGraphics().drawImage(src, 0, 0, width / 2, height / 2, null); // 绘制缩小后的图

			// 写入图片

			FileOutputStream out = new FileOutputStream(file2); // 输出到文件流

			JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);

			encoder.encode(tag); // JPEG编码

			out.close();

		}
		catch (Exception e)
		{

		}
	}
}
