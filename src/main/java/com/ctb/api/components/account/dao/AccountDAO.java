package com.ctb.api.components.account.dao;

import com.ctb.api.components.feedback.dao.FeedbackDAO;
import com.ctb.api.components.recipe.dao.RecipeDAO;
import com.ctb.other.DB;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = DB.ACCOUNT)
public class AccountDAO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;

	@Column(name = "token")
	private String token;

	@Column(name = "username")
	private String username;

	@OneToMany(cascade = {CascadeType.ALL},
			orphanRemoval = true,
			mappedBy = "fkAccountId")
	@JsonBackReference
	private List<RecipeDAO> recipes;

	@OneToMany(cascade = {CascadeType.ALL},
			orphanRemoval = true,
			mappedBy = "fkAccountId")
	@JsonBackReference
	private List<FeedbackDAO> feedbacks;
}
