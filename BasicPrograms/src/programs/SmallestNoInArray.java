package programs;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SmallestNoInArray {
	public static void usingArrays() {
		int arr[]= {3,2,5,8,5,6};
		Arrays.sort(arr);
		System.out.println(arr[0]);
	}
	public static void usingCollections() {
		Integer arr[]= {5,3,2,6,3,1,0};
		List<Integer> list = Arrays.asList(arr);
		Collections.sort(list);
		Integer smallest = list.get(0);
		System.out.println(smallest);
	}

	public static void main(String[] args) {
		int arr[]= {8,2,3,4,1,4,5};
		int smallest=Integer.MAX_VALUE;
		for(int i=0; i<arr.length; i++) {
			if(arr[i]<smallest) {
				smallest=arr[i];
			}
			
		}
		System.out.println(smallest);
		usingArrays();
		usingCollections();
	}
}
	


