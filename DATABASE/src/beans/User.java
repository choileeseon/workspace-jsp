package beans;

// 자바 빈으로 만든 클래스(필드변수, 기본생성자(생략가능), get/set메소드 필요)
public class User {
	// 필드변수	
	private String email = "";
	private String password = "";
	
	private String message = ""; //유효성 검사에 불합격 했을때 메세지
	
	public User() {
		// 기본생성자
	}

	public User(String email, String password) {
		this.email = email;
		this.password = password;
	}
	
	
	// get/set메소드
	
	public String getMessage() {
		return message;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	// 이메일,비번 적는 양식을 저장하기 위해 만든 boolean 메서드
	public boolean validate() {
		
						//정규 표현식으로 자바문자열은 역슬래쉬를 \\두번 적어야한다. \w+는 모든문자(숫자포함)							
		if(!email.matches("\\w+@\\w+\\.\\w+")) {
			message = "Invalid email";
			return false; //헷갈림
		}
		if(password.length() < 8) {
			message = "패스워드는 8자 이상";
			return false;
		}
		else if(password.matches("\\w*\\s+\\w*")) {
			message = "패스워드에 스페이스가 포함되면 안됩니다.";
			return false;
		}
		
		//위의 검사들을 다 합격하면 유효성 메소드 true로 리턴한다. 
		return true;
	}
}
