package br.todo.beans;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import br.ifsp.repositories.UserRepository;
import br.todo.models.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ManagedBean
public class UserBean {
	private User user;
	private String email;
	private String password;
	
	public UserBean() {
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> sessionMap = externalContext.getSessionMap();
		System.out.println(sessionMap.get("login_error_status"));
		System.out.println(sessionMap.get("login_error_message"));
	}

	public String register() {
		user = new User();
		user.setEmail(email);
		user.setPassword(password);

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("todo");
		
		EntityManager manager = factory.createEntityManager();
		
		UserRepository userRepository = new UserRepository(manager);
		
		manager.getTransaction().begin();
		
		userRepository.add(user);
		
		manager.getTransaction().commit();
		
		factory.close();

		return "Login";
	}
	
	public String backToHome() {
		return "Login";
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
