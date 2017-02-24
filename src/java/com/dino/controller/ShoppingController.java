/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dino.controller;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.dino.model.Shopping;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Table;

/**
 *
 * @author mobil
 */
public class ShoppingController {
     Query q;
     
    EntityManager em;
    Shopping shopping;
    List<Shopping> shoppingLista;

    public ShoppingController() {
        em = PersistenceController.getPersistenceController();
    }

    public void addShopping(String proizvod,  int kolicina) {
        shopping = new Shopping();
        em.getTransaction().begin();
        shopping.setProizvod(proizvod);
        shopping.setKolicina(kolicina);
        em.persist(shopping);
        em.getTransaction().commit();
    }

    public void deleteShopping(int shoppingId) {
        shopping = em.find(Shopping.class, shoppingId);
        em.getTransaction().begin();
        em.remove(shopping);
        em.getTransaction().commit();


    }
    public void deleteShoppingList() {
        q = em.createNativeQuery("DELETE FROM Shopping");
        em.getTransaction().begin();
        q.executeUpdate();
        em.getTransaction().commit();


    }
    
    public void updateShopping(int shoppingId, String proizvod, int kolicina){
        shopping=em.find(Shopping.class, shoppingId);
        em.getTransaction().begin();
        shopping.setProizvod(proizvod);
        shopping.setKolicina(kolicina);
        em.getTransaction().commit();
          

    }
    public Shopping getShopping(int shoppingId){
        Shopping shoppingid = em.find(Shopping.class, shoppingId);
        return shoppingid;
        
    }
    public List<Shopping> getShoppingList() {
        q = em.createQuery("SELECT t FROM Shopping t");
        shoppingLista = (List<Shopping>) q.getResultList(); 
        return shoppingLista;
    }

    
}
