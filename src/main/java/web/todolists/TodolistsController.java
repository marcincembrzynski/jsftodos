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
        System.out.println("remove todolist: " + todolist);
        System.out.println("todos: " + todolist.getTodos());
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
    
    public void update(Todolist todolist){
        System.out.println("update todolist: " + todolist);
        System.out.println("todos: " + todolist.getTodos());
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