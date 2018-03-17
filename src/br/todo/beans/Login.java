package br.todo.beans;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class Login {
	private String email = "";
	private String password = "";
	
	public void login() {
		
	}
	
	public String register() {
		return "Registrar";
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
}
