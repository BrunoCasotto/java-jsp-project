package br.todo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tasks")
public class Task {
	@Id
	@GeneratedValue
	int id;

	@Column (name="title", nullable=false)
	private String title;
	
	@Column (name="done", nullable=false)
	private int done;
	
	@Column (name="userId", nullable=false)
	private int userId;

	public int getId() {
		return id;
	}

	public int getDone() {
		return done;
	}


	public void setId(int id) {
		this.id = id;
	}

	public void setDone(int done) {
		this.done = done;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}
