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
	
	public void remove (Task task) {
		try {
			Query query = this.manager.createQuery("DELETE FROM Task where id = :id");
			query.setParameter("id", task.getId());	
			query.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@SuppressWarnings("unchecked")
	public List <Task> searchAll() {
		Query query = this.manager.createQuery(" SELECT e FROM Task e");
		return query.getResultList();
	}

}
