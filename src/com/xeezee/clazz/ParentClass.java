/**
 * TODO
 */
package com.xeezee.clazz;

/**
 * @author luoqinglong
 * @date 2012-7-10
 */
public class ParentClass {

	static {
		System.out.println("静态初始代码块.");
	}
	static int aa = ParentClass.printSuper("初始化静态成员变量.");

	public ParentClass() {
		System.out.println("调用类的构造函数....");
	}

	int bb = ParentClass.printSuper(" 初始化实例成员变量....");

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("main函数...");
		A a = new A();
		B b = new B();
		A ab = new B();
		// System.out.println("------" + (b.getClass() == bb.getClass()));
		System.out.println("------");
		ParentClass.in(a);
		System.out.println("------");
		ParentClass.in(b);
		System.out.println("------");
		ParentClass.in(ab);

	}

	public static int printSuper(String amount) {
		System.out.println(amount);
		return 48;
	}

	public static void in(Object xx) {
		System.out.println("xx:" + xx);
		System.out.println("xx.getClass():" + xx.getClass());
		System.out.println("xx instanceof A :" + (xx instanceof A));
		System.out.println("xx instanceof B :" + (xx instanceof B));
		System.out.println("xx.getClass() == A.class :" + (xx.getClass() == A.class));
		System.out.println("xx.getClass() == B.class :" + (xx.getClass() == B.class));
		System.out.println("xx.getClass().equals(A.class) :" + (xx.getClass().equals(A.class)));
		System.out.println("xx.getClass().equals(B.class) :" + (xx.getClass().equals(B.class)));
		System.out.println("A.class.isInstance(xx) : " + (A.class.isInstance(xx)));
		System.out.println("B.class.isInstance(xx) : " + (B.class.isInstance(xx)));
	}
}

class A {

}

class B extends A {

}
