/**
 * TODO
 */

/**
 * @author luoqinglong
 * @date 2012-8-9
 */
public class DataForm implements java.io.Serializable {

	/**
	 * TODO
	 */
	private static final long serialVersionUID = -5689242034826504751L;

	private String name = "luoqinglong";

	private int age = 26;

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return this.name;
	}

	public int getAge() {
		return this.age;
	}

}
