/**
 * TODO
 */
package com.xeezee.collection;

/**
 * 循环队列
 * 
 * @author luoqinglong
 * @date 2012-7-31
 */
public class Queue {
	private int itemCount;// 队中元素个数
	private int front = 0;// 队头
	private int rear = -1;// 队尾
	private final long[] queueArray;
	private int maxSize = 0;

	public Queue(int caption) {
		this.maxSize = caption;
		this.itemCount = 0;
		this.front = 0;
		this.rear = -1;
		this.queueArray = new long[caption];

	}

	public void insert(long j) {
		if (this.rear == this.maxSize - 1) {
			this.rear = -1;
		}
		this.queueArray[++this.rear] = j;
		this.itemCount++;
	}

	public long remove() {
		long temp = this.queueArray[this.front++];
		if (this.front == this.maxSize) {
			this.front = 0;
		}
		this.itemCount--;
		return temp;
	}

	public long peekFront() {
		return this.queueArray[this.front];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue queue = new Queue(5);
		queue.insert(111);
		queue.insert(222);
		queue.insert(333);
		queue.insert(444);
		queue.insert(555);
		System.out.println(queue.peekFront());
		queue.remove();
		queue.remove();
		queue.remove();
		queue.insert(6666);
		System.out.println(queue.peekFront());
	}

}
