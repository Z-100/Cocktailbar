package com.ctb.api.components.recipe.repository;

import com.ctb.api.components.recipe.dao.RecipeDAO;
import org.springframework.data.repository.CrudRepository;

public interface IRecipeRepository extends CrudRepository<RecipeDAO, Long> {

	Iterable<RecipeDAO> findAll();
}
