package kr.co.toppings.core.global.fixture;

import static kr.co.toppings.core.domain.user.constants.Country.*;
import static kr.co.toppings.core.domain.user.constants.Habit.*;

import kr.co.toppings.core.domain.user.User;
import kr.co.toppings.core.domain.user.constants.Country;
import kr.co.toppings.core.domain.user.constants.Habit;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public enum UserFixture {

	// Valid User
	CREATE_SUCCESS_2HABIT("hbeeen", "joker7011@naver.com", KOREA, List.of(HALAL, NOSUGAR)),
	CREATE_SUCCESS_1HABIT("kgnkgn", "hbyeon@student.42seoul.kr", KOREA, List.of(HALAL)),
	CREATE_SUCCESS_0HABIT("backendmaster", "been2spring@gmail.com", JAPAN, new ArrayList<>()),
	CREATE_FAIL_BY_NICKNAME("short", "onlyinvalidnickname@naver.com", KOREA, new ArrayList<>()),
	CREATE_FAIL_BY_EMAIL("twodots", "onlyinvalidnickname@naver..", JAPAN, new ArrayList<>());

	private final String nickName;

	private final String email;

	private final Country country;

	private final List<Habit> habits;

	public User toEntity() {
		return User.createUser(
			nickName,
			email,
			country,
			habits
		);
	}
}
