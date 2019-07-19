package kr.ac.binsin.exception;

public class UserNotFoundException extends RuntimeException {
	
	// 클래스의 버전을 나타내는 숫자
	private static final long serialVersionUID = 4772384247218586389L;
	
	private long userId;

	public UserNotFoundException(long userId) {
		super();
		this.userId = userId;
	}
	
	public long getUserId() {
		return userId;
	}

}
