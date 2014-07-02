/**
 * TODO
 */
package com.xeezee.array;

/**
 * 二分查找法
 * 
 * @author luoqinglong
 * @date 2012-7-30
 */
public class Half {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HighArray highArray = new HighArray(10);

		highArray.insertData(3);
		highArray.insertData(7);
		highArray.insertData(14);
		highArray.insertData(20);
		highArray.insertData(27);
		highArray.insertData(29);

		try {
			System.out.println(highArray.findKey(19));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class HighArray {
	private final long[] a;
	private int currentIndex = 0;

	public HighArray(long[] orig) {
		this.a = orig;

	}

	public HighArray(int caption) {
		this.a = new long[caption];

	}

	public void insertData(long value) {
		if (this.currentIndex < this.a.length) {
			this.a[this.currentIndex] = value;
			this.currentIndex++;
		}

	}

	public boolean deleteData(long value) {
		int j;// delete index
		for (j = 0; j < this.currentIndex; j++) {
			if (value == this.a[j]) {
				break;
			}
		}
		if (j == this.currentIndex) {
			return false;
		} else {
			for (int k = j; k < this.currentIndex; k++) {
				this.a[k] = this.a[k + 1];
			}
			this.currentIndex--;
			return true;
		}

	}

	/**
	 * 返回查找数组的index
	 * 
	 * @param searchData
	 * @return 数组的index
	 * @throws InterruptedException
	 */

	public int findKey(int searchData) throws InterruptedException {
		int lowerBound = 0;
		int upperBound = this.currentIndex - 1;
		int destIndex;
		while (true) {
			destIndex = (lowerBound + upperBound) / 2;

			if (this.a[destIndex] == searchData) {
				return destIndex;

			} else if (this.a[destIndex] > searchData) {
				upperBound = destIndex - 1;
			} else {
				lowerBound = destIndex + 1;
			}
			System.out.println(upperBound + "--" + lowerBound);
			// 没有找到数据
			if (upperBound < lowerBound) {
				break;
			}

		}
		return -1;

	}

	public long[] getA() {
		return this.a;
	}
}