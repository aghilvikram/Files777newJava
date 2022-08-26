package programs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class StringReversal {
	public void m1() {
		String given="vikram";
		StringBuffer buffer=new StringBuffer();
		buffer.append(given);
		buffer.reverse();
		System.out.println(buffer);
	}
	//public void 

	public static void main(String[] args) {
		String str="vikram";
		String rev="";
		char[] charArray = str.toCharArray();
		/*for(int i=charArray.length-1; i>=0; i--) {
			rev=rev+charArray[i];
			
		}
		System.out.println(rev);*/
		List<Character> ls=new ArrayList<Character>();
		for(Character character: charArray) {
			ls.add(character);}
			 Collections.reverse(ls);
			 ListIterator iterator =ls.listIterator();
			 while(iterator.hasNext()) {
				 System.out.println(iterator.next());
			 }
			 
		}
    
	}


