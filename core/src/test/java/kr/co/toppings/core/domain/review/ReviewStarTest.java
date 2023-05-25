package kr.co.toppings.core.domain.review;

import static kr.co.toppings.core.global.error.ErrorCode.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;

import kr.co.toppings.core.domain.review.ReviewStar;
import kr.co.toppings.core.global.error.BusinessException;
import kr.co.toppings.core.global.error.ErrorCode;

@DisplayName("[Domain] - ReviewStar Test")
@ActiveProfiles("test")
public class ReviewStarTest {

	@Test
	@DisplayName("[ReviewStar] - 1점짜리 리뷰 별점을 생성합니다.")
	void 리뷰_별점을_생성합니다() {
	    // given
		int validValue = 1;

		// when
		ReviewStar star = ReviewStar.of(validValue);

	    // then
		assertThat(star.getValue()).isEqualTo(validValue);
	}

	@Test
	@DisplayName("[ReviewStar] - 음수 별점은 생성할 수 없습니다.")
	void 음수_별점은_생성할_수_없습니다() {
		// given
		int invalidStarValue = -1;

		// when & then
		assertThatThrownBy(() -> ReviewStar.of(invalidStarValue))
			.isInstanceOf(BusinessException.class)
			.hasMessage(REVIEW_INVALID_STAR_VALUE.getMessage());
	}

	@Test
	@DisplayName("[ReviewStar] - 5점을 넘어선 별점은 생성할 수 없습니다.")
	void 최대_별점_수를_초과하여_생성할_수_없습니다() {
		// given
		int invalidStarValue = 6;

		// when & then
		assertThatThrownBy(() -> ReviewStar.of(invalidStarValue))
			.isInstanceOf(BusinessException.class)
			.hasMessage(REVIEW_INVALID_STAR_VALUE.getMessage());
	}
}
