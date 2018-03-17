package br.todo.beans;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class Login {
	private int numero = 9081723;
	
	public int getNumero() {
		return this.numero;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public void incrementar() {
		this.numero ++;
	}
}
