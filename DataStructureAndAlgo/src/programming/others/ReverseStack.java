package programming.others;

import java.util.Stack;

public class ReverseStack {
	public static  void main(String args[]) {
		Stack<Integer> s = new Stack<>();
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		int size = s.size();
		while(size-- > 0) {
			System.out.println(s.pop());
		}
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		reverse(s);
		size = s.size();
		while(size-- > 0) {
			System.out.println(s.pop());
		}
	}
	
	public static void reverse(Stack<Integer> s) {
		if(!s.isEmpty()) {
			int temp = s.pop();
			reverse(s);
			insertAtBottom(s, temp);
		}
	}

	private static void insertAtBottom(Stack<Integer> s, int temp) {
		if(s.isEmpty())
			s.push(temp);
		else {
			int item = s.pop();
			insertAtBottom(s, temp);
			s.push(item);
		}
	}
}
