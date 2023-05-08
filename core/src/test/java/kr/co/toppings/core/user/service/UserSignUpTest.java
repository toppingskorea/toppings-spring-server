package kr.co.toppings.core.user.service;

import kr.co.toppings.core.application.user.dto.request.UserSignUpRequest;
import kr.co.toppings.core.application.user.service.UserSignUpService;
import kr.co.toppings.core.domain.user.User;
import kr.co.toppings.core.global.base.ServiceTest;
import kr.co.toppings.core.user.controller.utils.SignUpRequestUtils;
import kr.co.toppings.core.infrastructure.user.persistence.UserQueryRepository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayName("[UserSignUpTest - SpringBootTest]")
class UserSignUpTest extends ServiceTest {

	@Autowired
	private UserQueryRepository userQueryRepository;

	@Autowired
	private UserSignUpService userSignUpService;

	@Test
	@Rollback
	@DisplayName("[회원가입] 정상 성공")
	void signUpSuccess() throws Exception {
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
}
