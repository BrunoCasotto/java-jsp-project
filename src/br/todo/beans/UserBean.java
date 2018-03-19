package br.todo.beans;
import javax.faces.bean.ManagedBean;

import br.todo.models.User;

@ManagedBean
public class UserBean {
	private User user;
	
	public String register() {
		return "Login";
	}
	
	public String backToHome() {
		return "Login";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
