package com.ctb.api.components.recipe.services.crud.impl;

import com.ctb.api.components.recipe.repository.IRecipeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class DeleteExistingRecipeServiceTest {

	@Autowired
	private IRecipeRepository recipeRepository;

	@Test
	void delete() {
		recipeRepository.findAll().forEach(e -> System.out.println(e.getTitle()));
		System.out.println("\n\n\n");
		System.out.println(recipeRepository.getById(2L).getTitle());
	}
}