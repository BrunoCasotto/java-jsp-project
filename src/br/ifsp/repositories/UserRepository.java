package br.ifsp.repositories;
import br.todo.models.User;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.hibernate.exception.ConstraintViolationException;

public class UserRepository {
	private EntityManager manager ;
	
	public UserRepository (EntityManager manager ) {
		this.manager = manager ;
	}
	
	public Object add (User e) {
		try {
			this.manager.persist(e);
			return this.searchByEmail(e.getEmail());
		} catch (Exception exception) {
			return null;
		}
	}
	
	public User search (int id) {
		return this.manager.find (User.class, id);
	}
	
	public Object searchByEmail (String email) {
		try {
			Query query = this.manager.createQuery("select e from User e where e.email like :email");
			query.setParameter("email", email);


			return query.getSingleResult();
		} catch (Exception exception) {
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List <User> searchAll() {
		Query query = this.manager.createQuery(" SELECT e FROM users e");
		return query.getResultList();
	}

}
