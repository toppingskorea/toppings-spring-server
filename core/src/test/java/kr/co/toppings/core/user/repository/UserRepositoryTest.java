package kr.co.toppings.core.user.repository;

import static kr.co.toppings.core.global.fixture.UserFixture.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;

import kr.co.toppings.core.domain.user.User;
import kr.co.toppings.core.global.base.RepositoryTestSupport;
import kr.co.toppings.core.infrastructure.user.persistence.UserJpaRepository;

@DisplayName("[Repository] - User Test")
@ActiveProfiles("test")
class UserRepositoryTest extends RepositoryTestSupport {

	@Autowired
	UserJpaRepository userJpaRepository;

	private User userA;
	private User userB;
	private User userC;

	@BeforeEach
	void saveUsers() {
		userA = CREATE_SUCCESS_2HABIT.toEntity();
		userB = CREATE_SUCCESS_1HABIT.toEntity();
		userC = CREATE_SUCCESS_0HABIT.toEntity();

		userJpaRepository.save(userA);
		userJpaRepository.save(userB);
		userJpaRepository.save(userC);
	}

	@Test
	@DisplayName("[UserRepository] 사용자 저장 테스트")
	void 회원_저장_테스트() {
		//given
		User findUserA = userQueryRepository.findById(userA.getId()).get();
		User findUserB = userQueryRepository.findById(userB.getId()).get();
		User findUserC = userQueryRepository.findById(userC.getId()).get();

		//when & then
		assertAll(
			() -> assertThat(findUserA.getEmailValue()).isEqualTo(userA.getEmailValue()),
			() -> assertThat(findUserB.getEmailValue()).isEqualTo(userB.getEmailValue()),
			() -> assertThat(findUserC.getEmailValue()).isEqualTo(userC.getEmailValue())
		);

	}
}
