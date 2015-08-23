package ds.stack;

import java.util.Stack;

public class StockSpan {
	public static void main(String args[]) {
		int a[] = { 100, 80, 60, 70, 60, 75, 85 };
		Stack<Integer> s = new Stack<Integer>();
		int max = Integer.MIN_VALUE;
		s.push(0);max = 1;
		for(int i = 1; i < a.length; i++) {
			while(!s.isEmpty() && a[s.peek()] < a[i])
				s.pop();
			if(!s.isEmpty()) 
				max = Math.max(max, i - s.peek());
			s.push(i);
		}
		System.out.println(max);
	}
}
