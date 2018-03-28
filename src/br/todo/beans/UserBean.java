package br.todo.beans;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import br.ifsp.repositories.UserRepository;
import br.todo.models.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ManagedBean
@SessionScoped
public class UserBean {
	ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
	Map<String, Object> sessionMap = externalContext.getSessionMap();
	private User user;
	private String email;
	private String password;
	private String errorMessage = "";
	private String error = "d-none";

	public String register() {
		try {
			user = new User();
			user.setEmail(email);
			user.setPassword(password);

			EntityManagerFactory factory = Persistence.createEntityManagerFactory("todo");
			EntityManager manager = factory.createEntityManager();
			UserRepository userRepository = new UserRepository(manager);
			manager.getTransaction().begin();
			
			User userResult = (User) userRepository.add(user);

			manager.getTransaction().commit();		
			factory.close();
			
			if(userResult != null) {
				sessionMap.put("user.id",userResult.getId());
				this.setAddError(true);
				return "Home";
			} else {
				this.setAddError(false);
				return null;
			}
		}catch (Exception e) {
			this.setAddError(false);
			return null;
		}
	}
	
	public void setAddError(boolean status) {
		if(status) {
			this.error = "d-none";
			this.errorMessage = "";
		} else {
			this.error = "";
			this.errorMessage = "Erro ao inserir, usuário existente!";
		}
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

	public User getUser() {
		return user;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public String getError() {
		return error;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public void setError(String error) {
		this.error = error;
	}

}
