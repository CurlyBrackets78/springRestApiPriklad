package com.example.chiquita.controllers;

import com.example.chiquita.entities.TodoEntity;
import com.example.chiquita.requests.CreateTodoRequest;
import com.example.chiquita.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController()
@RequestMapping("/api/v1")
public class TodoController {

  private final TodoService toDoService;

  @Autowired
  public TodoController(TodoService todoService) {
    this.toDoService = todoService;
  }

  // [POST] /user/gfgdfgdfdgf/todo

  @PostMapping("/user/{userId}/todo")
  public ResponseEntity<Object> createTodo(
    @PathVariable("userId") UUID userId,
    @RequestBody @Valid CreateTodoRequest todoRequest
  ) throws Exception {
    var todoEntity = toDoService.create(todoRequest, userId);

    return ResponseEntity.ok().body(todoEntity);
  }
}
