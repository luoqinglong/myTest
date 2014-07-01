/**
 * TODO
 */
package com.xeezee.collection;

/**
 * 栈
 * 
 * @author luoqinglong
 * @date 2012-7-31
 */
public class Stack {
	private final int size;
	private final long[] stackArray;
	private int top;

	public Stack(int caption) {
		this.size = caption;
		this.stackArray = new long[caption];
		this.top = -1;
	}

	public void push(long i) {
		if (!this.isFull()) {
			this.stackArray[++this.top] = i;
		}
	}

	public long pop() {
		return this.stackArray[this.top--];
	}

	public long peek() {
		return this.stackArray[this.top];
	}

	public boolean isFull() {
		return this.top == this.size - 1;
	}

	public boolean isEmpty() {
		return this.top == -1;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack stack = new Stack(10);

	}

}
