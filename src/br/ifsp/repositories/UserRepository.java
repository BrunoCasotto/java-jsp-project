package br.ifsp.repositories;
import br.todo.models.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class UserRepository {
	private EntityManager manager ;
	
	public UserRepository (EntityManager manager ) {
		this.manager = manager ;
	}
	
	public void add (User e) {
		this.manager.persist(e);
	}
	
	public User search (int id) {
		return this.manager.find (User.class, id);
	}
	
	public Object searchByEmail (String email) {
		Query query = this.manager.createQuery("select e from User e where e.email like :email");
		query.setParameter("email", email);
		Object teste = query.getResultList();
		System.out.println(teste.toString());
		return query.getSingleResult();
	}
	
	@SuppressWarnings("unchecked")
	public List <User> searchAll() {
		Query query = this.manager.createQuery(" SELECT e FROM users e");
		return query.getResultList();
	}

}
