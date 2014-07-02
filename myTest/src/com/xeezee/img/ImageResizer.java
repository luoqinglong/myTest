package com.xeezee.img;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 * gb2312
 * 
 * @author luoqinglong
 * @date 2014-5-18
 */
public class ImageResizer
{

	private final BufferedImage source;

	private final int sourceWidth;
	private final int sourceHeight;

	private int targetWidth;
	private int targetHeight;
	private boolean crop;
	private int cropPosition;
	private boolean upscale;
	private BufferedImage watermark;
	private int watermarkPosition;
	private int watermarkOffsetX;
	private int watermarkOffsetY;

	private int scaledWidth;
	private int scaledHeight;
	private int destinationWidth;
	private int destinationHeight;
	private int positionX;
	private int positionY;
	private BufferedImage destination;

	public ImageResizer(BufferedImage source)
	{
		this.source = source;
		this.sourceWidth = source.getWidth();
		this.sourceHeight = source.getHeight();
	}

	private void computePhotoSize()
	{
		float widthScale = (float) this.targetWidth / this.sourceWidth;
		float heightScale = (float) this.targetHeight / this.sourceHeight;

		if ((this.sourceWidth < this.targetWidth || this.sourceHeight < this.targetHeight) && this.upscale == false)
		{
			// ����Ҫ���ŵ����
			if (this.sourceWidth < this.targetWidth && this.sourceHeight < this.targetHeight)
			{
				// �ߺͿ���Ҫ��ȡ
				this.destinationWidth = this.scaledWidth = this.sourceWidth;
				this.destinationHeight = this.scaledHeight = this.sourceHeight;
			}
			else if ((this.sourceWidth < this.targetWidth && this.targetWidth <= 0 && this.upscale == false)
					|| (this.sourceHeight < this.targetHeight && this.targetWidth <= 0 && this.upscale == false))
			{
				this.destinationWidth = this.scaledWidth = this.sourceWidth;
				this.destinationHeight = this.scaledHeight = this.sourceHeight;
			}
			else if (this.sourceWidth < this.targetWidth)
			{
				if (this.crop)
				{
					// �Ѹ߽ص�
					this.destinationWidth = this.scaledWidth = this.sourceWidth;
					this.scaledHeight = this.sourceHeight;
					this.destinationHeight = this.targetHeight;
				}
				else
				{
					// ���Ÿ߶�
					this.destinationHeight = this.scaledHeight = this.targetHeight;
					this.destinationWidth = this.scaledWidth = (int) (this.sourceWidth * heightScale);
				}
			}
			else if (this.sourceHeight < this.targetHeight)
			{
				if (this.crop)
				{
					// �ѿ�ص�
					this.destinationWidth = this.targetWidth;
					this.scaledWidth = this.sourceWidth;
					this.destinationHeight = this.scaledHeight = this.sourceHeight;
				}
				else
				{
					// ���ſ��
					this.destinationWidth = this.scaledWidth = this.targetWidth;
					this.destinationHeight = this.scaledHeight = (int) (this.sourceHeight * widthScale);
				}
			}
		}
		else
		{
			// ��Ҫ���ŵ����
			if (this.targetWidth > 0 && this.targetHeight <= 0)
			{
				// ���ſ�ȣ��߶Ȳ�������
				this.destinationWidth = this.scaledWidth = this.targetWidth;
				this.destinationHeight = this.scaledHeight = (int) (this.sourceHeight * widthScale);
			}
			else if (this.targetWidth <= 0 && this.targetHeight > 0)
			{
				// ���Ÿ߶ȣ���Ȳ�������
				this.destinationWidth = this.scaledWidth = (int) (this.sourceWidth * heightScale);
				this.destinationHeight = this.scaledHeight = this.targetHeight;
			}
			else
			{
				// �߶ȺͿ�ȶ�������
				if (this.crop == false)
				{
					// ����Ҫ����
					if (widthScale > heightScale)
					{
						// ���Ÿ߶�
						this.destinationHeight = this.scaledHeight = this.targetHeight;
						this.destinationWidth = this.scaledWidth = (int) (this.sourceWidth * heightScale);
					}
					else
					{
						// ���ſ��
						this.destinationWidth = this.scaledWidth = this.targetWidth;
						this.destinationHeight = this.scaledHeight = (int) (this.sourceHeight * widthScale);
					}
				}
				else
				{
					// ��Ҫ����
					if (widthScale > heightScale)
					{
						// ���ſ��
						this.destinationWidth = this.scaledWidth = this.targetWidth;
						this.destinationHeight = this.scaledHeight = (int) (this.sourceHeight * widthScale);
						if (this.destinationHeight > this.targetHeight)
						{
							this.destinationHeight = this.targetHeight;
						}
					}
					else
					{
						// ���Ÿ߶�
						this.destinationHeight = this.scaledHeight = this.targetHeight;
						this.destinationWidth = this.scaledWidth = (int) (this.sourceWidth * heightScale);
						if (this.destinationWidth > this.targetWidth)
						{
							this.destinationWidth = this.targetWidth;
						}
					}
				}
			}
		}
		if (this.cropPosition == 0)
		{
			// ����ͷ���͵ײ�
			this.positionX = (this.destinationWidth - this.scaledWidth) / 2;
			this.positionY = (this.destinationHeight - this.scaledHeight) / 2;
		}
		else if (this.cropPosition < 0)
		{
			// ���еײ�
			this.positionX = (this.destinationWidth - this.scaledWidth) / 2;
			this.positionY = 0;
		}
		else if (this.cropPosition > 0)
		{
			// ����ͷ��
			this.positionX = (this.destinationWidth - this.scaledWidth) / 2;
			this.positionY = this.destinationHeight - this.scaledHeight;
		}
	}

