package com.ctb.api.components.recipe.repository;

import com.ctb.api.components.account.dao.AccountDAO;
import com.ctb.api.components.recipe.dao.RecipeDAO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IRecipeRepository extends CrudRepository<RecipeDAO, Long> {

	RecipeDAO getById(Long id);

	List<RecipeDAO> getAllByFkAccountId(AccountDAO account);

	List<RecipeDAO> findAll();

	List<RecipeDAO> getTop10ByOrderByIdDesc();

	Page<RecipeDAO> findAll(Pageable pageable);
}
