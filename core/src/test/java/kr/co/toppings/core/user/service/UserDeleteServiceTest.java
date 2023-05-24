package kr.co.toppings.core.user.service;

import static kr.co.toppings.core.global.error.ErrorCode.*;
import static kr.co.toppings.core.global.fixture.UserFixture.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;

import kr.co.toppings.core.application.user.service.UserDeleteService;
import kr.co.toppings.core.application.user.service.UserFindService;
import kr.co.toppings.core.domain.user.User;
import kr.co.toppings.core.global.base.ServiceTestSupport;
import kr.co.toppings.core.global.error.BusinessException;

@ActiveProfiles("test")
@DisplayName("[SpringBootTest] - UserDelete Test")
public class UserDeleteServiceTest extends ServiceTestSupport {

	@Autowired
	UserDeleteService userDeleteService;

	@Autowired
	UserFindService userFindService;

	@Test
	@DisplayName("[UserDelete] 회원 탈퇴 성공")
	void 회원_탈퇴에_성공한다() {
		//given
		User user = userJpaRepository.save(CREATE_SUCCESS_2HABIT.toEntity());
		User savedUser = userQueryRepository.findById(user.getId()).get();
		assertThat(user).isEqualTo(savedUser);
		//when
		userDeleteService.deleteUser(savedUser.getId());

		//then
		assertThatThrownBy(
			() -> userFindService.findByUserId(savedUser.getId()))
			.isInstanceOf(BusinessException.class)
			.hasMessageContaining(NOT_EXIST_KEY.getMessage()
			);
	}
}
