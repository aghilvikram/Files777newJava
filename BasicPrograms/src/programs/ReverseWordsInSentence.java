package programs;

public class ReverseWordsInSentence {

	public static void main(String[] args) {
		String given="I Love India";
		String reversed="";
		String[] temp = given.split(" ");
		System.out.println(temp.length);
		System.out.println(temp[0]);
		System.out.println(temp[1]);
		System.out.println(temp[2]);
		temp[1]="hate";
		for(int i=temp.length-1; i>=0; i--) {
			reversed=reversed+temp[i]+" ";
		}
		System.out.print(reversed);
	}

}
