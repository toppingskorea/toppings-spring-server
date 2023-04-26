package kr.co.toppings.api.presentation.user;

import kr.co.toppings.core.application.user.facade.UserServiceFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserServiceFacade userServiceFacade;


}
