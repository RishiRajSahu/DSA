package programming.others;

import java.util.Arrays;

class CNode {
	public int data;
	public CNode next;
	
	public CNode() {
		this.data = 0;
		this.next = null;
	}
	
	public CNode(int data, CNode next) {
		this.data = data;
		this.next = next;
	}
	
	public CNode(int data) {
		this.data = data;
		this.next = null;
	}
}
public class SortedCLL {
	public static CNode head = new CNode();
	public static CNode last = new CNode();
	public static int NoN;
	
	public SortedCLL() {
	
	}
	
	public static void main(String args[]) throws Exception {
		SortedCLL t = new SortedCLL();
 
		int N = 3;
		int val[] = {4, 2, 6};
		Arrays.sort(val);
		CNode first = new CNode(val[0]);
		head.next = first;
		last.next = first;
		NoN++;

		for (int i = 1; i < N; i++) {
			CNode n = new CNode(val[i]);
			last.next.next = n;
			last.next = n;
			n.next = head.next;
			NoN++;
		}
		
		//DELETING AN ELEMENT
		t.delete(2);
		
		//INSERTING AN ELEMENT
		t.insert(7);

		CNode check = head.next;
		for (int i = 0; i <= NoN; i++) {
			System.out.print(check.data + " ");
			check = check.next;
		}
	}

	private void insert(int element) {
		CNode n = new CNode(element);
		if(element < head.next.data) {
			n.next = head.next;
			head.next = n;
			last.next.next = n;
			NoN++;
			return;
		}
		int nodes = NoN - 1;
		CNode iter =  head;
		while(nodes-- > 0){
			if(iter.data < element && iter.next.data > element) {
				n.next = iter.next;
				iter.next = n;
				NoN++;
				return;
			}
		}
		last.next.next = n;
		last.next = n;
		n.next = head.next;
		NoN++;
		return;
	}

	private void delete(int element) {
		//System.out.println( "1 :  " +element);
		CNode prev = last.next;
		CNode iter =  head.next;
		int nodes = NoN;

		if(iter.data == element) {
			System.out.println( prev.data + " :  " +iter.next.data);
			prev.next = iter.next;
			head.next = iter.next;
			NoN--;
			return;
		}
		
		while(nodes-- > 0) {
			if(iter.data == element) {
				System.out.println( prev.data + " :  " +iter.next.data);
				prev.next = iter.next;
				NoN--;
				return;
			}
			prev = iter;
			iter = iter.next;
		}
		return;
	}

}
