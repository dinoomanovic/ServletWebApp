/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dino.controller;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import com.dino.model.Users;
import java.beans.PropertyChangeSupport;
import javax.persistence.Basic;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
/**
 *
 * @author mobil
 */

public class UserController  {
     Query q;
    EntityManager em;
   
    Users user;
    List<Users> users;
    public UserController() {
        em = PersistenceController.getPersistenceController();
    }
      public void addUser(String name, String pass, int login) {
        user = new Users();
        em.getTransaction().begin();
        user.setName(name);
        user.setPass(pass);
        user.setLogin(login);
        em.persist(user);
        em.getTransaction().commit();
               

    }

    public void deleteUser(int userId) {
        // Izbrisi nastavnika sa zadatim id-om
        user = em.find(Users.class, userId);
        em.getTransaction().begin();
        em.remove(user);
        em.getTransaction().commit();
             


    }
    
    public void updateUser(int userId, String name, String pass){
        user=em.find(Users.class, userId);
        em.getTransaction().begin();
        user.setName(name);
        user.setPass(pass);
        em.getTransaction().commit();
               
    }

    /**
     *
     * @param userId
     * @return
     */
    public Users getUserById(int userId){
        Users tempUser = em.find(Users.class, userId);
        return tempUser;
        
    }
    public String getUserNameById(int userId)
    {
        Users tempUser = em.find(Users.class, userId);
       
        return tempUser.getName();
    }
    public List<Users> getUsers() {
        q = em.createQuery("select t from Users t");
        users = q.getResultList();
        return users;
    }

}
