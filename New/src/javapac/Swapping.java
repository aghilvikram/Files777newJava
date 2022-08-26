package javapac;

public class Swapping {
	public static void m1() {
		int a=10;
		int b=6;
		int t=a;
		a=b;
		b=t;
		System.out.println(a);
		System.out.println(b);
		
	}

	public static void main(String[] args) {
		m1();
		int a=100;
		int b=50;
		b=((a+b)-(a=b));
		System.out.println("a="+a);
		System.out.println("b="+b);

	}

}
