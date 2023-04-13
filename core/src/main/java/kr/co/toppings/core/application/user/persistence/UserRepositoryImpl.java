package kr.co.toppings.core.application.user.persistence;

import org.springframework.stereotype.Repository;

import kr.co.toppings.core.infrastructure.persistence.user.UserJpaRepository;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

	private final UserJpaRepository userJpaRepository;
}
