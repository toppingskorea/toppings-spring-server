package kr.co.toppings.core.fixture;

import kr.co.toppings.core.application.user.service.UserSignUpService;
import kr.co.toppings.core.domain.user.User;
import kr.co.toppings.core.domain.user.UserHabit;
import kr.co.toppings.core.domain.user.constants.Country;
import kr.co.toppings.core.domain.user.constants.Habit;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

import static kr.co.toppings.core.domain.user.constants.Habit.BUDDHISM;
import static kr.co.toppings.core.domain.user.constants.Habit.HINDUISM;

@Getter
@AllArgsConstructor
public enum UserFixture {

    A("변해빈", "joker7011@naver.com", Country.KOR, new ArrayList<>()),
    B("남은찬", "nahm23@naver.com", Country.KOR, new ArrayList<>()),
    C("신현호", "hyeoshin@student.42seoul.kr", Country.KOR, new ArrayList<>());

    private final String name;

    private final String email;

    private final Country country;

    private final List<Habit> habits;
}
