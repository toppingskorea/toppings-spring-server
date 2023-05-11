package kr.co.toppings.core.user.domain;

import static kr.co.toppings.core.global.error.ErrorCode.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import kr.co.toppings.core.domain.user.UserNickName;
import kr.co.toppings.core.global.error.BusinessException;
import kr.co.toppings.core.global.error.ErrorCode;

@DisplayName("[Domain] - NickName Test")
public class UserNickNameTest {

	private static final String VALID_NICKNAME1 = "hbeeen";
	private static final String VALID_NICKNAME2 = "hbeeenbackendmaster";
	private static final String VALID_NICKNAME3 = "kgnkgn";

	//Too short (at least 6 char)
	private static final String WRONG_NICKNAME1 = "short";

	//Too Long (under than 20 char)
	private static final String WRONG_NICKNAME2 = "abcdefghijklmnopqrstuvwxyz";

	//Include another char except alphabet letter
	private static final String WRONG_NICKNAME3 = "변해빈";

	@Test
	@DisplayName("[Nickname] 부적합 닉네임 실패 검증")
	void invalidNickName() {
		//given
		ErrorCode expectedError = USER_INVALID_NICKNAME;

		//when, then
		assertAll(
			() -> assertThatThrownBy(() -> new UserNickName(WRONG_NICKNAME1)).isInstanceOf(BusinessException.class)
				.hasMessageContaining(expectedError.getMessage()),
			() -> assertThatThrownBy(() -> new UserNickName(WRONG_NICKNAME2)).isInstanceOf(BusinessException.class)
				.hasMessageContaining(expectedError.getMessage()),
			() -> assertThatThrownBy(() -> new UserNickName(WRONG_NICKNAME3)).isInstanceOf(BusinessException.class)
				.hasMessageContaining(expectedError.getMessage())
		);
	}

	@Test
	@DisplayName("[NickName] 적합 닉네임 성공 검증")
	void validNickName() {
		//given
		UserNickName userNickName1 = new UserNickName(VALID_NICKNAME1);
		UserNickName userNickName2 = new UserNickName(VALID_NICKNAME2);
		UserNickName userNickName3 = new UserNickName(VALID_NICKNAME3);

		//when, then
		assertAll(
			() -> assertThat(userNickName1.getValue()).isEqualTo(VALID_NICKNAME1),
			() -> assertThat(userNickName2.getValue()).isEqualTo(VALID_NICKNAME2),
			() -> assertThat(userNickName3.getValue()).isEqualTo(VALID_NICKNAME3)
		);
	}
}
