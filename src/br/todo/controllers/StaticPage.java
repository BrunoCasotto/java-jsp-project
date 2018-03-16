package br.todo.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/todo") 
public class StaticPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override 
	protected void service (HttpServletRequest req ,HttpServletResponse resp) throws IOException{
		PrintWriter writer = resp.getWriter();
 		writer.println("<html><body><h1> Ola IFSP </h1></body></html>");
	}
}
