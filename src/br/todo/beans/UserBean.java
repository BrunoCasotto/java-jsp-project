package br.todo.beans;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class UserBean {
	private UserBean user;
	
	public String register() {
		return "Login";
	}
	
	public String backToHome() {
		return "Login";
	}
}
