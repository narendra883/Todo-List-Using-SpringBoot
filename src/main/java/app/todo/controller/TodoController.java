package app.todo.controller;

import app.todo.model.Todo;
import app.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
public class TodoController {
    @Autowired
    private TodoService todoService;

    @PostMapping("/createtodo")
    public ResponseEntity<Todo> createTodo(@RequestBody Todo todo){
        return ResponseEntity.ok(todoService.createTodo(todo));
    }

    @GetMapping("/")
    public ResponseEntity<List<Todo>> getAllTodos(){
        return ResponseEntity.ok(todoService.getAllTodos());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable Long id, @RequestBody Todo todo){
        todo.setTaskId(id);
        return ResponseEntity.ok(todoService.updateTodo(todo));
    }

    @GetMapping("/completed")
    public ResponseEntity<List<Todo>> getAllCompletedTodos(){
        return ResponseEntity.ok(todoService.findAllCompletedTodos());
    }

    @GetMapping("/incomplete")
    public ResponseEntity<List<Todo>> getAllIncompletedTodos(){
        return ResponseEntity.ok(todoService.findAllIncompletedTodos());
    }
}
