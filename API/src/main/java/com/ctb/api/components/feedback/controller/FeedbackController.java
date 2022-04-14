package com.ctb.api.components.feedback.controller;

import com.ctb.api.components.feedback.dto.FeedbackDTO;
import com.ctb.api.components.feedback.services.crud.ICreateNewFeedbackService;
import com.ctb.api.components.feedback.services.crud.IDeleteExistingFeedbackService;
import com.ctb.api.components.feedback.services.crud.IReadExistingFeedbackService;
import com.ctb.other.API;
import com.ctb.other.Response;
import com.ctb.other.URL;
import com.ctb.other.replacement.JsonBoolean;
import com.ctb.service.validation.ITokenValidationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(URL.FEEDBACK)
@AllArgsConstructor
public class FeedbackController {

	private final ITokenValidationService tokValidation;

	private final ICreateNewFeedbackService createService;
	private final IDeleteExistingFeedbackService deleteService;
	private final IReadExistingFeedbackService readService;

	@PostMapping(API.INSERT)
	public ResponseEntity<?> insertNewFeedback(
			@RequestHeader("email") String email,
			@RequestHeader("token") String token,
			@RequestHeader("recipe-id") String fkRecipeId,
			@RequestHeader("title") String title,
			@RequestHeader("description") String description,
			@RequestHeader("rating") String rating) {

		if (!tokValidation.validate(email, token))
			return new ResponseEntity<>(Response.INVALID_TOKEN, HttpStatus.INTERNAL_SERVER_ERROR);

		if (createService.insertNewFeedback(email, fkRecipeId, title, description, rating) == 0)
			return new ResponseEntity<>(Response.SOMETHING_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);

		return new ResponseEntity<>(Response.SUCCESS_INSERT, HttpStatus.OK);
	}

	@PostMapping(API.DELETE)
	public ResponseEntity<?> deleteFeedback(
			@RequestHeader("email") String email,
			@RequestHeader("token") String token,
			@RequestHeader("feedback-id") String id) {

		if (tokValidation.validate(email, token))
			return new ResponseEntity<>(Response.INVALID_TOKEN, HttpStatus.INTERNAL_SERVER_ERROR);

		if (deleteService.delete(id) == 0)
			return new ResponseEntity<>(Response.SOMETHING_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);

		return new ResponseEntity<>(Response.SUCCESS_DELETE, HttpStatus.OK);
	}

	@GetMapping(API.GET + API.ALL) // "{accountId}"
	public ResponseEntity<?> getAllFeedbackFromAccount(
			@RequestParam("accountId") String accountId) {

		List<FeedbackDTO> feedbacks = readService.getFeedbacks(accountId);

		if (feedbacks == null)
			return new ResponseEntity<>(Response.NOT_FOUND, HttpStatus.INTERNAL_SERVER_ERROR);

		return new ResponseEntity<>(feedbacks, HttpStatus.OK);
	}

	@GetMapping(API.GET + API.ALL) // "{recipeId}"
	public ResponseEntity<?> getAllFeedbackFromRecipe(
			@RequestParam("recipe-id") String recipeId) {

		List<FeedbackDTO> feedbacks = readService.getFeedbacks(Long.valueOf(recipeId));

		if (feedbacks == null)
			return new ResponseEntity<>(Response.NOT_FOUND, HttpStatus.INTERNAL_SERVER_ERROR);

		return new ResponseEntity<>(feedbacks, HttpStatus.OK);
	}

	//	@PostMapping(API.UPDATE) TODO: Implement update feedback
	public JsonBoolean updateFeedback() {
		return null;
	}
}
