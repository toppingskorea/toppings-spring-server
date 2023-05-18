package kr.co.toppings.core.user.service;

import static kr.co.toppings.core.global.error.ErrorCode.*;
import static kr.co.toppings.core.global.fixture.UserFixture.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;

import kr.co.toppings.core.application.user.service.UserValidator;
import kr.co.toppings.core.domain.user.User;
import kr.co.toppings.core.global.base.ServiceTestSupport;
import kr.co.toppings.core.global.error.BusinessException;

@Rollback
@ActiveProfiles("test")
@DisplayName("[SpringBoot] - UserValidator Test")
class UserValidatorTest extends ServiceTestSupport {

	@Autowired
	private UserValidator userValidator;

	@Test
	@DisplayName("[UserValidator] 닉네임 중복 검증 서비스 테스트")
	void 중복_닉네임_검증() {
		//given
		User user = userJpaRepository.save(CREATE_SUCCESS_2HABIT.toEntity());

		//when & then
		assertThatThrownBy(
			() -> userValidator.validateNickNameIsNotDuplicated(user.getNickName()))
			.isInstanceOf(BusinessException.class)
			.hasMessageContaining(USER_DUPLICATED_NICKNAME.getMessage());
	}

	@Test
	@DisplayName("[UserValidator] 이메일 중복 검증 서비스 테스트")
	void 중복_이메일_검증() {
		//given
		User user = userJpaRepository.save(CREATE_SUCCESS_1HABIT.toEntity());

		//when & then
		assertThatThrownBy(
			() -> userValidator.validateEmailIsNotDuplicated(user.getEmail()))
			.isInstanceOf(BusinessException.class)
			.hasMessageContaining(USER_DUPLICATED_EMAIL.getMessage());
	}

}
