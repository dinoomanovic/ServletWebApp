/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dino.controller;

/**
 *
 * @author mobil
 */
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.dino.model.Todo;
public class TodoController {
       Query q;
    EntityManager em;
    Todo todo;
    List<Todo> todoLista;

    public TodoController() {
        em = PersistenceController.getPersistenceController();
    }

    public void addTodo(String naziv,  String opis, boolean done) {
        todo = new Todo();
        em.getTransaction().begin();
        todo.setNaziv(naziv);
        todo.setOpis(opis);
        todo.setDone(done);
        em.persist(todo);
        em.getTransaction().commit();

    }

    public void deleteTodo(int todoId) {
        todo = em.find(Todo.class, todoId);
        em.getTransaction().begin();
        em.remove(todo);
        em.getTransaction().commit();


    }
    
    public void updateTodo(int todoId, String naziv, String opis, boolean done){
        todo=em.find(Todo.class, todoId);
        em.getTransaction().begin();
        todo.setNaziv(naziv);
        todo.setOpis(opis);
        em.getTransaction().commit();

    }
    public void setTodoDone (int todoId, boolean done){
        todo=em.find(Todo.class, todoId);
        em.getTransaction().begin();
       	todo.setDone(done);
        em.getTransaction().commit();

    }
    public Todo getTodo(int todoId){
        Todo todoid = em.find(Todo.class, todoId);
        return todoid;
        
    }
    public List<Todo> getTodoList() {
        q = em.createQuery("select t from Todo t");
        todoLista = q.getResultList(); 
        return todoLista;
    }
        public void deleteTodoList() {
        q = em.createNativeQuery("DELETE FROM Todo");
        em.getTransaction().begin();
        q.executeUpdate();
        em.getTransaction().commit();


    }
 
}
