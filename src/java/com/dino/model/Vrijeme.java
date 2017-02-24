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
public class Vrijeme {
      
      @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    @Basic
    private String city;
     @Basic
    private String location;
      @Basic
    private String latitude;
       @Basic
    private String longitude;
    @Basic
    private int days;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer vrijemeId;
    
   
    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
         String oldCity = this.city;
        this.city = city;
        changeSupport.firePropertyChange("city", oldCity, city);
    }
     public String getLocation() {
        return this.city;
    }

    public void setLocation(String location) {
         String oldLocation = this.location;
        this.location = location;
        changeSupport.firePropertyChange("location", oldLocation, location);
    }
     public String getLatitude() {
        return this.latitude;
    }

    public void setLatitude(String latitude) {
         String oldLatitude = this.latitude;
        this.latitude = latitude;
        changeSupport.firePropertyChange("latitude", oldLatitude, latitude);
    }
     public String getLongitude() {
        return this.longitude;
    }

    public void setLongitude(String longitude) {
         String oldLongitude = this.longitude;
        this.longitude = longitude;
        changeSupport.firePropertyChange("longitude", oldLongitude, longitude);
    }
        public Integer getVrijemeId() {
        return this.vrijemeId;
    }

    public void setVrijemeId(Integer VrijemeId) {
        this.vrijemeId = VrijemeId;
    }
    public Integer getDays() {
        return this.days;
    }

    public void setDays(Integer Days) {
        this.days = Days;
    }
    @Override
      public String toString(){
    	return this.city + " " + this.days;
    }
}
