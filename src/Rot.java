import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * TODO
 */

/**
 * @author luoqinglong
 * @date 2013-9-28
 */
public class Rot extends JFrame implements Runnable
{
	String rots = "转动字符的演示";
	CharPos[] charpos = new CharPos[this.rots.length()];
	JTextArea txt_play = new JTextArea(10, 32);
	JScrollPane span = new JScrollPane(this.txt_play, 22, 32);
	Thread thd = null;

	Rot()
	{
		for (int i = 0; i < this.rots.length(); i++)
		{
			String nows = this.rots.charAt(i) + "";
			this.charpos[i] = new CharPos(nows);
		}
		setBounds(20, 20, 1000, 700);
		add(this.span, "Center");
		setDefaultCloseOperation(3);
		setVisible(true);
		this.thd = new Thread(this);
		this.thd.start();
	}

	@Override
	public void run()
	{
		for (CharPos nowChar : this.charpos)
		{
			for (int i = 0; i < 60; i++)
			{
				this.txt_play.setText(nowChar.playSTR(6.0));
				try
				{
					Thread.currentThread();
					Thread.sleep(200);
				}
				catch (InterruptedException err)
				{
				}
			}
		}
	}

	public static void main(String[] ag)
	{
		new Rot();
	}
}

class CharPos
{
	int iw = 52, ih = 42;
	String fontSTR = null;
	StringBuffer bufstr = new StringBuffer("");
	BufferedImage bufimg = new BufferedImage(this.iw, this.ih, 1);
	Graphics2D buf1dc = (Graphics2D) this.bufimg.getGraphics();
	BufferedImage buf2img = new BufferedImage(this.iw, this.ih, 1);
	Graphics2D buf2dc = (Graphics2D) this.buf2img.getGraphics();

	CharPos(String fSTR)
	{
		this.fontSTR = fSTR;
		this.buf1dc.setColor(Color.white);
		this.buf1dc.fillRect(0, 0, this.iw, this.ih);
		this.buf1dc.setColor(Color.black);
		this.buf1dc.setFont(new Font(null, Font.BOLD, 24));
		this.buf1dc.drawString(this.fontSTR, 4, this.ih / 2 + this.ih / 12 - 1);
		this.buf1dc.drawString(this.fontSTR, 4, this.ih / 2 + this.ih / 12);
		this.buf2dc.setColor(Color.white);
		this.buf2dc.fillRect(0, 0, this.iw, this.ih);
	}

	public String playSTR(double Angle)
	{
		this.buf2dc.setColor(Color.white);
		this.buf2dc.fillRect(0, 0, this.iw, this.ih);
		this.buf2dc.rotate(Math.toRadians(Angle), this.iw / 2, this.ih / 2);
		this.buf2dc.drawImage(this.bufimg, 0, 0, this.iw, this.ih, 0, 0, 30, 30, null);
		this.bufstr.delete(0, this.bufstr.length());
		for (int y = 0; y < this.ih; y++)
		{
			for (int x = 0; x < this.iw; x++)
			{
				int r = this.buf2img.getRGB(x, y) & 0xff;
				this.bufstr.append(r > 127 ? "    " : this.fontSTR);
			}
			this.bufstr.append('\n');
		}
		return this.bufstr.toString();
	}
}
