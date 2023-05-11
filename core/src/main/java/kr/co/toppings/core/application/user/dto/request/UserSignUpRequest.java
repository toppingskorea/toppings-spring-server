package kr.co.toppings.core.application.user.dto.request;

import static lombok.AccessLevel.*;

import java.util.List;

import kr.co.toppings.core.domain.user.constants.Country;
import kr.co.toppings.core.domain.user.constants.Habit;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = PRIVATE)
@AllArgsConstructor
public class UserSignUpRequest {
    private String userNickName;
    private String email;
    private Country country;
    private List<Habit> habits;
}

