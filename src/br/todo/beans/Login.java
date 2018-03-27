package br.todo.beans;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.ifsp.repositories.UserRepository;
import br.todo.models.User;

@ManagedBean
public class Login {
	private String email = "";
	private String password = "";
	private User user;
	private String errorMessage = "";
	private String error = "d-none";
	
	public String login() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("todo");
		
		EntityManager manager = factory.createEntityManager();
		UserRepository userRepository = new UserRepository(manager);
		manager.getTransaction().begin();
		
		user = (User)userRepository.searchByEmail(email);

		System.out.println(user.getEmail());

		final String userPass = user.getPassword();
		final String userEmail = user.getEmail();

		manager.getTransaction().commit();
		factory.close();
		
		final boolean isValid = this.validateForm(userEmail.equals(email), userPass.equals(password));
		
		String res = (isValid) ? "Home" : "Login";
		
		return res;
	}
	
	private boolean validateForm(boolean emailStatus, boolean passStatus) {
		return (emailStatus && passStatus) ? true : false;
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

	public String getErrorMessage() {
		return errorMessage;
	}

	public String getError() {
		return error;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public void setError(String error) {
		this.error = error;
	}
}
