import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JFrame;
import javax.swing.Timer;

/**
 * TODO
 */

/**
 * @author luoqinglong
 * @date 2013-10-13
 */
public class SinWave extends JFrame
{
	/**
	 * TODO
	 */
	private static final long serialVersionUID = 1L;
	private static final int NUM = 1000;
	private static final double TWOPI = 2 * 3.14;
	private static final int STEP = 10;
	private final int[] xPoints = new int[SinWave.NUM];
	private final int[] yPoints = new int[SinWave.NUM];
	private final int[] yCopyPoints = new int[SinWave.STEP];
	private int width, height;
	private final Timer timer;
	private final boolean move;

	public SinWave(boolean move)
	{
		this.move = move;
		this.setSize(500, 400);
		this.setBackground(Color.white);
		Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.width = this.getWidth();
		this.height = this.getHeight();
		this.setLocation((scrSize.width - this.width) / 2, (scrSize.height - this.height) / 2);
		for (int i = 0; i < SinWave.NUM; i++)
		{
			this.xPoints[i] = i * this.width / SinWave.NUM;
			this.yPoints[i] = (int) (this.height / 2 * (1 - Math.sin(SinWave.TWOPI * i / SinWave.NUM)));
		}
		this.setVisible(true);

		this.timer = new Timer(200, new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				for (int i = 0; i < SinWave.STEP; i++)
				{
					SinWave.this.yCopyPoints[i] = SinWave.this.yPoints[i];
				}
				for (int i = 0; i < SinWave.NUM - SinWave.STEP; i++)
				{
					SinWave.this.yPoints[i] = SinWave.this.yPoints[i + SinWave.STEP];
				}
				for (int i = 0; i < SinWave.STEP; i++)
				{
					SinWave.this.yPoints[i + SinWave.NUM - SinWave.STEP] = SinWave.this.yCopyPoints[i];
				}
				SinWave.this.repaint();
			}
		});

		this.addComponentListener(new ComponentAdapter()
		{
			@Override
			public void componentResized(ComponentEvent ce)
			{
				SinWave.this.width = SinWave.this.getWidth();
				SinWave.this.height = SinWave.this.getHeight();
				for (int i = 0; i < SinWave.NUM; i++)
				{
					SinWave.this.xPoints[i] = i * SinWave.this.width / SinWave.NUM;
					SinWave.this.yPoints[i] = (int) (SinWave.this.height / 2 * (1 - Math.sin(SinWave.TWOPI * i
							/ SinWave.NUM)));
				}
			}
		});
		this.timer.start();
		if (!this.move)
		{
			this.timer.stop();
		}
	}

	@Override
	public void paint(Graphics g)
	{
		super.paint(g);
		g.setColor(Color.red);
		g.drawLine(0, this.height / 2, this.width, this.height / 2);
		g.setColor(Color.green);
		g.drawPolyline(this.xPoints, this.yPoints, SinWave.NUM);
	}

	public static void main(String[] args)
	{
		SinWave sw = new SinWave(true); // 曲线是否运动 sw.setDefaultCloseOperation(EXIT_ON_CLOSE); }
	}
}
