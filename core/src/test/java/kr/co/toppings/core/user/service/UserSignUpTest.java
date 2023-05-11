package kr.co.toppings.core.user.service;

import static kr.co.toppings.core.global.error.ErrorCode.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import kr.co.toppings.core.application.user.dto.request.UserSignUpRequest;
import kr.co.toppings.core.application.user.service.UserSignUpService;
import kr.co.toppings.core.domain.user.User;
import kr.co.toppings.core.global.base.ServiceTestSupport;
import kr.co.toppings.core.global.error.BusinessException;
import kr.co.toppings.core.infrastructure.user.persistence.UserQueryRepository;
import kr.co.toppings.core.user.controller.utils.SignUpRequestUtils;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@DisplayName("[Service] - SignUp Test")
class UserSignUpTest extends ServiceTestSupport {

	@Autowired
	private UserQueryRepository userQueryRepository;

	@Autowired
	private UserSignUpService userSignUpService;

	@Test
	@DisplayName("[SignUp] 정상 성공")
	void 회원가입_정상_성공() {
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
				assertThat(user.getNicknameValue()).isEqualTo(request.getUserNickName());
				assertThat(user.getCountry()).isEqualTo(request.getCountry());
				assertThat(user.getUserEmailValue()).isEqualTo(request.getEmail());
				assertThat(user.getHabits()).hasSize(request.getHabits().size());
			}
		);
	}

	@Test
	@DisplayName("[SignUp] 중복 닉네임 실패")
	void 중복된_닉네임으로_회원가입시_예외를_던진다() {
		//given
		UserSignUpRequest requestA = SignUpRequestUtils.successRequest();
		UserSignUpRequest requestB = SignUpRequestUtils.successRequest();

		//when
		Long savedUserIdA = userSignUpService.signUpUser(requestA);

		//then
		assertThatThrownBy(
			() -> userSignUpService.signUpUser(requestB))
			.isInstanceOf(BusinessException.class)
			.hasMessageContaining(USER_DUPLICATED_NICKNAME.getMessage()
			);
	}

	@Test
	@DisplayName("[SignUp] 중복 이메일 실패")
	void 중복된_이메일로_회원가입시_예외를_던진다() {
		//given
		UserSignUpRequest requestA = SignUpRequestUtils.successRequest();
		UserSignUpRequest requestB = SignUpRequestUtils.successRequest2();

		//when
		Long savedUserIdA = userSignUpService.signUpUser(requestA);

		//then
		assertThatThrownBy(
			() -> userSignUpService.signUpUser(requestB))
			.isInstanceOf(BusinessException.class)
			.hasMessageContaining(USER_DUPLICATED_EMAIL.getMessage()
			);
	}
}
