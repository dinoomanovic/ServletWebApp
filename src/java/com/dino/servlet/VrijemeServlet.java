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

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import com.dino.controller.*;
import com.dino.model.*;
/*
 *
 * @author mobil
 */
public class VrijemeServlet extends HttpServlet{
    VrijemeController db;
  List<Vrijeme> vrijemeLista;
  @Override
  public void init(){
  	db = new VrijemeController();	
  }
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
            throws ServletException, IOException
  {
     
      RequestDispatcher view = request.getRequestDispatcher("weather.jsp");
      view.forward(request, response);
  }
  public void doPost(HttpServletRequest request,
                    HttpServletResponse response)
            throws ServletException, IOException
   {
	  String city = request.getParameter("city");
          String lokacija = request.getParameter("locationTextField");
			String latitude = request.getParameter("latitude");
			String longitude = request.getParameter("longitude");
          int days = Integer.parseInt(request.getParameter("days"));
         if(db.getVrijemeById(1)==null)
         
         {
             db.addVrijeme(city,days,latitude,longitude,lokacija);
             
         }
         else
          
	  db.updateVrijeme(1,city,days);
         
	  doGet(request,response);
	  
	}
  
}