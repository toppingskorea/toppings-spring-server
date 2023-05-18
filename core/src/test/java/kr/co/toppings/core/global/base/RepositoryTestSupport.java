package kr.co.toppings.core.global.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import kr.co.toppings.core.infrastructure.user.persistence.UserJpaRepository;
import kr.co.toppings.core.infrastructure.user.persistence.UserQueryRepository;

@DataJpaTest
public abstract class RepositoryTestSupport {

	@Autowired
	protected UserQueryRepository userQueryRepository;
}
