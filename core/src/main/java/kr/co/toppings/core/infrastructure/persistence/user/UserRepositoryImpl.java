package kr.co.toppings.core.infrastructure.persistence.user;

import org.springframework.stereotype.Repository;

import kr.co.toppings.core.application.user.persistence.UserRepository;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

	private final UserJpaRepository userJpaRepository;
}
