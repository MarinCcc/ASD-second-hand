package cn.second_hand.manager.domain;

public class Manager {
 
	 private String email;
	 private String password;
	public Manager() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Manager(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
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
	@Override
	public String toString() {
		return "Manager [email=" + email + ", password=" + password + "]";
	}
	 
	 
}
