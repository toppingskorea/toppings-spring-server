package kr.co.toppings.core.global.base;

import org.springframework.beans.factory.annotation.Autowired;

import kr.co.toppings.core.application.user.service.UserValidator;
import kr.co.toppings.core.infrastructure.user.persistence.UserQueryRepository;
import kr.co.toppings.core.infrastructure.user.persistence.UserUpdateRepository;

public abstract class RepositoryTestSupport {

	@Autowired
	protected UserValidator userValidator;

	@Autowired
	protected UserQueryRepository userQueryRepository;

	@Autowired
	protected UserUpdateRepository userUpdateRepository;
}
