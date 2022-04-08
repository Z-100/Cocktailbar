package com.ctb.api.components.feedback.dao;

import com.ctb.api.components.account.dao.AccountDAO;
import com.ctb.api.components.recipe.dao.RecipeDAO;
import com.ctb.other.DB;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = DB.FEEDBACK)
public class FeedbackDAO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "title", nullable = false)
	private String title;

	@Column(name = "description", nullable = false)
	private String description;

	// Rating 1-5, where 1 is worst and 5 is best
	@Column(name = "rating", nullable = false)
	private Integer rating;

	@ManyToOne
	@JoinColumn(name = "fkAccountId")
	@JsonManagedReference
	private AccountDAO fkAccountId;

	@ManyToOne
	@JoinColumn(name = "fkRecipeId")
	@JsonManagedReference
	private RecipeDAO fkRecipeId;
}
