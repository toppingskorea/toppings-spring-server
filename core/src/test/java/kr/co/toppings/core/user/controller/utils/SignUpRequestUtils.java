package kr.co.toppings.core.user.controller.utils;

import static kr.co.toppings.core.domain.user.constants.Habit.*;

import java.util.ArrayList;
import java.util.List;

import kr.co.toppings.core.application.user.dto.request.UserSignUpRequest;
import kr.co.toppings.core.domain.user.constants.Habit;
import kr.co.toppings.core.global.fixture.UserFixture;

public abstract class SignUpRequestUtils {
	private static final UserFixture a = UserFixture.A;

	public static UserSignUpRequest successRequest() {
		return new UserSignUpRequest(
			a.getName(),
			a.getEmail(),
			a.getCountry(),
			a.getHabits()
		);
	}
}
