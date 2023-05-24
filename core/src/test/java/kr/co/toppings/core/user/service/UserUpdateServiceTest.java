package kr.co.toppings.core.user.service;

import static kr.co.toppings.core.global.fixture.UserFixture.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;

import kr.co.toppings.core.application.user.dto.request.UserUpdateRequest;
import kr.co.toppings.core.application.user.service.UserUpdateService;
import kr.co.toppings.core.domain.user.User;
import kr.co.toppings.core.global.base.ServiceTestSupport;
import kr.co.toppings.core.user.controller.utils.UpdateRequestUtils;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@DisplayName("[SpringBoot] - UserUpdate Test")
@ActiveProfiles("test")
class UserUpdateServiceTest extends ServiceTestSupport {

	@Autowired
	private UserUpdateService userUpdateService;

	@Test
	@DisplayName("[UserUpdate] 정상 성공")
	void 회원정보_수정_정상_성공() {

		//given (2Habits -> 4Habits, KOREA -> JAPAN, Nickname Change)
		User user = userJpaRepository.save(CREATE_SUCCESS_2HABIT.toEntity());
		log.info("SignUp Habits Size = {}", user.getHabits().size());
		UserUpdateRequest request = UpdateRequestUtils.update4Habits();

		//when
		userUpdateService.updateUser(user.getId(), request);
		log.info("change Habits Size = {}", user.getHabits().size());

		//then
		assertAll(
			() -> assertThat(user.getNickNameValue()).isEqualTo(request.getNickName()),
			() -> assertThat(user.getCountry()).isEqualTo(request.getCountry()),
			() -> assertThat(user.getHabits()).hasSize(request.getHabits().size())
		);
	}

	//todo 현재 request -> 닉네임, 국적, 식습관 동시 수정, 요청을 어떻게 받아 올 것인지, 서비스 로직을 분리할 지 결정해야 함.
	//todo 수정 사항만 받아와서 updateUser 메소드 돌리는 것 고려해봐야 할 듯

	//todo
	// @Test
	// @DisplayName("[UserUpdate] 중복 닉네임으로 수정에 실패하고 예외를 던진다")
	// void 중복된_닉네임으로_수정에_실패하고_예외를_던진다() {
	// }
}
