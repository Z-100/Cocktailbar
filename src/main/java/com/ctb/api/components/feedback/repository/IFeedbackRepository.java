package com.ctb.api.components.feedback.repository;

import com.ctb.api.components.feedback.dao.FeedbackDAO;
import com.ctb.api.components.recipe.dao.RecipeDAO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IFeedbackRepository extends CrudRepository<FeedbackDAO, Long> {

	List<FeedbackDAO> findByEmail(String email);

	List<FeedbackDAO> findByRecipe(RecipeDAO recipe);
}
