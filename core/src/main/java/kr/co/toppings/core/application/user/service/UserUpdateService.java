package kr.co.toppings.core.application.user.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.toppings.core.application.user.dto.request.UserInfoRequest;
import kr.co.toppings.core.domain.user.User;
import kr.co.toppings.core.infrastructure.user.persistence.UserJpaRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserUpdateService {

	private final UserValidator userValidator;
	private final UserJpaRepository userJpaRepository;

	@Transactional
	public Long updateUser(UserInfoRequest request) {
		User user = generateUser(request);
		validateUser(user);
		User saveUser = userJpaRepository.save(user);
		return saveUser.getId();
	}

	private void validateUser(User user) {
		userValidator.validateNickNameIsNotDuplicated(user.getNickName());
		userValidator.validateEmailIsNotDuplicated(user.getEmail());
	}

	private User generateUser(UserInfoRequest request) {
		return User.createUser(
			request.getNickName(),
			request.getEmail(),
			request.getCountry(),
			request.getHabits()
		);
	}
}
