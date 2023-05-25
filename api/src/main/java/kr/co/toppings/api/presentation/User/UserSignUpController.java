package kr.co.toppings.api.presentation.User;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.toppings.api.global.dto.response.Success;
import kr.co.toppings.core.application.user.dto.request.UserSignUpRequest;
import kr.co.toppings.core.application.user.service.UserSignUpService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserSignUpController {

	private final UserSignUpService userSignUpService;

	@PostMapping
	public ResponseEntity<Success> createUser(@RequestBody UserSignUpRequest createRequest) {
		Long userId = userSignUpService.signUpUser(createRequest);

		return ResponseEntity
			.created(URI.create("/api/user/" + userId))
			.body(new Success());
	}
}
