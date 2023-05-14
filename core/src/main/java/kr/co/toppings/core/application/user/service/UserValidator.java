package kr.co.toppings.core.application.user.service;

import static kr.co.toppings.core.global.error.ErrorCode.*;

import org.springframework.stereotype.Service;

import kr.co.toppings.core.domain.user.Email;
import kr.co.toppings.core.domain.user.NickName;
import kr.co.toppings.core.global.error.BusinessException;
import kr.co.toppings.core.infrastructure.user.persistence.UserQueryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserValidator {

	private final UserQueryRepository userQueryRepository;

	public void validateNickNameIsNotDuplicated(NickName nickName) {
		if (userQueryRepository.existsByNickName(nickName)) {
			log.warn("Exist NickName = {}", nickName.getValue());
			throw new BusinessException(USER_DUPLICATED_NICKNAME);
		}
	}

	public void validateEmailIsNotDuplicated(Email email) {
		if (userQueryRepository.existsByEmail(email)) {
			log.warn("Exist Email = {}", email.getValue());
			throw new BusinessException(USER_DUPLICATED_EMAIL);
		}
	}
}
