package programs;

public class ReverseANumber {

	public static void main(String[] args) {
		int i=123;
		int revno=0;
		while(i!=0) {
		revno=revno*10;
		revno=revno+i%10;
		i=i/10;
		}
		System.out.println(revno);

	}

}
