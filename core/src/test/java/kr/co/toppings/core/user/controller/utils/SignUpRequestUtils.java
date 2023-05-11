package kr.co.toppings.core.user.controller.utils;

import kr.co.toppings.core.application.user.dto.request.UserSignUpRequest;
import kr.co.toppings.core.global.fixture.UserFixture;

public abstract class SignUpRequestUtils {
	private static final UserFixture a = UserFixture.A;

	public static UserSignUpRequest successRequest() {
		return new UserSignUpRequest(
			a.getUserNickName(),
			a.getEmail(),
			a.getCountry(),
			a.getHabits()
		);
	}

	public static UserSignUpRequest successRequest2() {
		return new UserSignUpRequest(
			"hbyeon",
			a.getEmail(),
			a.getCountry(),
			a.getHabits()
		);
	}
}
