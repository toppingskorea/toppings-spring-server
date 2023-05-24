package kr.co.toppings.core.application.user.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.toppings.core.application.user.dto.request.UserSignUpRequest;
import kr.co.toppings.core.domain.user.User;
import kr.co.toppings.core.infrastructure.user.persistence.UserJpaRepository;
import lombok.RequiredArgsConstructor;

/**
 * 1. 회원가입 - 국적을 선택해야 한다. (NotNull, 단일값)
 * 2. 회원가입 - 식습관을 선택할 수 있다. (Nullable, 다중값)
 */

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserSignUpService {

	private final UserValidator userValidator;
	private final UserJpaRepository userJpaRepository;

	@Transactional
	public Long signUpUser(UserSignUpRequest request) {
		User user = generateUser(request);
		validateUser(user);
		User saveUser = userJpaRepository.save(user);
		return saveUser.getId();
	}

	private void validateUser(User user) {
		userValidator.validateNickNameIsNotDuplicated(user.getNickName());
		userValidator.validateEmailIsNotDuplicated(user.getEmail());
	}

	private User generateUser(UserSignUpRequest request) {
		return User.createUser(
			request.getNickName(),
			request.getEmail(),
			request.getCountry(),
			request.getHabits()
		);
	}
}
