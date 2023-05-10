package kr.co.toppings.core.user.domain;

import static kr.co.toppings.core.global.error.ErrorCode.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import kr.co.toppings.core.domain.user.NickName;
import kr.co.toppings.core.global.error.BusinessException;
import kr.co.toppings.core.global.error.ErrorCode;

@DisplayName("[Domain] - NickName Test")
public class NickNameTest {

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
			() -> assertThatThrownBy(() -> new NickName(WRONG_NICKNAME1)).isInstanceOf(BusinessException.class)
				.hasMessageContaining(expectedError.getMessage()),
			() -> assertThatThrownBy(() -> new NickName(WRONG_NICKNAME2)).isInstanceOf(BusinessException.class)
				.hasMessageContaining(expectedError.getMessage()),
			() -> assertThatThrownBy(() -> new NickName(WRONG_NICKNAME3)).isInstanceOf(BusinessException.class)
				.hasMessageContaining(expectedError.getMessage())
		);
	}

	@Test
	@DisplayName("[NickName] 적합 닉네임 성공 검증")
	void validNickName() {
		//given
		NickName nickName1 = new NickName(VALID_NICKNAME1);
		NickName nickName2 = new NickName(VALID_NICKNAME2);
		NickName nickName3 = new NickName(VALID_NICKNAME3);

		//when, then
		assertAll(
			() -> assertThat(nickName1.getNickName()).isEqualTo(VALID_NICKNAME1),
			() -> assertThat(nickName2.getNickName()).isEqualTo(VALID_NICKNAME2),
			() -> assertThat(nickName3.getNickName()).isEqualTo(VALID_NICKNAME3)
		);
	}
}
