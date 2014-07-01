/**
 * TODO
 */
package com.xeezee.sort;

/**
 * 插入排序
 * 
 * @author luoqinglong
 * @date 2012-7-31
 */
public class InsertSort {
	private final long[] origArr = new long[] { 2, 8, 15, 33, 1, 9, 6 };
	private final static int SORT_DEST = 0;
	private final static int SORT_ASC = 1;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InsertSort insertSort = new InsertSort();
		insertSort.sort(insertSort.origArr, InsertSort.SORT_ASC);

		for (int j = 0; j < insertSort.origArr.length; j++) {
			System.out.println(insertSort.origArr[j]);
		}
	}

	public void sort(long[] arrays, int sortType) {
		int len = this.origArr.length;

		for (int i = 0; i < len; i++) {
			// 从左往右比较
			int destIndex = i;
			for (int j = i; j < len - 1; j++) {
				if (sortType == InsertSort.SORT_DEST) {
					if (this.origArr[destIndex] < this.origArr[j + 1]) {
						// this.swap(i, j + 1);
						destIndex = j + 1;
					}
				} else {
					if (this.origArr[destIndex] > this.origArr[j + 1]) {
						// this.swap(i, j + 1);
						destIndex = j + 1;
					}
				}
			}
			this.swap(i, destIndex);
		}

	}

	public void swap(int leftInde, int rightIndex) {
		long temp = this.origArr[leftInde];
		this.origArr[leftInde] = this.origArr[rightIndex];
		this.origArr[rightIndex] = temp;
	}

}
