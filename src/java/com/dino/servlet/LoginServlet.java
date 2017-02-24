/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 
/**
 *
 * @author mobil
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
import static java.lang.System.out;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author mobil
 */
public class LoginServlet extends HttpServlet{

      UserController db = new UserController();

  String username="";
  String password="";
  String isChecked="";
  Query q;
  EntityManager em=PersistenceController.getPersistenceController();
  List<Users> lista;
      @Override
  public void init(){
  
       
        if (db.getUserById(1) == null )
        {
            db.addUser("root","root",0);
        }
  }
      @Override
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
            throws ServletException, IOException
  {

              /*
              if( userName== null || userName.isEmpty())
              {
              userName="Gost";
              db3.addUser(userName);
              }*/
         //     Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/userdb","root","root");

                
                
        
      request.getAttribute("user");
      request.getAttribute("isChecked");
      RequestDispatcher view = request.getRequestDispatcher("login.jsp");
      view.forward(request, response);
     
  }
      @Override
  public void doPost(HttpServletRequest request,
                    HttpServletResponse response)
            throws ServletException, IOException
   {
	 username =  request.getParameter("user");
            password = request.getParameter("pass");
            isChecked=request.getParameter("isChecked");
                                  RequestDispatcher view1 = request.getRequestDispatcher("login.jsp");
                      RequestDispatcher view2 = request.getRequestDispatcher("index");

        
   lista = db.getUsers();
     for(int i=0; i!=lista.size();i++){
           if(lista.size()>0)
                if((lista.get(i).getName()).equals(username) && (lista.get(i).getPass()).equals(password)){
               
                        lista.get(i).setLogin(1);
                    
                    response.sendRedirect("index");
                }
            else
	        response.sendRedirect("login");
     }
   
	}
}