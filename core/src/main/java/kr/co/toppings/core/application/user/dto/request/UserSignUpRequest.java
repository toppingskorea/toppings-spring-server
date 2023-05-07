package kr.co.toppings.core.application.user.dto.request;

import kr.co.toppings.core.domain.user.constants.Country;
import kr.co.toppings.core.domain.user.constants.Habit;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@Getter
@NoArgsConstructor(access = PRIVATE)
@AllArgsConstructor
public class UserSignUpRequest {
    private String name;
    private String email;
    private Country country;
    private List<Habit> habits;
}

