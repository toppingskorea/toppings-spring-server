package kr.co.toppings.core.application.user.service;

import static kr.co.toppings.core.global.error.ErrorCode.*;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.toppings.core.domain.user.User;
import kr.co.toppings.core.global.error.BusinessException;
import kr.co.toppings.core.infrastructure.user.persistence.UserJpaRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserFindService {

	private final UserJpaRepository userJpaRepository;

	public User findByUserId(Long userId) {
		return userJpaRepository.findById(userId)
			.orElseThrow(() -> new BusinessException(NOT_EXIST_KEY));
	}
}
