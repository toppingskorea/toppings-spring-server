package kr.co.toppings.core.user.service;

import kr.co.toppings.core.application.user.dto.request.UserProfile;
import kr.co.toppings.core.application.user.service.UserSignUpService;
import kr.co.toppings.core.domain.user.User;
import kr.co.toppings.core.infrastructure.user.persistence.UserQueryRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static kr.co.toppings.core.domain.user.constants.Country.KOREA;
import static kr.co.toppings.core.fixture.UserFixture.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@Slf4j
@SpringBootTest
@DisplayName("[회원가입]")
class UserSignUpTest {

    @Autowired
    private UserQueryRepository userQueryRepository;

    @Autowired
    private UserSignUpService userSignUpService;

    @Test
    @Rollback
    @Transactional
    @DisplayName("[회원가입] 정상 성공")
    void signUpSuccess() throws Exception {
        //given
        UserProfile userProfile = new UserProfile(A.getName(), A.getEmail(), A.getCountry(), A.getHabits());

        //when
        Long savedUserId = userSignUpService.signUpUser(userProfile);

        //then
        Optional<User> result = userQueryRepository.findById(savedUserId);

        assertAll(
                () -> assertThat(result).isPresent(),
                () -> {
                    User actual = result.orElseThrow();
                    assertThat(actual.getId()).isEqualTo(savedUserId);
                    assertThat(actual.getCountry()).isEqualTo(KOREA);
                    assertThat(actual.getHabits()).hasSize(userProfile.getHabits()
                                                                      .size());
                }
        );
    }
}
