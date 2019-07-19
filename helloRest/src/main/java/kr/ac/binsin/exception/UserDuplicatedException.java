package kr.ac.binsin.exception;

public class UserDuplicatedException extends RuntimeException {
	
	private static final long serialVersionUID = -2893369075477534866L;
	
	private String userName;
	
	public UserDuplicatedException(String userName) {
		super();
		this.userName = userName;
	}
	
	public String getUserName() {
		return userName;
	}
	
}
