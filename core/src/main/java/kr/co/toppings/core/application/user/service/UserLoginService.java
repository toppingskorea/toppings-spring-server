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


    // OAuth2 -> 앞단에서 나한테 인증토큰, 리프레쉬토큰
    // 로그인시도를 했을때 이사람이 회원가입이 되어있는가? findById로 검증하는 로직
    // 마이페이지
    // 리뷰

    @Transactional
    public Long signUpUser(UserProfile request) {
        User user = generateUser(request);
        //검증 로직 추가 예정
        User saveUser = userRepository.save(user);
        return saveUser.getId();
    }

    private User generateUser(UserProfile request) {
        return User.createUser(
                request.getName(),
                request.getEmail(),
                request.getCountry());
    }
}
