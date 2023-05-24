package kr.co.toppings.core.user.controller.utils;

import static kr.co.toppings.core.global.fixture.UserFixture.*;

import kr.co.toppings.core.application.user.dto.request.UserSignUpRequest;
import kr.co.toppings.core.global.fixture.UserFixture;

public abstract class SignUpRequestUtils {
	private static final UserFixture testcase = CREATE_SUCCESS_1HABIT;

	public static UserSignUpRequest successRequest1() {
		return new UserSignUpRequest(
			testcase.getNickName(),
			testcase.getEmail(),
			testcase.getCountry(),
			testcase.getHabits()
		);
	}

	public static UserSignUpRequest successRequest2() {
		return new UserSignUpRequest(
			testcase.getNickName(),
			"sample@naver.com",
			testcase.getCountry(),
			testcase.getHabits()
		);
	}

	public static UserSignUpRequest successRequest3() {
		return new UserSignUpRequest(
			"sample",
			testcase.getEmail(),
			testcase.getCountry(),
			testcase.getHabits()
		);
	}
}
