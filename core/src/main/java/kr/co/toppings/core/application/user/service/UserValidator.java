package kr.co.toppings.core.application.user.service;

import static kr.co.toppings.core.global.error.ErrorCode.*;

import org.springframework.stereotype.Service;

import kr.co.toppings.core.domain.user.UserNickName;
import kr.co.toppings.core.global.error.BusinessException;
import kr.co.toppings.core.infrastructure.user.persistence.UserQueryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserValidator {

	private final UserQueryRepository userQueryRepository;

	public void validateNickNameIsNotDuplicated(UserNickName userNickName) {
		if(userQueryRepository.existsByNickName(userNickName)){
			log.warn("duplicated NickName = {}", userNickName);
			throw new BusinessException(USER_DUPLICATED_NICKNAME);
		}
	}
}
