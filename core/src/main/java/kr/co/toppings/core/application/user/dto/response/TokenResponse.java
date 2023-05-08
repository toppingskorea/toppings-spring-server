package kr.co.toppings.core.application.user.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import static lombok.AccessLevel.PRIVATE;

@Getter
@AllArgsConstructor(access = PRIVATE)
public class TokenResponse {

    private String accessToken;

    private String refreshToken;
}
