package kr.co.toppings.core.application.user.service;

import static kr.co.toppings.core.global.error.ErrorCode.*;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.toppings.core.domain.user.User;
import kr.co.toppings.core.global.error.BusinessException;
import kr.co.toppings.core.infrastructure.user.persistence.UserQueryRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserFindService {

	private final UserQueryRepository userQueryRepository;

	public User findByUserId(Long UserId) {
		return userQueryRepository.findById(UserId).orElseThrow(
			() -> new BusinessException(NOT_EXIST_KEY)
		);
	}
}
