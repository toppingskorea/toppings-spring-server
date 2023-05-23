package kr.co.toppings.core.domain.review;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import kr.co.toppings.core.global.error.BusinessException;
import kr.co.toppings.core.global.error.ErrorCode;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReviewStar {

	private static final int MIN_STAR_VALUE = 0;
	private static final int MAX_STAR_VALUE = 5;

	@Column(name = "review_star")
	private int value;

	@Builder
	private ReviewStar(int value) {
		validateStarValue(value);
		this.value = value;
	}

	private void validateStarValue(int value) {
		if (value < MIN_STAR_VALUE || value > MAX_STAR_VALUE)
			throw new BusinessException(ErrorCode.REVIEW_INVALID_STAR_VALUE);
	}

	public static ReviewStar of(int value) {
		return ReviewStar.builder()
			.value(value)
			.build();
	}
}
