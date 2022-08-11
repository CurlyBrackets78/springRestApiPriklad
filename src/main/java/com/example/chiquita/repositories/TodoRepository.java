package com.example.chiquita.repositories;

import com.example.chiquita.entities.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TodoRepository extends JpaRepository<TodoEntity, UUID> {

}
