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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/todo/v1")
@Tag(name = "Todo", description = "Endpoints for Todos")
public class TodoController {

	private TodoService service;

	public TodoController(TodoService service) {
		this.service = service;
	}
	
	@GetMapping
	@Operation(summary = "Finds all todos", description = "Finds all todos",
	tags = {"Todos"},
	responses = {
			@ApiResponse(description = "Success", responseCode="200",
					content = {
							@Content(
									mediaType = "Application/json",
									array = @ArraySchema(schema = @Schema(implementation = TodoVO.class))
									)
					}),
			@ApiResponse(description = "Bad Request", responseCode="400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode="401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode="404", content = @Content),
			@ApiResponse(description = "Internal Server Error", responseCode="500", content = @Content)
	})
	public ResponseEntity<List<TodoVO>> findAll() {
		return ResponseEntity.ok(service.findAll());
	}
	
	@GetMapping("/{id}")
	@Operation(summary = "Finds a todo by your ID", description = "Finds a todo by your ID",
	tags = {"Todos"},
	responses = {
			@ApiResponse(description = "Success", responseCode="200",
					content = {
							@Content(
									mediaType = "Application/json",
									array = @ArraySchema(schema = @Schema(implementation = TodoVO.class))
									)
					}),
			@ApiResponse(description = "Bad Request", responseCode="400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode="401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode="404", content = @Content),
			@ApiResponse(description = "Internal Server Error", responseCode="500", content = @Content)
	})
	public ResponseEntity<TodoVO> findById(@PathVariable(value = "id") Long id) {
		return ResponseEntity.ok(service.findById(id));
	}
	
	@PostMapping
	@Operation(summary = "Adds a new Todo", description = "Adds a new Todo by passing in a JSON representation of a Todo",
	tags = {"Todos"},
	responses = {
			@ApiResponse(description = "Created", responseCode="201",
					content = {
							@Content(
									mediaType = "Application/json",
									array = @ArraySchema(schema = @Schema(implementation = TodoVO.class))
									)
					}),
			@ApiResponse(description = "Bad Request", responseCode="400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode="401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode="404", content = @Content),
			@ApiResponse(description = "Internal Server Error", responseCode="500", content = @Content)
	})
	public ResponseEntity<List<TodoVO>> create(@RequestBody @Valid TodoVO todo) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.create(todo));
	}
	
	@PutMapping
	@Operation(summary = "Updates a Todo", description = "Updates a Todo by passing in a JSON representation of a Todo",
	tags = {"Todos"},
	responses = {
			@ApiResponse(description = "Success", responseCode="200",
					content = {
							@Content(
									mediaType = "Application/json",
									array = @ArraySchema(schema = @Schema(implementation = TodoVO.class))
									)
					}),
			@ApiResponse(description = "Bad Request", responseCode="400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode="401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode="404", content = @Content),
			@ApiResponse(description = "Internal Server Error", responseCode="500", content = @Content)
	})
	public ResponseEntity<List<TodoVO>> update(@RequestBody @Valid TodoVO todo) {
		return ResponseEntity.ok().body(service.update(todo));
	}
	
	@DeleteMapping("/{id}")
	@Operation(summary = "Deletes a Todo", description = "Deletes a Todo by passing your ID",
	tags = {"Todos"},
	responses = {
			@ApiResponse(description = "No Content", responseCode="204", content = @Content),
			@ApiResponse(description = "Bad Request", responseCode="400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode="401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode="404", content = @Content),
			@ApiResponse(description = "Internal Server Error", responseCode="500", content = @Content)
	})
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
