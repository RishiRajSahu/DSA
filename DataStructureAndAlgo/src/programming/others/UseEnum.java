package programming.others;

public class UseEnum {

	public static void main(String[] args) {

		System.out.println(Status.ACTIVE);
		System.out.println(Status.ACTIVE.getStatusCode() == "P");
		System.out.println(Status.ACTIVE.getStatusCode());
	}
}
