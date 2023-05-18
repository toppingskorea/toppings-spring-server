package kr.co.toppings.core.user.domain;

import static kr.co.toppings.core.global.fixture.UserFixture.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import kr.co.toppings.core.domain.user.User;

@DisplayName("[Domain] - User Test")
public class UserTest {

	@Test
	@DisplayName("[User] 사용자 생성 메소드 테스트")
	void 사용자_생성_메소드_테스트() {
		//given
		User user = CREATE_SUCCESS_2HABIT.toEntity();

		//when & then
		Assertions.assertAll(
			() -> assertThat(user.getNickNameValue()).isEqualTo(CREATE_SUCCESS_2HABIT.getNickName()),
			() -> assertThat(user.getEmailValue()).isEqualTo(CREATE_SUCCESS_2HABIT.getEmail()),
			() -> assertThat(user.getCountry()).isEqualTo(CREATE_SUCCESS_2HABIT.getCountry()),
			() -> assertThat(user.getHabits()).hasSize(CREATE_SUCCESS_2HABIT.getHabits().size())
		);

	}
}
