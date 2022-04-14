package com.ctb.api.components.recipe.dao;

import com.ctb.api.components.account.dao.AccountDAO;
import com.ctb.api.components.feedback.dao.FeedbackDAO;
import com.ctb.api.components.other.dao.RecipeIngredient;
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
@Table(name = DB.RECIPE)
public class RecipeDAO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "title", nullable = false)
	private String title;

	@Column(name = "description", nullable = false)
	private String description;

	@ManyToOne
	@JoinColumn(name = "fkAccountId")
	@JsonManagedReference
	private AccountDAO fkAccountId;

	@OneToMany(mappedBy = "fkRecipeId",
			cascade = CascadeType.ALL,
			orphanRemoval = true)
	private List<RecipeIngredient> ingredients;

	@OneToMany(cascade = {CascadeType.ALL},
			orphanRemoval = true,
			mappedBy = "fkRecipeId")
	@JsonBackReference
	private List<FeedbackDAO> feedbacks;
}
