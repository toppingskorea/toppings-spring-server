package kr.co.toppings.core.user.domain;

import static kr.co.toppings.core.global.error.ErrorCode.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import javax.validation.constraints.Email;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import kr.co.toppings.core.domain.user.UserEmail;
import kr.co.toppings.core.global.error.BusinessException;
import kr.co.toppings.core.global.error.ErrorCode;

@DisplayName("[Domain] - Email Test")
public class UserEmailTest {

	private static final String VALID_EMAIL1 = "hbeeen@naver.com";
	private static final String VALID_EMAIL2 = "hbeeenbackendmaster@studet.42seoul.kr";
	private static final String VALID_EMAIL3 = "k_gn@naver.com";

	//Too short (at least 6 char)
	private static final String INVALID_EMAIL1 = "short@";

	private static final String INVALID_EMAIL2 = "@ab@xy@z";
	private static final String INVALID_EMAIL3 = "a@";

	@Test
	@DisplayName("[Email] 부적합 이메일 실패 검증")
	void 부적합_이메일_실패로_예외를_던진다() {
		//given
		ErrorCode expectedError = USER_INVALID_EMAIL;

		//when, then
		assertAll(
			() -> assertThatThrownBy(() -> new UserEmail(INVALID_EMAIL1)).isInstanceOf(BusinessException.class)
				.hasMessageContaining(expectedError.getMessage()),
			() -> assertThatThrownBy(() -> new UserEmail(INVALID_EMAIL2)).isInstanceOf(BusinessException.class)
				.hasMessageContaining(expectedError.getMessage()),
			() -> assertThatThrownBy(() -> new UserEmail(INVALID_EMAIL3)).isInstanceOf(BusinessException.class)
				.hasMessageContaining(expectedError.getMessage())
		);
	}

	@Test
	@DisplayName("[Email] 적합 이메일 성공 검증")
	void 적합_닉네임_성공() {
		//given
		UserEmail userEmail1 = new UserEmail(VALID_EMAIL1);
		UserEmail userEmail2 = new UserEmail(VALID_EMAIL2);
		UserEmail userEmail3 = new UserEmail(VALID_EMAIL3);

		//when, then
		assertAll(
			() -> assertThat(userEmail1.getValue()).isEqualTo(VALID_EMAIL1),
			() -> assertThat(userEmail2.getValue()).isEqualTo(VALID_EMAIL2),
			() -> assertThat(userEmail3.getValue()).isEqualTo(VALID_EMAIL3)
		);
	}
}
