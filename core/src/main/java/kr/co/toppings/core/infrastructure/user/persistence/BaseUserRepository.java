package kr.co.toppings.core.infrastructure.user.persistence;

import org.springframework.stereotype.Repository;

import kr.co.toppings.core.application.user.persistence.UserRepository;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class BaseUserRepository {

	private final UserJpaRepository userJpaRepository;
}
