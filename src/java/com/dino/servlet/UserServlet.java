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
import com.dino.controller.*;
import com.dino.model.*;

/*
 *
 * @author mobil
 */
public class UserServlet extends HttpServlet{
    UserController db = new UserController();
 // ArrayList<Users> userLista;
    String userName;
    List<Users> lista = db.getUsers();
  @Override

  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
            throws ServletException, IOException
  {
 
        
    //  userLista = (ArrayList<Users>)db.getUsers();
  //    request.setAttribute("userLista",userLista);
      /*userName = db.getUserById(1).getName();
      if(db.getUserById(1)==null)
         
         {
             db.addUser("Gost");

             
         }
      request.setAttribute("userName",userName);
*/
      RequestDispatcher view = request.getRequestDispatcher("settings.jsp");
      view.forward(request, response);
  }
  public void doPost(HttpServletRequest request,
                    HttpServletResponse response)
            throws ServletException, IOException
   {
	  String name = request.getParameter("userName");
          String pass = request.getParameter("passWord");
          
for (int i=0;i<lista.size();i++){  
    if(lista.get(i).isLogin()==1)
	  db.updateUser(i+1,name,pass);
     
doGet(request,response); 
	}
   }
}
