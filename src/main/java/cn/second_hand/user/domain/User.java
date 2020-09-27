package cn.second_hand.user.domain;

public class User {
	private String email;
	private String password;
	private String verifyCode;
	private boolean activeStatus;
	
	public boolean isActiveStatus() {
		return activeStatus;
	}
	public void setActiveStatus(boolean activeStatus) {
		this.activeStatus = activeStatus;
	}
	public String getVerifyCode() {
		return verifyCode;
	}
	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
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
		return "User [email=" + email + ", password=" + password + ", verifyCode=" + verifyCode + ", activeStatus="
				+ activeStatus + ", saleApplyStatus="  + "]";
	}
	
	
}
