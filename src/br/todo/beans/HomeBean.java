package br.todo.beans;

import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.ifsp.repositories.TaskRepository;
import br.ifsp.repositories.UserRepository;
import br.todo.models.Task;
import br.todo.models.User;

@ManagedBean
public class HomeBean {
	ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
	Map<String, Object> sessionMap = externalContext.getSessionMap();
	private String task = "";
	private int userId;
	private List<Task> tasks;
	private String sort = "id";

	public HomeBean() {
		//userId = (int) sessionMap.get("user.id");
		userId = 1;
		setTasks();
	}
	
	public void addTask() {
		try {
			Task _task = new Task();
			_task.setDone(0);
			_task.setTitle(task);
			_task.setUserId(userId);
			
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("todo");
			EntityManager manager = factory.createEntityManager();

			TaskRepository taskRepository = new TaskRepository(manager);
			manager.getTransaction().begin();
			
			taskRepository.add(_task);
	
			manager.getTransaction().commit();		
			factory.close();
			setTasks();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void removeTask(Task task) {
		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("todo");
			EntityManager manager = factory.createEntityManager();

			TaskRepository taskRepository = new TaskRepository(manager);
			manager.getTransaction().begin();
			
			taskRepository.remove(task);

			manager.getTransaction().commit();		
			factory.close();
			setTasks();
		} catch (Exception e) {
			
		}
	}
	
	public void setTasks() {
		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("todo");
			EntityManager manager = factory.createEntityManager();

			TaskRepository taskRepository = new TaskRepository(manager);
			manager.getTransaction().begin();
			
			tasks = taskRepository.searchAll(userId, sort);

			manager.getTransaction().commit();		
			factory.close();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void setDone(Task task) {
		try {
			System.out.println(task.getTitle());
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("todo");
			EntityManager manager = factory.createEntityManager();

			TaskRepository taskRepository = new TaskRepository(manager);
			manager.getTransaction().begin();
			
			task.setDone(1);
			taskRepository.update(task);

			manager.getTransaction().commit();		
			factory.close();
			setTasks();
		} catch (Exception e) {
			
		}
	}
	
	public void setActive (Task task) {
		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("todo");
			EntityManager manager = factory.createEntityManager();

			TaskRepository taskRepository = new TaskRepository(manager);
			manager.getTransaction().begin();
			
			task.setDone(0);
			taskRepository.update(task);

			manager.getTransaction().commit();		
			factory.close();
			setTasks();
		} catch (Exception e) {
			
		}
	}
	
	public void filter () {
		System.out.println(sort);
		setTasks();
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getSort() {
		return sort;
	}
	
	public void setSort(String sort) {
		this.sort = sort;
	}
}