	public BufferedImage resize()
	{
		if (this.destination != null)
		{
			return this.destination;
		}
		this.computePhotoSize();
		this.destination = new BufferedImage(this.destinationWidth, this.destinationHeight, BufferedImage.TYPE_INT_BGR);
		Graphics g = this.destination.createGraphics();
		Image newImage = this.source;
		// ʹ��Image.SCALE_SMOOTH����Ϊƽ��������
		if (this.scaledWidth != this.sourceWidth || this.scaledHeight != this.sourceHeight)
		{
			newImage = this.source.getScaledInstance(this.scaledWidth, this.scaledHeight, Image.SCALE_SMOOTH);
		}
		g.drawImage(newImage, this.positionX, this.positionY, null);
		this.addWatermark(g);
		g.dispose();
		return this.destination;
	}

	/**
	 * ��ˮӡ
	 * 
	 * @param g
	 */
	private void addWatermark(Graphics g)
	{
		if (this.watermark != null)
		{
			int watermarkWidth = this.watermark.getWidth();
			int watermarkHeight = this.watermark.getHeight();
			int watermarkPositionX = 0;
			int watermarkPositionY = 0;
			switch (this.watermarkPosition) {
			case 0:
				// ͼƬ����
				watermarkPositionX = (int) (((float) this.destinationWidth - watermarkWidth) / 2)
						+ this.watermarkOffsetX;
				watermarkPositionY = (int) (((float) this.destinationHeight - watermarkHeight) / 2)
						+ this.watermarkOffsetY;
				break;
			case 1:
				// ���Ͻ�
				watermarkPositionX = (this.destinationWidth - watermarkWidth) + this.watermarkOffsetX;
				watermarkPositionY = this.watermarkOffsetY;
				break;
			case 3:
				// ���½�
				watermarkPositionX = this.watermarkOffsetX;
				watermarkPositionY = (this.destinationHeight - watermarkHeight) + this.watermarkOffsetY;
				break;
			case 4:
				// ���Ͻ�
				watermarkPositionX = this.watermarkOffsetX;
				watermarkPositionY = this.watermarkOffsetY;
				break;
			default:
				// �������0-4���Ǿ���ˮӡλ��Ϊ���½�
				watermarkPositionX = (this.destinationWidth - watermarkWidth) + this.watermarkOffsetX;
				watermarkPositionY = (this.destinationHeight - watermarkHeight) + this.watermarkOffsetY;
			}
			g.drawImage(this.watermark, watermarkPositionX, watermarkPositionY, null);
		}
	}

	public void setTargetSize(int targetWidth, int targetHeight)
	{
		this.targetWidth = targetWidth;
		this.targetHeight = targetHeight;
	}

	public void setCrop(boolean crop)
	{
		this.crop = crop;
	}

	public void setCropPosition(int cropPosition)
	{
		this.cropPosition = cropPosition;
	}

	public void setUpscale(boolean upscale)
	{
		this.upscale = upscale;
	}

	public void setWatermark(BufferedImage watermark)
	{
		this.watermark = watermark;
	}

	public void setWatermarkPosition(int watermarkPosition)
	{
		this.watermarkPosition = watermarkPosition;
	}

	public void setWatermarkOffset(int watermarkOffsetX, int watermarkOffsetY)
	{
		this.watermarkOffsetX = watermarkOffsetX;
		this.watermarkOffsetY = watermarkOffsetY;
	}
}
