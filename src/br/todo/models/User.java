package br.todo.models;
//import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
//import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue
	int id;

	@Column (name="email", nullable=false)
	private String email;
	
	@Column (name="pass", nullable=false)
	private String password;
	
//	@OneToMany (mappedBy="users")  
//	List<Task> tasks;

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
//	public List<Task> getTasks() {
//		return tasks;
//	}
//	public void setTasks(List<Task> tasks) {
//		this.tasks = tasks;
//	}
}
