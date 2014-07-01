/**
 * TODO
 */
package com.xeezee.img;

import java.awt.Image;

/**
 * @author luoqinglong
 * @date 2014-5-18
 */
public class Resizer
{
	private final int targetWidth;
	private final int targetHeight;
	private final boolean crop;
	private final boolean upscale;
	private final int cropPosition;

	public Resizer(int w, int h, boolean crop, boolean upscale, int cropPosition)
	{
		this.targetWidth = w;
		this.targetHeight = h;
		this.crop = crop;
		this.upscale = upscale;
		this.cropPosition = cropPosition;
	}

	public Resizer(int w, int h)
	{
		this.targetWidth = w;
		this.targetHeight = h;
		this.crop = false;
		this.upscale = false;
		this.cropPosition = -1;
	}

	/**
	 * 获取缩略图
	 * 
	 * @param soure
	 * @param scaleWith
	 * @param ScaleHeight
	 * @return
	 */
	public Image getScaledImg(Image soure)
	{
		int w = 0, h = 0;

		soure.getScaledInstance(w, h, Image.SCALE_SMOOTH);
		return null;
	}

	/**
	 * 获取裁剪图
	 */
	public Image getCropImg(Image soure)
	{
		return null;
	}

	/**
	 * 获取目标图
	 * 
	 * @param soure
	 * @return
	 */
	public Image getDestImg(Image soure)
	{
		Image dest = soure;
		if (this.upscale == true)
		{
			dest = this.getScaledImg(soure);
		}
		if (this.crop == true)
		{
			dest = this.getCropImg(dest);
		}
		return dest;
	}
}
