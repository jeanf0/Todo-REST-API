package com.jeanfraga.unitTests.mapper.mocks;

import java.util.ArrayList;
import java.util.List;

import com.jeanfraga.entities.Todo;
import com.jeanfraga.vo.TodoVO;

public class MockTodo {

	public Todo mockEntity() {
		return mockEntity(0);
	}
	
	public TodoVO mockVO() {
		return mockVO(0);
	}
	
	public List<Todo> mockEntityList() {
		List<Todo> todos = new ArrayList<>();
		for(int i =0; i < 14; i++) {
			todos.add(mockEntity(i));
		}
		return todos;
	}
	
	public List<TodoVO> mockVOList() {
		List<TodoVO> todos = new ArrayList<>();
		for(int i =0; i < 14; i++) {
			todos.add(mockVO(i));
		}
		return todos;
	}
	
	public Todo mockEntity(Integer i) {
		Todo todo = new Todo();
		todo.setId(i.longValue());
		todo.setNome("Nome" + i);
		todo.setDescricao("Descricao"+i);
		todo.setPrioridade(i);
		todo.setRealizado(false);
		return todo;
	}

	

	public TodoVO mockVO(Integer i) {
		TodoVO todo = new TodoVO();
		todo.setKey(i.longValue());
		todo.setNome("Nome" + i);
		todo.setDescricao("Descricao"+i);
		todo.setPrioridade(i);
		todo.setRealizado(false);
		return todo;
	}
	
	
}
