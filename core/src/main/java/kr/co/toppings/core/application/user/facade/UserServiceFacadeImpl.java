package kr.co.toppings.core.application.user.facade;

import org.springframework.stereotype.Service;

import kr.co.toppings.core.application.user.service.UserFindService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceFacadeImpl implements UserServiceFacade {

	private final UserFindService userFindService;
}
