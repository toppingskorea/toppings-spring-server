package kr.co.toppings.core.infrastructure.user.persistence;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import kr.co.toppings.core.domain.user.Email;
import kr.co.toppings.core.domain.user.NickName;

@Repository
@Transactional(readOnly = true)
public interface UserQueryRepository extends UserJpaRepository{
	boolean existsByNickName(NickName nickName);
	boolean existsByEmail(Email email);
}
