package br.todo.beans;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.ifsp.repositories.UserRepository;
import br.todo.models.User;

@ManagedBean
@SessionScoped
public class LoginBean {

	private String email = "";
	private String password = "";
	private User user;
	private String errorMessage = "";
	private String error = "d-none";
	
	public void Loginbean() {
		try {
			ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
			Map<String, Object> sessionMap = externalContext.getSessionMap();
			sessionMap.remove("user");
		} catch(Exception e){
			
		}
	}

	public String login() {
		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("todo");
			EntityManager manager = factory.createEntityManager();
			UserRepository userRepository = new UserRepository(manager);
			manager.getTransaction().begin();
			
			user = (User)userRepository.searchByEmail(email);

			String userPass = null;
			String userEmail = null;
			int userId;

			if(user != null) {
				userPass = user.getPassword();
				userEmail = user.getEmail();
				userId = user.getId();
				
				ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
				Map<String, Object> sessionMap = externalContext.getSessionMap();
				
				if(sessionMap.containsKey("user")) {
					sessionMap.replace("user", user);					
				} else {
					sessionMap.put("user", user);
				}

			} else {
				this.validateForm(false, true);
				return null;
			}

			manager.getTransaction().commit();
			factory.close();
			
			final boolean isValid = this.validateForm(userEmail.equals(email), userPass.equals(password));

			String res = (isValid) ? "Home" : null;
			
			return res;

		} catch (Exception e) {
			System.out.println("Erro no login" + e.getMessage());
			return null;
		}
	}
	
	private boolean validateForm(boolean emailStatus, boolean passStatus) {
		this.setError(emailStatus, passStatus);
		return (emailStatus && passStatus) ? true : false;
	}
	
	private void setError(boolean emailStatus, boolean passStatus) {
		if(!emailStatus){
			this.error = "";
			this.errorMessage = "Encontramos um erro no campo do email!";
		}
		
		if(!passStatus) {
			this.error = "";
			this.errorMessage = "Encontramos um erro no campo da senha!";
		}
		
		if(emailStatus && passStatus) {
			this.error = "d-none";
		}
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
