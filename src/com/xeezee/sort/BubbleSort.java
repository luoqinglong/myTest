/**
 * TODO
 */
package com.xeezee.sort;

/**
 * 冒泡排序
 * 
 * @author luoqinglong
 * @date 2012-7-30
 */
public class BubbleSort {
	private final long[] origArr = new long[] { 12, 65, 2, 33, 89, 23, 10 };
	private final static int SORT_DEST = 0;
	private final static int SORT_ASC = 1;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BubbleSort bubbleSort = new BubbleSort();
		bubbleSort.sort(bubbleSort.origArr, BubbleSort.SORT_DEST);

		for (int j = 0; j < bubbleSort.origArr.length; j++) {
			System.out.println(bubbleSort.origArr[j]);
		}

	}

	public void sort(long[] arrays, int sortType) {
		int len = this.origArr.length;
		System.out.println(len);
		for (int i = 0; i < len; i++) {
			// 从左往右比较
			for (int j = i; j < len - 1; j++) {
				if (sortType == BubbleSort.SORT_DEST) {
					if (this.origArr[i] < this.origArr[j + 1]) {
						this.swap(i, j + 1);
					}
				} else {
					if (this.origArr[i] > this.origArr[j + 1]) {
						this.swap(i, j + 1);
					}
				}
			}
		}
	}

	public void swap(int leftInde, int rightIndex) {
		long temp = this.origArr[leftInde];
		this.origArr[leftInde] = this.origArr[rightIndex];
		this.origArr[rightIndex] = temp;
	}
}
