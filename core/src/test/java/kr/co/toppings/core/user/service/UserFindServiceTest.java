package kr.co.toppings.core.user.service;

import static kr.co.toppings.core.global.fixture.UserFixture.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;

import kr.co.toppings.core.application.user.service.UserFindService;
import kr.co.toppings.core.domain.user.User;
import kr.co.toppings.core.global.base.ServiceTestSupport;

@Rollback
@DisplayName("[SpringBootTest] - UserFind Test")
@ActiveProfiles("test")
class UserFindServiceTest extends ServiceTestSupport {

	@Autowired
	private UserFindService userFindService;

	@Test
	@DisplayName("[UserFind] 정상 성공")
	void 아이디_유저_조회_성공() {
	    //given
		User validUserA = CREATE_SUCCESS_2HABIT.toEntity();
		userJpaRepository.save(validUserA);
	    //when
		User result = userFindService.findByUserId(validUserA.getId());

	    //then
		assertAll(
			() -> assertThat(result.getId()).isEqualTo(validUserA.getId()),
			() -> assertThat(result.getNickName()).isEqualTo(validUserA.getNickName()),
			() -> assertThat(result.getEmail()).isEqualTo(validUserA.getEmail()),
			() -> assertThat(result.getCountry()).isEqualTo(validUserA.getCountry()),
			() -> assertThat(result.getHabits()).hasSize(validUserA.getHabits().size())
		);
	}
}
