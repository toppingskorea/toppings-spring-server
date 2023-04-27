package kr.co.toppings.core.application.user.persistence;

import kr.co.toppings.core.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
