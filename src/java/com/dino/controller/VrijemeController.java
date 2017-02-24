/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dino.controller;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import com.dino.model.Vrijeme;
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

public class VrijemeController  {
     Query q;
    EntityManager em;
   
    Vrijeme vrijeme;
    List<Vrijeme> vrijemeLista;
    public VrijemeController() {
        em = PersistenceController.getPersistenceController();
    }
      public void addVrijeme(String city, int days, String latitude, String longitude, String location) {
        vrijeme = new Vrijeme();
        em.getTransaction().begin();
        vrijeme.setCity(city);
        vrijeme.setDays(days);
        vrijeme.setLatitude(latitude);
        vrijeme.setLongitude(longitude);
        vrijeme.setLocation(location);
        em.persist(vrijeme);
        em.getTransaction().commit();
               

    }

    public void deleteVrijeme(int vrijemeId) {
        // Izbrisi nastavnika sa zadatim id-om
        vrijeme = em.find(Vrijeme.class, vrijemeId);
        em.getTransaction().begin();
        em.remove(vrijeme);
        em.getTransaction().commit();
                


    }
    
    public void updateVrijeme(int vrijemeId, String city, int days){
        vrijeme=em.find(Vrijeme.class, vrijemeId);
        em.getTransaction().begin();
        vrijeme.setCity(city);
        vrijeme.setDays(days);
        em.getTransaction().commit();
               
    }

    /**
     *
     * @param vrijemeId
     * @return
     */
    public Vrijeme getVrijemeById(int vrijemeId){
        Vrijeme tempUser = em.find(Vrijeme.class, vrijemeId);
        return tempUser;
        
    }
    public List<Vrijeme> getVrijeme() {
        q = em.createQuery("select t from vrijeme t");
        vrijemeLista = q.getResultList();
        return vrijemeLista;
    }

}
