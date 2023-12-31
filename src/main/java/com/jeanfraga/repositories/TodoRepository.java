package com.jeanfraga.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jeanfraga.entities.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long>{
}
