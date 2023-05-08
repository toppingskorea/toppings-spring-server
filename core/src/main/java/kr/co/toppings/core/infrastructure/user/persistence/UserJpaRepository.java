package kr.co.toppings.core.infrastructure.user.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.co.toppings.core.domain.user.NickName;
import kr.co.toppings.core.domain.user.User;

public interface UserJpaRepository extends JpaRepository<User, Long> {
	boolean existsByNickName(NickName nickName);
}
