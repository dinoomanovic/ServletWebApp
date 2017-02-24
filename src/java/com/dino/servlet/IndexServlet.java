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
import java.util.ArrayList;
import com.dino.controller.ShoppingController;
import com.dino.controller.TodoController;
import com.dino.model.Shopping;
import com.dino.controller.PersistenceController;
import com.dino.controller.UserController;
import com.dino.model.Todo;
import com.dino.model.Users;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author mobil
 */
public class IndexServlet extends HttpServlet{
      ShoppingController db1;
      TodoController db2;
      UserController db3 = new UserController();
  List<Shopping> shoppingLista;
    List<Todo> todoLista;
    List<Users> userLista;
    Users korisnik = new Users();
  String proizvod="";
  String userName="";
  int kolicina;
      @Override
  public void init(){
  	db1 = new ShoppingController();	
        db2 = new TodoController();	
       
        EntityManager conn = PersistenceController.getPersistenceController();
      /*
        if (db3.getUserById(1) == null )
        {
            db3.addUser("root","root",true);
        }*/
  }
      @Override
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
            throws ServletException, IOException
  {
 	
           

      shoppingLista = (List<Shopping>)db1.getShoppingList();
     todoLista = (List<Todo>)db2.getTodoList();
     userLista = db3.getUsers();
     for(int i=0;i<userLista.size();i++)
     {
      
    
         if(userLista.get(i).isLogin()==0)
         {  
             	        response.sendRedirect("login");
                        
         }
                                     userName = userLista.get(i).getName();

     }
     /*
     if( userName== null || userName.isEmpty())
     {
         userName="Gost";
         db3.addUser(userName);
     }*/
               request.setAttribute("todoLista",todoLista);
      request.setAttribute("shoppingLista",(List<Shopping>)shoppingLista);
      request.setAttribute("userName",userName);
      RequestDispatcher view = request.getRequestDispatcher("index.jsp");
      view.forward(request, response);
     
  }
      @Override
  public void doPost(HttpServletRequest request,
                    HttpServletResponse response)
            throws ServletException, IOException
   {
	 String action = request.getParameter("action");
     for(int i=0;i<userLista.size();i++)
     {
       if(action.equals("logout"))
         {
             korisnik = db3.getUserById(i+1);
             korisnik.setLogin(1);
             
            response.sendRedirect("login");
         }
    
        

     }

	}
}