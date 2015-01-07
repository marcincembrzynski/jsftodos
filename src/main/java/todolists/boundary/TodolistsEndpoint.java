/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todolists.boundary;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import todolists.entity.Todolist;

/**
 *
 * @author marcin
 */
@Stateless
public class TodolistsEndpoint {

    @PersistenceContext
    EntityManager em;

    public void create(Todolist todolist) {
        em.persist(todolist);
    }

    public void remove(Todolist todolist) {
        Todolist merge = em.merge(todolist);
        em.remove(merge);
    }

    public List<Todolist> findAllTodolists() {
        return em.createQuery("Select t From Todolist t ORDER BY t.created DESC", Todolist.class).getResultList();
    }

    public Todolist find(Long todolistId) {
        return em.find(Todolist.class, todolistId);
    }

    public void update(Todolist todolist) {     
        em.merge(todolist);
    }

}
