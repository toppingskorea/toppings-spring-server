package kr.co.toppings.core.application.user.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.toppings.core.application.user.dto.request.UserSignUpRequest;
import kr.co.toppings.core.application.user.dto.request.UserUpdateRequest;
import kr.co.toppings.core.domain.user.NickName;
import kr.co.toppings.core.domain.user.User;
import kr.co.toppings.core.infrastructure.user.persistence.UserJpaRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserUpdateService {

	private final UserValidator userValidator;
	private final UserFindService userFindService;

	@Transactional
	public void updateUser(Long userId, UserUpdateRequest request) {
		User user = userFindService.findByUserId(userId);
		NickName nickName = new NickName(request.getNickName());

		userValidator.validateNickNameIsNotDuplicated(nickName);
		user.updateNickName(nickName);
		user.updateHabits(request.getHabits());
	}

}
