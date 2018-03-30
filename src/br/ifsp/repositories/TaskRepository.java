package br.ifsp.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.todo.models.Task;

public class TaskRepository {
private EntityManager manager ;
	
	public TaskRepository (EntityManager manager ) {
		this.manager = manager ;
	}
	
	public void add (Task e) {
		try {
			this.manager.persist(e);
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}
	}
	
	public Task search (int id) {
		return this.manager.find (Task.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List <Task> searchAll() {
		Query query = this.manager.createQuery(" SELECT e FROM Task e");
		return query.getResultList();
	}

}
