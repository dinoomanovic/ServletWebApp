/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dino.model;

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
@SuppressWarnings("serial")
@Entity
public class Users {
      
      @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    @Basic
    private String name;
    @Basic private String pass;
    @Basic private int login;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer userId;
    
    public int isLogin()
    {
        return this.login;
    }
    public void setLogin(int login)
    {
        int oldVal = this.login;
        this.login = login;
        changeSupport.firePropertyChange("login", oldVal, login);
    }
   
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
         String oldName = this.name;
        this.name = name;
        changeSupport.firePropertyChange("name", oldName, name);
    }
     public String getPass() {
        return this.pass;
    }

    public void setPass(String pass) {
         String oldPass = this.pass;
        this.pass = pass;
        changeSupport.firePropertyChange("pass", oldPass, pass);
    }
        public Integer getUserId() {
        return this.userId;
    }

    public void setUserId(Integer UserId) {
        this.userId = UserId;
    }
    @Override
      public String toString(){
    	return this.name;
    }
}
