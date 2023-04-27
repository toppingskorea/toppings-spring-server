package kr.co.toppings.core.application.user.service;

import kr.co.toppings.core.application.user.dto.request.UserProfile;
import kr.co.toppings.core.application.user.persistence.UserRepository;
import kr.co.toppings.core.domain.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserLoginService {

    private final UserRepository userRepository;

    @Transactional
    public Long signUpUser(UserProfile request) {
        User user = generateUser(request);
        //검증 로직 추가 예정
        User saveUser = userRepository.save(user);
        return saveUser.getId();

    }

    @Transactional
    private User generateUser(UserProfile request) {
        return User.createUser(request.getName(),
                request.getEmail(),
                request.getCountry());
    }
}
