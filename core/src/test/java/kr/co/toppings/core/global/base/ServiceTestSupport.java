package kr.co.toppings.core.global.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import kr.co.toppings.core.infrastructure.user.persistence.UserJpaRepository;
import kr.co.toppings.core.infrastructure.user.persistence.UserQueryRepository;
import lombok.RequiredArgsConstructor;

@SpringBootTest
@Transactional
@Rollback
public abstract class ServiceTestSupport {

	@Autowired
	protected UserQueryRepository userQueryRepository;

	@Autowired
	protected UserJpaRepository userJpaRepository;
}
