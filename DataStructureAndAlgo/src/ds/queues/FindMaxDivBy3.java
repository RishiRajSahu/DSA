package ds.queues;

import java.util.ArrayList;
import java.util.Collections;

public class FindMaxDivBy3 {
	public static void main(String args[]) {
		//for a number to be divisible by 3, sum of all its digits should be divisible by 3
		//int a[] = {8, 1, 7, 6, 0};
		int a[] = {8, 1, 9};
		ArrayList<Integer> q0 = new ArrayList<>();
		ArrayList<Integer> q1 = new ArrayList<>();
		ArrayList<Integer> q2 = new ArrayList<>();
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] % 3 == 0) {
				q0.add(a[i]);
			} else if (a[i] % 3 == 1) {
				q1.add(a[i]);
			} else if (a[i] % 3 == 2) {
				q2.add(a[i]);
			}
			sum += a[i];
		}

		//Collections.sort(q0);
		Collections.sort(q1);
		Collections.sort(q2);
		boolean success = false;
		if(sum%3 == 1) {
			if(q1.size() != 0) {
				q1.remove(0);
				success = true;
			}
		} else if(sum%3 ==2 ) {
			if(q2.size() != 0) {
				q2.remove(0);
				success = true;
			} else {
				if(q1.size() >= 2) {
					q1.remove(0);q1.remove(1);
					success = true;
				} 
			}
		} else {
			success = true;
		}

		ArrayList<Integer> finalQ = new ArrayList<>();
		if(success) {
			for(Integer val : q0) {
				finalQ.add(val);
			}
			for(Integer val : q1) {
				finalQ.add(val);
			}
			for(Integer val : q2) {
				finalQ.add(val);
			}
			Collections.sort(finalQ, Collections.reverseOrder());
		} else {
			System.out.println("not possible");
			return;
		}
		StringBuffer sb = new StringBuffer("");
		for(Integer val : finalQ) {
			sb.append(val);//
		}
		System.out.println(Integer.parseInt(sb.toString()));
	}
}
