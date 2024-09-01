package app.todo.service;

import app.todo.model.Todo;
import app.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    public List<Todo> findAllCompletedTodos;
    @Autowired
    private TodoRepository todoRepository;


    public Todo createTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    public Todo updateTodo(Todo todo) {
        return todoRepository.save(todo);
    }
    public List<Todo> findAllCompletedTodos(){

        return todoRepository.findByCompletedTrue();
    }


    public List<Todo> findAllIncompletedTodos() {
        return todoRepository.findByCompletedFalse();
    }
}
