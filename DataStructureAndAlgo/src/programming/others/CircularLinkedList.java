package programming.others;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class Node {
	public int data;
	public Node next;
	public static int NoN;
	
	public Node() {
		this.data = 0;
		this.next = null;
	}
	
	public Node(int data, Node next) {
		this.data = data;
		this.next = next;
	}
	
	public Node(int data) {
		this.data = data;
		this.next = null;
	}
}
public class CircularLinkedList {
	public static Node head = new Node();
	public static Node last = new Node();
	
	public CircularLinkedList() throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine().trim());
		String input[] = in.readLine().trim().split(" ");
		int val[] = new int[N];
		for(int i = 0; i < N; i++){
			val[i] = Integer.parseInt(input[i]);
		}
		Arrays.sort(val);
		Node first = new Node(val[0]);
		head.next = first;
		last.next = first;
		Node.NoN++;

		for(int i = 1; i < N ; i++) {
			Node n = new Node(val[i]);
			last.next.next = n;
			last.next = n;
			n.next = head.next;
			Node.NoN++;
		}
		
		
		int M = Integer.parseInt(in.readLine().trim());
		while(M-- > 0) {
			input = in.readLine().trim().split(" ");
			int op = Integer.parseInt(input[0]);
			int element = Integer.parseInt(input[1]);
			if(op == 1) {
				delete(element);
			}
			if(op == 0) {
				insert(element);
			}
		}
		int X = Integer.parseInt(in.readLine().trim());

		Node check = head.next;
		for(int i = 0; i < Node.NoN ; i++) {
			//System.out.print(check.data + " ");
			if(X == check.data)
				break;
			check = check.next;
		}
		for(int i = 0; i < Node.NoN; i++) {
			System.out.print(check.data + " ");
			check = check.next;
		}
	
	}
	
	public static void main(String args[]) throws Exception {
		new CircularLinkedList();
	}

	private void insert(int element) {
		Node n = new Node(element);
		if(element < head.next.data) {
			n.next = head.next;
			head.next = n;
			last.next.next = n;
			Node.NoN++;
			return;
		}
		int nodes = Node.NoN - 1;
		Node iter =  head.next;
		while(nodes-- > 0){
			//System.out.println(iter.data + " : "+iter.next.data + " and element : " + element);
			if(iter.data <= element && iter.next.data >= element) {
				n.next = iter.next;
				iter.next = n;
				Node.NoN++;
				return;
			}
			iter = iter.next;
		}
		last.next.next = n;
		last.next = n;
		n.next = head.next;
		Node.NoN++;
		return;
	}

	private void delete(int element) {
		//System.out.println( "1 :  " +element);
		Node prev = last.next;
		Node iter =  head.next;
		int nodes = Node.NoN;
		if(iter.data == element) {
			//System.out.println( prev.data + " :  " +iter.next.data);
			prev.next = iter.next;
			head.next = iter.next;
			Node.NoN--;
			return;
		}
		while(nodes-- > 0) {
			if(iter.data == element) {
				//System.out.println( prev.data + " :  " +iter.next.data);
				prev.next = iter.next;
				Node.NoN--;
				return;
			}
			prev = iter;
			iter = iter.next;
		}
		return;
	}

}

/*
3
2 4 6
2
1 2
0 5
6



3
2 4 6
2
1 2
0 4
6


3
2 4 6
2
1 2
1 4
6*/
