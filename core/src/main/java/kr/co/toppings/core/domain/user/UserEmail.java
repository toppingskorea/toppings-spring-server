package kr.co.toppings.core.domain.user;

import static lombok.AccessLevel.*;

import java.util.regex.Pattern;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import kr.co.toppings.core.global.error.BusinessException;
import kr.co.toppings.core.global.error.ErrorCode;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@NoArgsConstructor(access = PROTECTED)
@EqualsAndHashCode
@Embeddable
public class UserEmail {
	private static final String EMAIL_PATTERN = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
	private static final Pattern EMAIL_MATCHER = Pattern.compile(EMAIL_PATTERN);

	@Column(name = "user_email", columnDefinition = "varchar(100)", unique = true)
	private String value;

	public UserEmail(String value) {
		validateEmailPattern(value);
		this.value = value;
	}

	//== 편의 메서드 [Pattern Validation Logic]==//
	private void validateEmailPattern(String value) {
		if (isNotValidEmail(value)) {
			log.warn("Invalid User Email = {}", value);
			throw new BusinessException(ErrorCode.USER_INVALID_EMAIL);
		}
	}

	private static boolean isNotValidEmail(String value) {
		return !EMAIL_MATCHER.matcher(value).matches();
	}
}
