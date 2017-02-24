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
import com.dino.model.Shopping;
import com.dino.controller.PersistenceController;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author mobil
 */
public class ShoppingServlet extends HttpServlet{
      ShoppingController db;
  List<Shopping> shoppingLista;
  String proizvod;
  int kolicina;
      @Override
  public void init(){
  	db = new ShoppingController();	
        EntityManager conn = PersistenceController.getPersistenceController();
  }
      @Override
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
            throws ServletException, IOException
  {
 	if(request.getParameter("delete_id")!=null){
		int delete_id = Integer.parseInt(request.getParameter("delete_id"));
		db.deleteShopping(delete_id);	
		
      } 
        
	if(request.getParameter("deleteAll")!=null){
		boolean delete = Boolean.parseBoolean(request.getParameter("deleteAll"));
		if(delete==true)
			db.deleteShoppingList();
		response.sendRedirect("shopping");
		return;
      } 
        
      shoppingLista = (List<Shopping>)db.getShoppingList();
    
      request.setAttribute("shoppingLista",(List<Shopping>)shoppingLista);
      RequestDispatcher view = request.getRequestDispatcher("shopping.jsp");
      view.forward(request, response);
     
  }
      @Override
  public void doPost(HttpServletRequest request,
                    HttpServletResponse response)
            throws ServletException, IOException
   {
	  String product = request.getParameter("Proizvod");
          int quantity = Integer.parseInt(request.getParameter("Kolicina"));
	  db.addShopping(product,quantity);
	  doGet(request,response);
	  
	}
}
