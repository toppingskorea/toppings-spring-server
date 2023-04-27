package kr.co.toppings.core.infrastructure.user.persistence;

import kr.co.toppings.core.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserFindRepository extends JpaRepository<User, Long> {

}
