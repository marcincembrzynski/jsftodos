/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.todolists;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import todolists.boundary.TodolistsEndpoint;
import todolists.entity.Todolist;

/**
 *
 * @author marcin
 */
@FacesConverter(forClass = todolists.entity.Todolist.class)
public class TodolistConverter implements Converter {

    @Override
    public Todolist getAsObject(FacesContext context, UIComponent component, String value) {

        Todolist todolist = null;
        System.out.println("converter: " + value);
        
        try {
            InitialContext ctx;
            ctx = new InitialContext();
            TodolistsEndpoint todolistsEndpoint = (TodolistsEndpoint) ctx.lookup("java:module/TodolistsEndpoint!todolists.boundary.TodolistsEndpoint");
            todolist = todolistsEndpoint.find(new Long(value));
        
        } catch (NamingException ex) {
            Logger.getLogger(TodolistConverter.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return todolist;
        
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        System.out.println("converter getAsString: " + value);
        Todolist todolist = (Todolist) value;
        return todolist.getId().toString();
    }

}
