package kr.co.toppings.core.global.fixture;

import static kr.co.toppings.core.domain.user.constants.Habit.*;

import kr.co.toppings.core.domain.user.User;
import kr.co.toppings.core.domain.user.constants.Country;
import kr.co.toppings.core.domain.user.constants.Habit;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

@Getter
@AllArgsConstructor
public enum UserFixture {

	// Valid User
	A("hbeeen", "joker7011@naver.com", Country.KOREA, List.of(HALAL, NOSUGAR)),
	B("김당근", "hyeoshin@student.42seoul.kr", Country.KOREA, List.of(HALAL)),
	C("김당근", "hyeoshin@student.42seoul.kr", Country.KOREA, new ArrayList<>());

	private final String nickName;

	private final String email;

	private final Country country;

	private final List<Habit> habits;

	public User toEntity() {
		return User.createUser(
			email,
			nickName,
			country,
			habits
		);
	}
}
