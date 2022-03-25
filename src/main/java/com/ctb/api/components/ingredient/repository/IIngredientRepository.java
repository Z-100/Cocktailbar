package com.ctb.api.components.ingredient.repository;

import com.ctb.api.components.ingredient.dao.IngredientDAO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IIngredientRepository extends CrudRepository<IngredientDAO, Long> {

}
