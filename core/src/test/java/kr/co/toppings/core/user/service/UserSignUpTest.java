package kr.co.toppings.core.user.service;

import static kr.co.toppings.core.global.error.ErrorCode.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;

import kr.co.toppings.core.application.user.dto.request.UserSignUpRequest;
import kr.co.toppings.core.application.user.service.UserSignUpService;
import kr.co.toppings.core.domain.user.User;
import kr.co.toppings.core.global.base.ServiceTestSupport;
import kr.co.toppings.core.global.error.BusinessException;
import kr.co.toppings.core.user.controller.utils.SignUpRequestUtils;

@Rollback
@DisplayName("[SpringBoot] - UserSignUp Test")
@ActiveProfiles("test")
class UserSignUpTest extends ServiceTestSupport {

	@Autowired
	private UserSignUpService userSignUpService;

	@Test
	@DisplayName("[SignUp] 정상 성공")
	void 회원가입_정상_성공() {
		//given
		UserSignUpRequest request = SignUpRequestUtils.successRequest1();

		//when
		Long savedUserId = userSignUpService.signUpUser(request);

		//then
		Optional<User> result = userQueryRepository.findById(savedUserId);

		assertAll(
			() -> assertThat(result).isPresent(),
			() -> {
				User user = result.orElseThrow();
				assertThat(user.getId()).isEqualTo(savedUserId);
				assertThat(user.getNickName().getValue()).isEqualTo(request.getNickName());
				assertThat(user.getCountry()).isEqualTo(request.getCountry());
				assertThat(user.getEmail().getValue()).isEqualTo(request.getEmail());
				assertThat(user.getHabits()).hasSize(request.getHabits().size());
			}
		);
	}

	@Test
	@DisplayName("[SignUp] 중복 닉네임으로 회원가입 실패")
	void 중복_닉네임으로_회원가입간_예외를_던진다() {
		//given
		UserSignUpRequest sameNickNameA = SignUpRequestUtils.successRequest1();
		UserSignUpRequest sameNickNameB = SignUpRequestUtils.successRequest2();

		//when
		Long savedUserIdA = userSignUpService.signUpUser(sameNickNameA);

		//then
		assertThatThrownBy(
			() -> userSignUpService.signUpUser(sameNickNameB))
			.isInstanceOf(BusinessException.class)
			.hasMessageContaining(USER_DUPLICATED_NICKNAME.getMessage()
			);
	}

	@Test
	@DisplayName("[SignUp] 중복 이메일로 회원가입 실패")
	void 중복_이메일로_회원가입간_예외를_던진다() {
		//given
		UserSignUpRequest sameEmailA = SignUpRequestUtils.successRequest1();
		UserSignUpRequest sameEmailB = SignUpRequestUtils.successRequest3();

		//when
		Long savedUserIdA = userSignUpService.signUpUser(sameEmailA);

		//then
		assertThatThrownBy(
			() -> userSignUpService.signUpUser(sameEmailB))
			.isInstanceOf(BusinessException.class)
			.hasMessageContaining(USER_DUPLICATED_EMAIL.getMessage()
			);
	}
}
