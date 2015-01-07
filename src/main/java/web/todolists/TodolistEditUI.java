package web.todolists;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Date;
import javax.inject.Inject;
import todolists.boundary.TodolistsEndpoint;
import todolists.entity.Todolist;
import todos.entity.Todo;

/**
 *
 * @author marcin
 */
@Named(value = "todolistEditUI")
@SessionScoped
public class TodolistEditUI implements Serializable {

    @Inject
    TodolistsEndpoint todoListsEndpoint;

    private Todolist todolist;
    private Todo todo;

    /**
     * Creates a new instance of TodolistEditUI
     */
    public TodolistEditUI() {
    }

    public String editTodolist(Todolist tl) {
        System.out.println("editTodolist....");
        this.todolist = todoListsEndpoint.find(tl.getId());
        System.out.println("editTodolist: todolist: " + todolist);
        return "todolist";
    }

    public void addTodo() {
        System.out.println("addTodo: " + todo);
        System.out.println("todolist: " + todolist);        
      
        todolist.addTodo(todo);
        todoListsEndpoint.update(todolist);
        this.todolist = todoListsEndpoint.find(todolist.getId());
        todo = new Todo();

    }

    public void removeTodo(Todo todo) {

        System.out.println("remove todolist todolist: " + todolist.getId());
        todolist.removeTodo(todo);
        todoListsEndpoint.update(todolist);
        ///return "todolist?id=" + todolist.getId();
    }

    public void update() {
        System.out.println("updateing.....");
        System.out.println("todolist in update: " + todolist);
        todoListsEndpoint.update(todolist);
        todolist = todoListsEndpoint.find(todolist.getId());
        // return "todolist?id=" + todolist.getId();
    }

    public Todolist getTodolist() {
        return todolist;
    }

    public void setTodolist(Todolist todolist) {
        this.todolist = todolist;
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
