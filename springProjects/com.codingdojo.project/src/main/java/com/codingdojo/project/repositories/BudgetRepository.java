package com.codingdojo.project.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.project.models.Budget;

@Repository
public interface BudgetRepository extends CrudRepository<Budget, Long> {
	List<Budget> findAll();
}
