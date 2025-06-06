package outer;

import com.ex.Monkey;

public class A extends Monkey {
public static void main(String[] args) {
	A a=new A();
	
	Monkey.eat();

	a.jump();
	a.walk();
}
}
