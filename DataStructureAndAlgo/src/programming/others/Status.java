package programming.others;

public enum Status {
	PENDING("P"), ACTIVE("A"), INACTIVE("I"), DELETED("D");

	private String statusCode;

	private Status(String s) {
		statusCode = s;
	}

	public String getStatusCode() {
		return statusCode;
	}
}
