package com.jeanfraga.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import com.jeanfraga.controllers.TodoController;
import com.jeanfraga.entities.Todo;
import com.jeanfraga.exceptions.ResourceNotFoundException;
import com.jeanfraga.mapper.Mapper;
import com.jeanfraga.repositories.TodoRepository;
import com.jeanfraga.vo.TodoVO;

@Service
public class TodoService {
	
	private Logger logger = Logger.getLogger(TodoService.class.getName());

	private TodoRepository repository;

	public TodoService(TodoRepository repository) {
		this.repository = repository;
	}
	
	
	public List<TodoVO> findAll() {
		logger.info("Finding all todos");
		
		var todos = Mapper.parseListObjects(repository.findAll(), TodoVO.class);
		todos
			.stream()
			.forEach(t -> t.add(linkTo(methodOn(TodoController.class).findById(t.getKey())).withSelfRel()));
		return todos;
	}
	
	public TodoVO findById(Long id) {
		logger.info("Finding one Todo by ID");
		
		var entity = repository.findById(id)
			.orElseThrow(() ->  new ResourceNotFoundException("Not found resources for this ID!"));
		var vo = Mapper.parseObject(entity, TodoVO.class);
		vo.add(linkTo(methodOn(TodoController.class).findById(vo.getKey())).withSelfRel());
		return vo;
	}
	
	public List<TodoVO> create(TodoVO todo) {
		logger.info("Creating one todo");
		
		var entity = Mapper.parseObject(todo, Todo.class);
		repository.save(entity);
		return findAll();
	}
	
	public List<TodoVO> update(TodoVO todo) {
		logger.info("Updating one todo");
		
		var entity = repository.findById(todo.getKey())
				.orElseThrow(() ->  new ResourceNotFoundException("Not found resources for this ID!"));
		entity.setNome(todo.getNome());
		entity.setDescricao(todo.getDescricao());
		entity.setPrioridade(todo.getPrioridade());
		entity.setRealizado(todo.isRealizado());
		
		repository.save(entity);
		
		return findAll();
	}
	
	public List<TodoVO> delete(Long id) {
		logger.info("Deleting one Todo");
		
		var entity = repository.findById(id)
				.orElseThrow(() ->  new ResourceNotFoundException("Not found resources for this ID!"));
		
		repository.delete(entity);
		return findAll();
	}
}
