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
public class Email {

	private static final String EMAIL_PATTERN = "^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$";
	private static final Pattern EMAIL_MATCHER = Pattern.compile(EMAIL_PATTERN);

	@Column(name = "user_email", columnDefinition = "varchar(100)", unique = true)
	private String value;

	public Email(String value) {
		validateEmailPattern(value);
		this.value = value;
	}

	//== 편의 메서드 [Pattern Validation Logic]==//
	private void validateEmailPattern(String email) {
		if (isNotValidEmailPattern(email)) {
			log.warn("Invalid Email = {}", email);
			throw new BusinessException(USER_INVALID_EMAIL);
		}
	}

	private static boolean isNotValidEmailPattern(String email) {
		return !EMAIL_MATCHER.matcher(email).matches();
	}
}
