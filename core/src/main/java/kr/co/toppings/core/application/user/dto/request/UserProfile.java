package kr.co.toppings.core.application.user.dto.request;

import kr.co.toppings.core.domain.user.constants.Country;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@Getter
@NoArgsConstructor(access = PRIVATE)
@AllArgsConstructor
public class UserProfile {
    private String name;
    private String email;
    private Country country;
}

