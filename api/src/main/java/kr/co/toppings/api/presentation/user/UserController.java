package kr.co.toppings.api.presentation.user;

import org.springframework.web.bind.annotation.RestController;

import kr.co.toppings.core.application.user.facade.UserServiceFacade;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserController {

	private final UserServiceFacade userServiceFacade;
}
