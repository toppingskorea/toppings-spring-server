package kr.co.toppings.core.user.service;

import kr.co.toppings.core.application.user.dto.request.UserProfile;
import kr.co.toppings.core.application.user.service.UserLoginService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@Nested
@DisplayName("로그인 서비스 테스트")
public class UserServiceTest {

    @Autowired
    private UserLoginService userLoginService;

    @Test
    @DisplayName("회원가입에 성공 -> ")
    void signUpSuccess() throws Exception {
        //given


        //when

        //then
        
        
    }
}
