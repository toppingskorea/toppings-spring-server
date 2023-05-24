package kr.co.toppings.core.domain.review;

import static kr.co.toppings.core.global.error.ErrorCode.*;
import static kr.co.toppings.core.global.fixture.ReviewFixture.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;

import kr.co.toppings.core.domain.review.Review;
import kr.co.toppings.core.domain.review.ReviewImage;
import kr.co.toppings.core.global.error.BusinessException;

@DisplayName("[Domain] - ReviewImage Test")
@ActiveProfiles("test")
public class ReviewImageTest {

	private final String validUrl = "https://toppings.co.kr";
	private final String validPath = "toppings/image";

	@Test
	@DisplayName("[ReviewImage] - 리뷰 이미지를 생성합니다.")
	void 리뷰_이미지를_생성합니다() {
	    // given
		Review review = CREATE_SUCCESS.toEntity();

	    // when
		ReviewImage reviewImage = ReviewImage.of(validUrl, validPath, review);

	    // then
		assertAll(
			() -> assertThat(reviewImage.getImageUrl()).isEqualTo(validUrl),
			() -> assertThat(reviewImage.getImagePath()).isEqualTo(validPath)
		);
	}

	@Test
	@DisplayName("[ReviewImage] - 리뷰 이미지에 리뷰 관계가 없다면 생성할 수 없습니다.")
	void 리뷰_이미지에_리뷰_관계가_없다면_등록되지_않습니다() {
		// given & when & then
		assertThatThrownBy(() -> ReviewImage.of(validUrl, validPath, null))
			.isInstanceOf(BusinessException.class)
			.hasMessageContaining(REVIEW_INVALID_VALUE.getMessage());
	}

	@Test
	@DisplayName("[ReviewImage] - 리뷰 이미지에 URL이 올바르지 않으면 생성할 수 없습니다.")
	void 리뷰_이미지에_URL_이_올바르지_않으면_등록되지_않습니다() {
		// given
		Review review = CREATE_SUCCESS.toEntity();

		// when & then
		assertAll(
			() -> assertThatThrownBy(() -> ReviewImage.of(null, validPath, review))
					.isInstanceOf(BusinessException.class)
					.hasMessageContaining(IMAGE_INVALID_URL.getMessage()),
			() -> assertThatThrownBy(() -> ReviewImage.of(" ", validPath, review))
					.isInstanceOf(BusinessException.class)
					.hasMessageContaining(IMAGE_INVALID_URL.getMessage())
		);
	}

	@Test
	@DisplayName("[ReviewImage] - 리뷰 이미지에 이미지 경로가 올바르지 않으면 생성할 수 없습니다.")
	void 리뷰_이미지에_이미지_경로가_올바르지_않으면_등록되지_않습니다() {
		// given
		Review review = CREATE_SUCCESS.toEntity();

		// when & then
		assertAll(
			() -> assertThatThrownBy(() -> ReviewImage.of(validUrl, null, review))
					.isInstanceOf(BusinessException.class)
					.hasMessageContaining(IMAGE_INVALID_PATH.getMessage()),
			() -> assertThatThrownBy(() -> ReviewImage.of(validUrl, " ", review))
					.isInstanceOf(BusinessException.class)
					.hasMessageContaining(IMAGE_INVALID_PATH.getMessage())
		);
	}
}
