package kr.co.toppings.core.application.user.service;

import kr.co.toppings.core.application.user.dto.request.UserProfile;
import kr.co.toppings.core.application.user.persistence.UserRepository;
import kr.co.toppings.core.domain.user.User;
import kr.co.toppings.core.domain.user.UserHabit;
import kr.co.toppings.core.domain.user.constants.Country;
import kr.co.toppings.core.domain.user.constants.Habit;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 1. 회원가입 - 국적을 선택해야 한다. (NotNull, 단일값)
 * 2. 회원가입 - 식습관을 선택할 수 있다. (Nullable, 다중값)
 */


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserSignUpService {

    private final UserRepository userRepository;

    @Transactional
    public Long signUpUser(UserProfile request) {
        User user = generateUser(request);
        //검증 로직 추가 예정
        User saveUser = userRepository.save(user);
        return saveUser.getId();
    }

    // 이미 회원가입된 유저인지 검증하는 로직
    private User generateUser(UserProfile request) {
        return User.createUser(
                request.getName(),
                request.getEmail(),
                request.getCountry(),
                request.getHabits()
        );
    }
}
