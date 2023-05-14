package kr.co.toppings.core.user.domain;

import static kr.co.toppings.core.global.error.ErrorCode.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;

import kr.co.toppings.core.domain.user.Email;
import kr.co.toppings.core.global.error.BusinessException;
import kr.co.toppings.core.global.error.ErrorCode;

@DisplayName("[Domain] - Email Test")
@ActiveProfiles("test")
class EmailTest {

	private static final String VALID_EMAIL1 = "sample1@naver.com";
	private static final String VALID_EMAIL2 = "sample2@kakao.com";
	private static final String VALID_EMAIL3 = "sample3@student.42seoul.kr";
	private static final String WRONG_EMAIL1 = "twodots..";
	private static final String WRONG_EMAIL2 = "multigolbaeng@@naver.com";
	private static final String WRONG_EMAIL3 = "nodots";

	@Test
	@DisplayName("[Email] 부적합 이메일 실패 검증")
	void 이메일_패턴_오류로_예외를_던진다() {
		//given
		ErrorCode expectedError = USER_INVALID_EMAIL;

		//when, then
		assertAll(
			() -> assertThatThrownBy(() -> new Email(WRONG_EMAIL1)).isInstanceOf(BusinessException.class)
				.hasMessageContaining(expectedError.getMessage()),
			() -> assertThatThrownBy(() -> new Email(WRONG_EMAIL2)).isInstanceOf(BusinessException.class)
				.hasMessageContaining(expectedError.getMessage()),
			() -> assertThatThrownBy(() -> new Email(WRONG_EMAIL3)).isInstanceOf(BusinessException.class)
				.hasMessageContaining(expectedError.getMessage())
		);
	}

	@Test
	@DisplayName("[Email] 적합 이메일 성공 검증")
	void 적합한_이메일() {
		//given
		Email valid1 = new Email(VALID_EMAIL1);
		Email valid2 = new Email(VALID_EMAIL2);
		Email valid3 = new Email(VALID_EMAIL3);

		//when, then
		assertAll(
			() -> assertThat(valid1.getValue()).isEqualTo(VALID_EMAIL1),
			() -> assertThat(valid2.getValue()).isEqualTo(VALID_EMAIL2),
			() -> assertThat(valid3.getValue()).isEqualTo(VALID_EMAIL3)
		);
	}
}
