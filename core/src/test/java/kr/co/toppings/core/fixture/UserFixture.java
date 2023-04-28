package kr.co.toppings.core.fixture;


import kr.co.toppings.core.application.user.dto.request.UserProfile;
import kr.co.toppings.core.domain.user.User;
import kr.co.toppings.core.domain.user.constants.Country;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserFixture {
    A("변해빈", "joker7011@naver.com", Country.KOR),
    B("남은찬", "nahm23@naver.com", Country.KOR),
    C("신현호", "hyeoshin@student.42seoul.kr", Country.KOR);

    private final String name;

    private final String email;

    private final Country country;

    public User toEntity() {
        return User.createUser(
                name,
                email,
                country
        );
    }
}
