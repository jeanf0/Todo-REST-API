package com.jeanfraga.mapper;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

import com.jeanfraga.entities.Todo;
import com.jeanfraga.vo.TodoVO;

public class Mapper {
	
	private static ModelMapper mapper = new ModelMapper();
	static {
		mapper.createTypeMap(Todo.class, TodoVO.class).addMapping(Todo::getId, TodoVO::setKey);
	}
	
	public static <O, D> D parseObject(O origin, Class<D> destination) {
		return mapper.map(origin, destination);
	}
	
	public static <O, D> List<D> parseListObjects(List<O> origin, Class<D> destination) {
		List<D> destinationList = new ArrayList<>();
		for (O o : origin) {
			destinationList.add(mapper.map(o, destination));
		}
		return destinationList;
	}
}
