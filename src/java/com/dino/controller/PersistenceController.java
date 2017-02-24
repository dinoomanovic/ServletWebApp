/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dino.controller;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author mobil
 */
public final class PersistenceController {
    static private final String PERSISTANCE_UNIT = "ServletWebAppPU";
    static private EntityManagerFactory factory= Persistence.createEntityManagerFactory(PERSISTANCE_UNIT);
    static private EntityManager em = factory.createEntityManager();

    public static EntityManager getPersistenceController(){

        return em;
    }
}