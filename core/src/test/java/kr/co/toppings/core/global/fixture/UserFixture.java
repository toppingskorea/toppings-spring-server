package kr.co.toppings.core.global.fixture;

import static kr.co.toppings.core.domain.user.constants.Country.*;
import static kr.co.toppings.core.domain.user.constants.Habit.*;

import java.util.ArrayList;
import java.util.List;

import kr.co.toppings.core.domain.user.User;
import kr.co.toppings.core.domain.user.constants.Country;
import kr.co.toppings.core.domain.user.constants.Habit;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserFixture {

	// Valid User
	A("hbeeen", "joker7011@naver.com", KOREA, List.of(HALAL, NOSUGAR)),
	B("hyeoshin", "hyeoshin@student.42seoul.kr", KOREA, List.of(HALAL)),
	C("saelim", "saelim@student.42seoul.kr", KOREA, new ArrayList<>());

	private final String userNickName;

	private final String email;

	private final Country country;

	private final List<Habit> habits;

	public User toEntity() {
		return User.createUser(
			userNickName,
			email,
			country,
			habits
		);
	}
}
