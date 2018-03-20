package br.todo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Task {
	@Id
	@GeneratedValue
	int id;

	@Column (name="title", nullable=false)
	private String title;
	
	@Column (name="check", nullable=false)
	private boolean check;

	public String getTitle() {
		return title;
	}

	public boolean isCheck() {
		return check;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setCheck(boolean check) {
		this.check = check;
	}
}
