package kr.co.toppings.core.application.user.repository;

import org.springframework.stereotype.Repository;

import kr.co.toppings.core.infrastructure.user.repository.UserJpaRepository;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

	private final UserJpaRepository userJpaRepository;
}
