/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dino.servlet;

/**
 *
 * @author mobil
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 
/**
 *
 * @author mobil
 */
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
public class RegisterServlet extends HttpServlet{

      UserController db = new UserController();

  String username="";
  String password="";
  Query q;
  EntityManager em=PersistenceController.getPersistenceController();
  List<Users> lista;
      @Override
  
 
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
            throws ServletException, IOException
  {

                
        username =  request.getParameter("userN");
            password = request.getParameter("passW");
 
      RequestDispatcher view = request.getRequestDispatcher("register.jsp");     
      view.forward(request, response);
     
  }
      @Override
  public void doPost(HttpServletRequest request,
                    HttpServletResponse response)
            throws ServletException, IOException
   {
	 username =  request.getParameter("userN");
            password = request.getParameter("passW");
                      

        
   lista = db.getUsers();
     for(int i=0; i!=lista.size();i++){
      
           if(lista.size()>0){
                if((lista.get(i).getName()).equals(username) && (lista.get(i).getPass()).equals(password)){
               
                  doGet(request,response);

           }
                else{
                    db.addUser(username, password, 0);
 response.sendRedirect("login");

                }
     }
          
     }
	}
}