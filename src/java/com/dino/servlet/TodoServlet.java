/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dino.servlet;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.*;
import com.dino.controller.TodoController;
import com.dino.model.Todo;

/**
 *
 * @author mobil
 */
public class TodoServlet extends HttpServlet{
      TodoController db;
  List<Todo> todoLista;
      @Override
  public void init(){
  	db = new TodoController();	
  }
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
            throws ServletException, IOException
  {

 	if(request.getParameter("delete_id")!=null){
		int delete_id = Integer.parseInt(request.getParameter("delete_id"));
		db.deleteTodo(delete_id);	
		
      } 
              if(request.getParameter("zavrsena")!=null){
		int zavrsena_id = Integer.parseInt(request.getParameter("zavrsena"));
		db.setTodoDone(zavrsena_id,true);
		return;
      } 
	if(request.getParameter("deleteAll")!=null){
		boolean delete = Boolean.parseBoolean(request.getParameter("deleteAll"));
		if(delete==true)
			db.deleteTodoList();
		response.sendRedirect("todo");
		return;
      } 
        
      todoLista = (List<Todo>)db.getTodoList();
      request.setAttribute("todoLista",todoLista);
      RequestDispatcher view = request.getRequestDispatcher("todo.jsp");
      view.forward(request, response);
  }
  public void doPost(HttpServletRequest request,
                    HttpServletResponse response)
            throws ServletException, IOException
   {
	  String Naziv = request.getParameter("Naziv");
          String Opis = request.getParameter("Opis");	  
          boolean Done = false;
          db.addTodo(Naziv,Opis,Done);
	  doGet(request,response);
	  
	}
}

