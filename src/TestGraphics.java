import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * TODO
 */

/**
 * @author luoqinglong
 * @date 2013-10-14
 */
public class TestGraphics
{
	private static final int width = 120;// 图片宽
	private static final int height = 40;// 图片高

	/**
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException
	{
		TestCode testCode = new TestCode();
		String filenameString = "F:\\gg.jpg";
		FileOutputStream fileOutputStream = new FileOutputStream(new File(filenameString));
		BufferedImage image = new BufferedImage(TestGraphics.width, TestGraphics.height, BufferedImage.TYPE_INT_BGR);
		Graphics g = image.getGraphics();// 产生Image对象的Graphics对象,改对象可以在图像上进行各种绘制操作
		g.setColor(TestGraphics.getBackGroudColor());
		g.fillRect(0, 0, TestGraphics.width, TestGraphics.height);

		g.setFont(TestGraphics.getFont());
		g.setColor(TestGraphics.getFontColor());

		g.drawString("---", 0, 25);
		g.dispose();

		try
		{
			ImageIO.write(image, "JPEG", fileOutputStream);
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// 将内存中的图片通过流动形式输出到客户端
	}

	public static Color getBackGroudColor()
	{
		Color[] color = new Color[1];
		color[0] = new Color(255, 255, 255);
		return color[0];
	}

	public static Font getFont()
	{

		return new Font("Tahoma", Font.BOLD, 28);

	}

	public static Color getFontColor()
	{
		return new Color(204, 153, 000);
	}

}
