/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dino.model;
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
@Table(name = "shopping", schema = "ROOT")
public class Shopping{
      @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    @Basic
    private String proizvod;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer shoppingId;
    @Basic
    private int kolicina;
    

    public Shopping() {

    }
   
    public String getProizvod() {
        return this.proizvod;
    }

    public void setProizvod(String proizvod) {
        String oldProizvod = this.proizvod;
        this.proizvod = proizvod;
        changeSupport.firePropertyChange("proizvod", oldProizvod, proizvod);
    }
   

   

   
    public int getKolicina() {
        return this.kolicina;
    }

    public void setKolicina(int kolicina) {
        int oldKolicina = this.kolicina;
        this.kolicina = kolicina;
        changeSupport.firePropertyChange("kolicina", oldKolicina, kolicina);
    }
   
    public Integer getShoppingId() {
        return this.shoppingId;
    }

    public void setShoppingId(Integer shoppingId) {
        Integer oldShoppingId = this.shoppingId;
        this.shoppingId = shoppingId;
        changeSupport.firePropertyChange("shoppingId", oldShoppingId, shoppingId);
    }
   


    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
      @Override
    public String toString(){
    	return this.proizvod + " " + this.kolicina;
    }
}
