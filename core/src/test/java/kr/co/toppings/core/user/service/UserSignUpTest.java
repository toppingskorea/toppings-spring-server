package kr.co.toppings.core.user.service;

import kr.co.toppings.core.application.user.dto.request.UserProfile;
import kr.co.toppings.core.application.user.persistence.UserRepository;
import kr.co.toppings.core.application.user.service.UserSignUpService;
import kr.co.toppings.core.domain.user.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static kr.co.toppings.core.fixture.UserFixture.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@Slf4j
@SpringBootTest
@DisplayName("회원가입 서비스 테스트")
class UserSignUpTest {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserSignUpService userSignUpService;

    @Test
    @Rollback
    @Transactional
    @DisplayName("[SignUp]")
    void signUpSuccess() throws Exception {
        //given
        UserProfile userProfile = new UserProfile(A.getName(), A.getEmail(), A.getCountry(), A.getHabits());

        //when
        Long savedUserId = userSignUpService.signUpUser(userProfile);

        //then
        Optional<User> result = userRepository.findById(savedUserId);

        assertAll(
                () -> assertThat(result).isPresent(),
                () -> {
                    User actual = result.orElseThrow();
                    assertThat(actual.getId()).isEqualTo(savedUserId);
                    assertThat(actual.getHabits()).hasSize(userProfile.getHabits()
                                                                      .size());
                }
        );
    }
}
