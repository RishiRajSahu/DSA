package programming.others;

import java.util.ArrayList;
import java.util.Collections;

public class Prac {
	//check working of if else-if else
	
	public static void main(String args[]) {
		int i = 0; int j = 1;
		if(i == 0) {
			System.out.println("if");
		} else if(j == 1) {
			System.out.println("else if");
		} else {
			System.out.println("else");
		}
		
		
		ArrayList<Integer> q1 = new ArrayList<>();
		q1.add(5);
		q1.add(2);
		q1.add(2);
		q1.add(7);
		q1.add(1);
		q1.add(9);
		
		Collections.sort(q1, Collections.reverseOrder());
		
		q1.remove(0);
		
		for(Integer val : q1) 
		System.out.println(val);
	}

}
