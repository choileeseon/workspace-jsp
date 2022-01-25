package beans;

// 자바 빈으로 만든 클래스(필드변수, 기본생성자(생략가능), get/set메소드 필요)
public class User {
	// 필드변수	
	private String email;
	private String password;
	
	// 기본생성자 생략가능
	
	// get/set메소드
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
