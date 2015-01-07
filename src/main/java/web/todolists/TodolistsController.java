/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.todolists;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import todolists.boundary.TodolistsEndpoint;
import todolists.entity.Todolist;
import todos.entity.Todo;

/**
 *
 * @author marcin
 */
@Model
public class TodolistsController implements Serializable{

    @Inject
    TodolistsEndpoint todoListsEndpoint;
    
  

    private Todolist todolist;
    private List<Todolist> allTodolists; 
    private Todo todo;

    /**
     * Creates a new instance of TodoListsController
     */
    public TodolistsController() {
    }

    public void create() {

        todoListsEndpoint.create(todolist);
        todolist = new Todolist();

    }
    
    public void removeTodolist(Todolist todolist){
        todoListsEndpoint.remove(todolist);
    }

    public Todolist getTodolist() {
        
        if (null == todolist) {
            todolist = new Todolist();
        }
        return todolist;
    }

    public void setTodolist(Todolist todoList) {
        this.todolist = todoList;
    }
    
    public String editTodolist(Todolist tl){
        System.out.println("editTodolist....");
        this.todolist = tl;
        System.out.println("editTodolist: todolist: " + todolist);
        return "todolist";
    }

    

    public void addTodo() {
        System.out.println("addTodo: " + todo);      
        System.out.println("todolist: " + todolist);
        
        todo.setCreated(new Date());
        todolist.addTodo(todo);
        todoListsEndpoint.update(todolist);      
        
        todo = new Todo();
        
        //return "todolist?id=" + todolist.getId();
    }
    
    public void removeTodo(Todo todo){
      
        System.out.println("remove todolist todolist: " + todolist.getId());
        todolist.removeTodo(todo);
        todoListsEndpoint.update(todolist);            
        ///return "todolist?id=" + todolist.getId();
    }
    
    public void update(){
        System.out.println("updateing.....");
        System.out.println("todolist in update: " + todolist);
        todoListsEndpoint.update(todolist);
        todolist = todoListsEndpoint.find(todolist.getId());
        // return "todolist?id=" + todolist.getId();
    }
    
    public void update(Todolist tododolist){
        System.out.println("update todolist: " + tododolist);
        todoListsEndpoint.update(todolist);
    }

    public List<Todolist> getAllTodolists() {
        return todoListsEndpoint.findAllTodolists();
    }

    public Todo getTodo() {
        if (null == todo) {
            todo = new Todo();
           
        }
        return todo;
    }

    public void setTodo(Todo todo) {
        this.todo = todo;
    }

}