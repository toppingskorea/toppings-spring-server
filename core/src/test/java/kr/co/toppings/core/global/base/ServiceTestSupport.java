package kr.co.toppings.core.global.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import kr.co.toppings.core.infrastructure.user.persistence.UserQueryRepository;
import kr.co.toppings.core.infrastructure.user.persistence.UserUpdateRepository;
import lombok.RequiredArgsConstructor;

@SpringBootTest
@Transactional
public abstract class ServiceTestSupport {

	@Autowired
	protected UserQueryRepository userQueryRepository;

	@Autowired
	protected UserUpdateRepository userUpdateRepository;
}