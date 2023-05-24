package kr.co.toppings.core.user.controller.utils;

import static kr.co.toppings.core.global.fixture.UserFixture.*;

import kr.co.toppings.core.application.user.dto.request.UserInfoRequest;
import kr.co.toppings.core.global.fixture.UserFixture;

public abstract class SignUpRequestUtils {
	private static final UserFixture testcase = CREATE_SUCCESS_1HABIT;

	public static UserInfoRequest successRequest1() {
		return new UserInfoRequest(
			testcase.getNickName(),
			testcase.getEmail(),
			testcase.getCountry(),
			testcase.getHabits()
		);
	}

	public static UserInfoRequest successRequest2() {
		return new UserInfoRequest(
			testcase.getNickName(),
			"sample@naver.com",
			testcase.getCountry(),
			testcase.getHabits()
		);
	}

	public static UserInfoRequest successRequest3() {
		return new UserInfoRequest(
			"sample",
			testcase.getEmail(),
			testcase.getCountry(),
			testcase.getHabits()
		);
	}
}
