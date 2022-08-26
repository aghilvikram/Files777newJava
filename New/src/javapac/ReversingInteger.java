package javapac;

public class ReversingInteger {

	public static void main(String[] args) {
		int m=19384345;
		String value = String.valueOf(m);
		int n = value.length();
		String rev="";
		for(int i=n-1; i>=0; i--) {
			rev=rev+value.charAt(i);
		}
		System.out.println(rev);

	}

}
