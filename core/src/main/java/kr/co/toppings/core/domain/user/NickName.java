package kr.co.toppings.core.domain.user;

import static kr.co.toppings.core.global.error.ErrorCode.*;
import static lombok.AccessLevel.*;

import java.util.regex.Pattern;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import kr.co.toppings.core.global.error.BusinessException;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@NoArgsConstructor(access = PROTECTED)
@EqualsAndHashCode
@Embeddable
public class NickName {

	private static final String NICKNAME_PATTERN = "^[a-z0-9]{6,20}$";
	private static final Pattern NICKNAME_MATCHER = Pattern.compile(NICKNAME_PATTERN);

	@Column(name = "user_nickname", unique = true)
	private String value;

	public NickName(String value) {

		validateNicknamePattern(value);
		this.value = value;
	}

	//== 편의 메서드 [Pattern Validation Logic]==//
	private void validateNicknamePattern(String nickName) {
		if (isNotValidNickNamePattern(nickName)) {
			log.warn("Invalid User name = {}", nickName);
			throw new BusinessException(USER_INVALID_NICKNAME);
		}
	}

	private static boolean isNotValidNickNamePattern(String nickName) {
		return !NICKNAME_MATCHER.matcher(nickName).matches();
	}
}
