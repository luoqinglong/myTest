

import java.util.Random;

/**
 * @author luoqinglong
 * @date 2012-7-28
 */
public class SimpleService {
	public String getGreeting(String name) {
		return name + ":hello£¡you are big!";
	}

	public int getPrice() {
		return new Random().nextInt(1000);
	}
}
