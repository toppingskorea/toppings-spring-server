package kr.co.toppings.core.domain.review;

import static kr.co.toppings.core.global.error.ErrorCode.*;
import static kr.co.toppings.core.global.fixture.ReviewFixture.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;

import kr.co.toppings.core.domain.review.Review;
import kr.co.toppings.core.domain.review.ReviewStar;
import kr.co.toppings.core.global.error.BusinessException;
import kr.co.toppings.core.global.error.ErrorCode;
import kr.co.toppings.core.global.fixture.ReviewFixture;

@DisplayName("[Domain] - Review Test")
@ActiveProfiles("test")
public class ReviewTest {

	@Test
	@DisplayName("[Review] - 리뷰를 생성합니다.")
	void 리뷰를_생성합니다() {
	    // given & when
		Review review = CREATE_SUCCESS.toEntity();

	    // then
		assertAll(
			() -> assertThat(review.getContent()).isEqualTo(CREATE_SUCCESS.getContent()),
			() -> assertThat(review.getUser()).isNotNull(),
			() -> assertThat(review.getRestaurant()).isNotNull(),
			() -> assertThat(review.getStar().getValue()).isEqualTo(CREATE_SUCCESS.getStarValue()),
			() -> assertThat(review.getImages()).hasSize(0)
		);
	}

	@Test
	@DisplayName("[Review] - 리뷰 내용이 비어있으면 리뷰를 생성할 수 없습니다.")
	void test() {
	    // given & when & then
		assertAll(
			() -> assertThatThrownBy(CREATE_FAIL_BY_NULL_CONTENT::toEntity)
					.isInstanceOf(BusinessException.class)
					.hasMessage(REVIEW_INVALID_CONTENT.getMessage()),
			() -> assertThatThrownBy(CREATE_FAIL_BY_EMPTY_CONTENT::toEntity)
					.isInstanceOf(BusinessException.class)
					.hasMessage(REVIEW_INVALID_CONTENT.getMessage())
		);
	}

	@Test
	@DisplayName("[Review] - 리뷰 유저 정보가 비어있으면 리뷰를 생성할 수 없습니다.")
	void test2() {
		// given & when & then
		assertThatThrownBy(CREATE_FAIL_BY_USER::toEntity)
			.isInstanceOf(BusinessException.class)
			.hasMessage(REVIEW_INVALID_USER.getMessage());
	}

	@Test
	@DisplayName("[Review] - 리뷰 식당 정보가 비어있으면 리뷰를 생성할 수 없습니다.")
	void test3() {
		// given & when & then
		assertThatThrownBy(CREATE_FAIL_BY_RESTAURANT::toEntity)
			.isInstanceOf(BusinessException.class)
			.hasMessage(REVIEW_INVALID_RESTAURANT.getMessage());
	}
}
