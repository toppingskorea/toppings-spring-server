package kr.co.toppings.core.user.service;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import kr.co.toppings.core.application.user.dto.request.UserSignUpRequest;
import kr.co.toppings.core.application.user.service.UserSignUpService;
import kr.co.toppings.core.domain.user.User;
import kr.co.toppings.core.global.base.ServiceTestSupport;
import kr.co.toppings.core.global.error.BusinessException;
import kr.co.toppings.core.global.error.ErrorCode;
import kr.co.toppings.core.infrastructure.user.persistence.UserQueryRepository;
import kr.co.toppings.core.user.controller.utils.SignUpRequestUtils;

@Rollback
@DisplayName("[User-SignUpTest] - SpringBootTest")
class UserSignUpTest extends ServiceTestSupport {

	@Autowired
	private UserQueryRepository userQueryRepository;

	@Autowired
	private UserSignUpService userSignUpService;

	@Test
	@DisplayName("[SignUp] 정상 성공")
	void signUpSuccess() {
		//given
		UserSignUpRequest request = SignUpRequestUtils.successRequest();

		//when
		Long savedUserId = userSignUpService.signUpUser(request);

		//then
		Optional<User> result = userQueryRepository.findById(savedUserId);

		assertAll(
			() -> assertThat(result).isPresent(),
			() -> {
				User user = result.orElseThrow();
				assertThat(user.getId()).isEqualTo(savedUserId);
				assertThat(user.getCountry()).isEqualTo(request.getCountry());
				assertThat(user.getEmail()).isEqualTo(request.getEmail());
				assertThat(user.getHabits()).hasSize(request.getHabits().size());
			}
		);
	}

	@Test
	@DisplayName("[SignUp] 중복 닉네임 실패")
	void failByDuplicatedNickName() {
		//given
		UserSignUpRequest requestA = SignUpRequestUtils.successRequest();
		UserSignUpRequest requestB = SignUpRequestUtils.successRequest();

		//when
		Long savedUserIdA = userSignUpService.signUpUser(requestA);

		//then
		assertThatThrownBy(
			() -> userSignUpService.signUpUser(requestB))
			.isInstanceOf(BusinessException.class)
			.hasMessageContaining(ErrorCode.USER_DUPLICATED_NICKNAME.getMessage()
			);
	}
}
