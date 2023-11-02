package com.jeanfraga.unitTests.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.jeanfraga.entities.Todo;
import com.jeanfraga.mapper.Mapper;
import com.jeanfraga.unitTests.mapper.mocks.MockTodo;
import com.jeanfraga.vo.TodoVO;

public class MapperTest {

MockTodo inputObject;
	
	@BeforeEach
	public void setup() {
		inputObject = new MockTodo();
	}
	
	@Test
	public void parseEntityToVoTest() {
		TodoVO output = Mapper.parseObject(inputObject.mockEntity(), TodoVO.class);
		assertEquals(Long.valueOf(0L), output.getKey());
		assertEquals("Nome0", output.getNome());
		assertEquals("Descricao0", output.getDescricao());
		assertEquals(0, output.getPrioridade());
		assertEquals(false, output.isRealizado());
	}
	
	@Test
    public void parseEntityListToVOListTest() {
        List<TodoVO> outputList = Mapper.parseListObjects(inputObject.mockEntityList(), TodoVO.class);
        TodoVO outputZero = outputList.get(0);
        
        assertEquals(Long.valueOf(0L), outputZero.getKey());
		assertEquals("Nome0", outputZero.getNome());
		assertEquals("Descricao0", outputZero.getDescricao());
		assertEquals(0, outputZero.getPrioridade());
		assertEquals(false, outputZero.isRealizado());
        
        TodoVO outputSeven = outputList.get(7);
        
        assertEquals(Long.valueOf(7L), outputSeven.getKey());
		assertEquals("Nome7", outputSeven.getNome());
		assertEquals("Descricao7", outputSeven.getDescricao());
		assertEquals(7, outputSeven.getPrioridade());
		assertEquals(false, outputSeven.isRealizado());
        
        TodoVO outputTwelve = outputList.get(12);
        
        assertEquals(Long.valueOf(12L), outputTwelve.getKey());
		assertEquals("Nome12", outputTwelve.getNome());
		assertEquals("Descricao12", outputTwelve.getDescricao());
		assertEquals(12, outputTwelve.getPrioridade());
		assertEquals(false, outputTwelve.isRealizado());
    }

    @Test
    public void parseVOToEntityTest() {
        Todo output = Mapper.parseObject(inputObject.mockVO(), Todo.class);
        assertEquals(0, output.getId());
		assertEquals("Nome0", output.getNome());
		assertEquals("Descricao0", output.getDescricao());
		assertEquals(0, output.getPrioridade());
		assertEquals(false, output.isRealizado());
    }
}
