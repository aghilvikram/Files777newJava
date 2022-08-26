package javapac;

public class Javap {
	static int x;
	static int y;
	
	public void m1(int a, int b) {
		
		System.out.println(a);
		System.out.println(b);
	}
	Javap(int a, int b){
		this.x=a;
		this.y=b;
		System.out.println(x+" "+ y);
	}

	public static void main(String[] args) {
		System.out.println("vikram,devi,aghil");
		//Javap i=new Javap();
		
		Javap c=new Javap(7,8);
		//Javap j=new Javap(2,4);
		c.m1(2,1);
		//j.m1(10,6);
		//System.out.println(x);
		//System.out.println(y);
		

	}

}
