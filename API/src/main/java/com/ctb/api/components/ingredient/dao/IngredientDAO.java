package com.ctb.api.components.ingredient.dao;

import com.ctb.api.components.other.dao.RecipeIngredient;
import com.ctb.other.DB;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = DB.INGREDIENT)
public class IngredientDAO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "type", nullable = false)
	private String type;

	@OneToMany(mappedBy = "fkIngredientId",
			cascade = CascadeType.ALL,
			orphanRemoval = true)
	private List<RecipeIngredient> ingredients = new ArrayList<>();
}
