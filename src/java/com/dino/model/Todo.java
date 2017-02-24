/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dino.model;

/**
 *
 * @author mobil
 */
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
/**
 *
 * @author mobil
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "todo", schema = "ROOT")
public class Todo {
      @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    @Basic
    private String naziv;
    @Basic
    private boolean done=false;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer todoId;
    @Basic
    private String opis;
    

    public Todo() {

    }
   
    public String getNaziv() {
        return this.naziv;
    }

    public void setNaziv(String naziv) {
        String oldNaziv = this.naziv;
        this.naziv = naziv;
        changeSupport.firePropertyChange("naziv", oldNaziv, naziv);
    }
   

   public String getOpis() {
        return this.opis;
    }

    public void setOpis(String opis) {
        String oldOpis = this.opis;
        this.opis = opis;
        changeSupport.firePropertyChange("opis", oldOpis, opis);
    }
   public boolean isDone()
   {
      return this.done;
   }
   public void setDone(boolean done){
       this.done=done;
   }
    public Integer getTodoId() {
        return this.todoId;
    }

    public void setTodoId(Integer todoId) {
        Integer oldTodoId = this.todoId;
        this.todoId = todoId;
        changeSupport.firePropertyChange("todoId", oldTodoId, todoId);
    }
   


    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
      @Override
    public String toString(){
    	return this.naziv + " " + this.opis;
    }
}