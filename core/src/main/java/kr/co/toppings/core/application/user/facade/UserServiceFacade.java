package kr.co.toppings.core.application.user.facade;

import org.springframework.stereotype.Service;

import kr.co.toppings.core.application.user.service.UserDeleteService;
import kr.co.toppings.core.application.user.service.UserFindService;
import kr.co.toppings.core.application.user.service.UserUpdateService;
import kr.co.toppings.core.application.user.service.UserSignUpService;
import kr.co.toppings.core.application.user.service.UserValidator;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceFacade {
	private final UserValidator userValidator;
	private final UserFindService userFindService;
	private final UserSignUpService userSignUpService;
	private final UserUpdateService userUpdateService;
	private final UserDeleteService userDeleteService;
}
