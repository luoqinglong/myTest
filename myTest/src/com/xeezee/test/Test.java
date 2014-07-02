package com.xeezee.test;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * ����ѡ����
 * 
 * @author luoqinglong
 * @date 2012-6-13
 */
public class Test {
	List<Integer> volumList = new ArrayList<Integer>();
	public static int count = 6;// �ܺ��Ӹ���
	public static int num = 3;// ����
	public static int z = 1;

	/**
	 * ��ʼ������
	 * 
	 * @return
	 */
	public void initList() {
		for (int i = 0; i < Test.count; i++) {
			this.volumList.add(Integer.valueOf(i + 1));
		}
	}

	/**
	 * 
	 * @param n ��ʼѭ���ĺ��ӱ��
	 * @return
	 */
	public int getIndex(int n) {

		// ���ֻ��һ���ͷ���
		if (this.volumList.size() == 1) {
			return this.volumList.get(0);
		}

		for (int i = 0; i < this.volumList.size(); i++) {
			// ȥ�����е�����
			if (n == Test.num) {
				System.out.println("��" + Test.z + "��̭��" + this.volumList.get(i));
				this.volumList.remove(i);
				// �Ƴ���Ӻ��±�Ҫ����
				i--;
				n = 0;// ���㣬��ͷ��
				Test.z++;
			}
			n++;
		}

		return this.getIndex(n);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Test test = new Test();
		test.initList();
		int m = test.getIndex(1);
		// System.out.println(System.);
		DecimalFormat decimalFormat = new DecimalFormat("#0.000");
		System.out.println(decimalFormat.format(0.3));

	}
}
