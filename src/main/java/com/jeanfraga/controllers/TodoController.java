package com.jeanfraga.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jeanfraga.services.TodoService;
import com.jeanfraga.vo.TodoVO;

@RestController
@RequestMapping("/api/todo/v1")
public class TodoController {

	private TodoService service;

	public TodoController(TodoService service) {
		this.service = service;
	}
	
	@GetMapping
	public ResponseEntity<List<TodoVO>> findAll() {
		return ResponseEntity.ok(service.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TodoVO> findById(@PathVariable(value = "id") Long id) {
		return ResponseEntity.ok(service.findById(id));
	}
	
	@PostMapping
	public ResponseEntity<List<TodoVO>> create(@RequestBody TodoVO todo) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.create(todo));
	}
	
	@PutMapping
	public ResponseEntity<List<TodoVO>> update(@RequestBody TodoVO todo) {
		return ResponseEntity.ok().body(service.update(todo));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
