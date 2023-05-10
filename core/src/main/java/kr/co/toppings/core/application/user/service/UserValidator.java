package kr.co.toppings.core.application.user.service;

import static kr.co.toppings.core.global.error.ErrorCode.*;

import org.springframework.stereotype.Service;

import kr.co.toppings.core.domain.user.NickName;
import kr.co.toppings.core.global.error.BusinessException;
import kr.co.toppings.core.infrastructure.user.persistence.UserQueryRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserValidator {

	private final UserQueryRepository userQueryRepository;

	public void validateNickNameIsNotDuplicated(NickName nickName) {
		if(userQueryRepository.existsByNickName(nickName)){
			throw new BusinessException(USER_DUPLICATED_NICKNAME);
		}
	}
}
