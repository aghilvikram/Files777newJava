package javapac;

public class StringReverse {
	
	 static String str="vikram";
    static String rev="";
    public static void m1(String str) {
    	//rev="devi";
    	String reverse="";
    	char a[] = str.toCharArray();
    	int n = a.length;
    	for (int i=n-1; i>=0; i--) {
    		reverse=reverse+a[i];
    		
    		
			
		}
    	System.out.println(reverse);
    }
    public static void m2(String value) {
    	StringBuffer str=new StringBuffer(value);
    	StringBuffer re = str.reverse();
    	System.out.println(re);
    }
	

	public static void main(String[] args) {
		m1("devi");
		m2("aghil");
     
     int len = str.length();
    // System.out.println(len);
     for(int i=len-1;  i>=0; i--) {
    	 rev=rev+str.charAt(i);
     }
    System.out.println(rev);
     
	}

}
