package kr.co.toppings.core.infrastructure.user.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.co.toppings.core.domain.user.User;
import kr.co.toppings.core.domain.user.UserEmail;
import kr.co.toppings.core.domain.user.UserNickName;

public interface UserJpaRepository extends JpaRepository<User, Long> {
	Optional<User> findByUserEmail(UserEmail userEmail);
	boolean existsByUserNickName(UserNickName userNickName);
	boolean existsByUserEmail(UserEmail userEmail);
}
