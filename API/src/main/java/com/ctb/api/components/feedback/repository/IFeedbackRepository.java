package com.ctb.api.components.feedback.repository;

import com.ctb.api.components.feedback.dao.FeedbackDAO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IFeedbackRepository extends CrudRepository<FeedbackDAO, Long> {

	List<FeedbackDAO> findByFkAccountId(Long fkAccountId);

	List<FeedbackDAO> findByFkRecipeId(Long fkRecipeId);

	FeedbackDAO getById(Long id);
}
