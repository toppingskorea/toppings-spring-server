package kr.co.toppings.core.fixture;

import kr.co.toppings.core.domain.user.constants.Country;
import kr.co.toppings.core.domain.user.constants.Habit;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public enum UserFixture {

    A("변해빈", "joker7011@naver.com", Country.KOREA, new ArrayList<>()),
    B("남은찬", "nahm23@naver.com", Country.KOREA, new ArrayList<>()),
    C("신현호", "hyeoshin@student.42seoul.kr", Country.KOREA, new ArrayList<>());

    private final String name;

    private final String email;

    private final Country country;

    private final List<Habit> habits;
}
