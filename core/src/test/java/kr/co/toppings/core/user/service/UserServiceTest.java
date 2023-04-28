package kr.co.toppings.core.user.service;

import kr.co.toppings.core.application.user.dto.request.UserProfile;
import kr.co.toppings.core.application.user.persistence.UserRepository;
import kr.co.toppings.core.application.user.service.UserLoginService;
import kr.co.toppings.core.domain.user.User;
import kr.co.toppings.core.domain.user.constants.Country;
import kr.co.toppings.core.fixture.UserFixture;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static kr.co.toppings.core.fixture.UserFixture.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@Slf4j
@SpringBootTest
@DisplayName("로그인 서비스 테스트")
public class UserServiceTest {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserLoginService userLoginService;

    @Test
    @DisplayName("로그인 ")
    void signUpSuccess() throws Exception {
        //given
        UserProfile userProfile = new UserProfile(A.getName(), A.getEmail(), A.getCountry());

        //when
        Long savedUserId = userLoginService.signUpUser(userProfile);

        //then
        Optional<User> result = userRepository.findById(savedUserId);
        assertAll(
                () -> assertThat(result).isPresent(),
                () -> {
                    User actual = result.orElseThrow();
                    assertThat(actual.getId()).isEqualTo(savedUserId);
                }
        );

    }
}
