package kr.co.toppings.core.user.controller.utils;

import static kr.co.toppings.core.global.fixture.UserFixture.*;

import kr.co.toppings.core.application.user.dto.request.UserUpdateRequest;
import kr.co.toppings.core.global.fixture.UserFixture;

public abstract class UpdateRequestUtils {
	private static final UserFixture testcase = CREATE_SUCCESS_4HABIT;

	public static UserUpdateRequest update4Habits() {
		return new UserUpdateRequest(
			testcase.getNickName(),
			testcase.getCountry(),
			testcase.getHabits()
		);
	}
}
