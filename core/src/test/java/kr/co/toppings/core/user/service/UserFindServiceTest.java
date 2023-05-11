package kr.co.toppings.core.user.service;

import static kr.co.toppings.core.global.error.ErrorCode.*;
import static org.assertj.core.api.AssertionsForClassTypes.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import kr.co.toppings.core.application.user.service.UserFindService;
import kr.co.toppings.core.domain.user.User;
import kr.co.toppings.core.global.base.ServiceTestSupport;
import kr.co.toppings.core.global.error.BusinessException;
import kr.co.toppings.core.global.fixture.UserFixture;

@DisplayName("[Service] UserFind Test")
public class UserFindServiceTest extends ServiceTestSupport {

	@Autowired
	private UserFindService userFindService;

	@Test
	@DisplayName("[UserFind] UserId로 User 조회 성공")
	void 아이디_조회_성공() {
		//given
		User userA = UserFixture.A.toEntity();
		userUpdateRepository.save(userA);
		//when
		User resultA = userFindService.findByUserId(userA.getId());

		//then
		assertAll(
			() -> assertThat(resultA.getId()).isEqualTo(userA.getId()),
			() -> assertThat(resultA.getNicknameValue()).isEqualTo(userA.getNicknameValue()),
			() -> assertThat(resultA.getCountry()).isEqualTo(userA.getCountry()),
			() -> assertThat(resultA.getHabits()).isEqualTo(userA.getHabits())
		);
	}

	@Test
	@DisplayName("[UserFind] 존재하지 않는 UserId로 조회 실패")
	void 존재하지_않는_유저_아이디로_조회시_예외를_던진다() {
		Assertions.assertThatThrownBy(() -> userFindService.findByUserId(0L))
			.isInstanceOf(BusinessException.class)
			.hasMessageContaining(NOT_EXIST_KEY.getMessage());
	}
}
