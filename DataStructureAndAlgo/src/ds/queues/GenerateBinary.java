package ds.queues;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class GenerateBinary {
public static void main(String args[]) {
	int N = 8;
	PriorityQueue<Integer> pq = new PriorityQueue<>();
	Queue<String> queue = new LinkedList<String>();
	queue.add("1");
	for(int i = 0; i < N; i++) {
		String val = queue.remove();
		System.out.println(val);
		queue.add(val + "0");
		queue.add(val + "1");
	}
	
	
	 String input = "city^chennai|country^India~TamilNadu|pincode^600034";
	 
	 //tokenize with respect to begin with word
	    String[] things = input.replaceAll( "~", "," ).split( "[^\\w,]" );
	    Map<String, String> map = new HashMap<String, String>( );
	    for (int i = 0; i < things.length; i+=2) {
	        map.put(things[i], things[i+1]);
	    }
	    System.out.println( map );
}
}
