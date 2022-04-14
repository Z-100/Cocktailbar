package com.ctb.api.components.recipe.repository;

import com.ctb.api.components.recipe.dao.RecipeDAO;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IRecipeRepository extends CrudRepository<RecipeDAO, Long> {

	RecipeDAO getById(Long id);

	List<RecipeDAO> findAllByFkAccountId(Long id);

	List<RecipeDAO> findAll();

	List<RecipeDAO> getAllOrderByIdDescLimitFive();

	List<RecipeDAO> getAllOrderByRandomLimitTen();
}
