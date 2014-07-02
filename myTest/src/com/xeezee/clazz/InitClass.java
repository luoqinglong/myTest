/**
 * TODO
 */
package com.xeezee.clazz;

/**
 * @author luoqinglong
 * @date 2012-7-10
 */
public class InitClass extends ParentClass {
	static int a = InitClass.print("static.1111");
	int b = InitClass.print("2222");
	static {
		System.out.println("static...");
	}
	static int c = InitClass.print("static.333");

	public InitClass() {
		System.out.println("constuctor...");
	}

	int d = InitClass.print("33333");

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// TODO Auto-generated method stub
		System.out.println("-------main---------------");
		InitClass initClass = new InitClass();
		System.out.println("-------main---------------");
		InitClass initClass2 = new InitClass();
	}

	public static int print(String amount) {
		System.out.println(amount + " print...");
		return 47;
	}

}
