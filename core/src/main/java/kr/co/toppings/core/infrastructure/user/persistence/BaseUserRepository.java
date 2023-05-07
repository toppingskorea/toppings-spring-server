package kr.co.toppings.core.infrastructure.user.persistence;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class BaseUserRepository{

	private final UserQueryRepository userQueryRepository;
}
