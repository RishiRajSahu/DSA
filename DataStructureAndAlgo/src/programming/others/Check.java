package programming.others;

import java.util.ArrayList;
import java.util.List;

interface Inter {
	int variable = 5;
	public abstract void test();
}

abstract class Abs {
	public void foo() {
		try {
			System.out.println("this is some method foo");
		} catch (Exception e) {
		} finally {

		}
	}

	public abstract void bar();
}

enum UserStatus {
	PENDING("p", "this is pending"), 
	ACTIVE("a", "this is active"), 
	INACTIVE("i", "this is inactive"), 
	DELETED("d", "this is deleted");
	
	private String statusCode;
	private String description;

	private UserStatus(String a, String desc) {
		statusCode = a;
		description = desc;
	}

	public String getStatus() {
		return this.statusCode;
	}

	public String getDesc() {
		return this.description;
	}
}

public class Check {
	public static void main(String args[]) {
		for (UserStatus status : UserStatus.values()) {
			System.out.println(status + " : " + status.getStatus() + " : " + status.getDesc());
		}
		System.out.println(UserStatus.valueOf("pending".toUpperCase()));
		System.out.println(UserStatus.valueOf("pending".toUpperCase()).getStatus());
		
		//Collections wild cards
		//user super when your are putting(PUT) things
		//use extends when you are getting(GET) things
		//PECS - producer extends and consumer extends
		List<? super Object> mylist = new ArrayList<Object>();
		mylist.add("Java"); // no compile error
		mylist.add(3); // no compile error
		mylist.add('c'); // no compile error
		Check.printList(mylist);
		//mylist.addAll(c);
	}
	
	public static void printList(List<? extends Object> list) {
		System.out.println("print");
		for(Object o : list)
			System.out.println("val : " +o);
	}
}