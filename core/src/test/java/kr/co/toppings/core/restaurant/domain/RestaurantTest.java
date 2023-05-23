package kr.co.toppings.core.restaurant.domain;

import kr.co.toppings.core.domain.restaurant.Restaurant;
import kr.co.toppings.core.global.error.BusinessException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;

import static kr.co.toppings.core.global.error.ErrorCode.*;
import static kr.co.toppings.core.global.fixture.RestaurantFixture.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayName("[Domain] - Restaurant Test")
@ActiveProfiles("test")
public class RestaurantTest {

	@Test
	@DisplayName("[Restaurant] - 식당을 생성한다")
	void 식당을_생성한다() {
		// given
		final Restaurant restaurant = CREATE_SUCCESS.toEntity();

		// when & then
		assertAll(
			() -> assertThat(restaurant.getName()).isEqualTo(CREATE_SUCCESS.getName()),
			() -> assertThat(restaurant.getAddress()).isEqualTo(CREATE_SUCCESS.getAddress()),
			() -> assertThat(restaurant.getCode()).isEqualTo(CREATE_SUCCESS.getCode()),
			() -> assertThat(restaurant.getPoint().getLatitude()).isEqualTo(CREATE_SUCCESS.getLatitude()),
			() -> assertThat(restaurant.getPoint().getLongitude()).isEqualTo(CREATE_SUCCESS.getLongitude()),
			() -> assertThat(restaurant.getViews().getValue()).isEqualTo(0)
		);
	}

	@Test
	@DisplayName("[Restaurant] - 식당을 생성할때 이름 검증을 실패하면 예외를 던진다")
	void 식당을_생성할때_이름_검증을_실패하면_예외를_던진다() {
		// given & when & then
		assertThatThrownBy(CREATE_FAIL_BY_NAME::toEntity)
			.isInstanceOf(BusinessException.class)
			.hasMessageContaining(RESTAURANT_INVALID_NAME.getMessage());
	}

	@Test
	@DisplayName("[Restaurant] - 식당을 생성할때 주소 검증을 실패하면 예외를 던진다")
	void 식당을_생성할때_주소_검증을_실패하면_예외를_던진다() {
		// given & when & then
		assertThatThrownBy(CREATE_FAIL_BY_ADDRESS::toEntity)
			.isInstanceOf(BusinessException.class)
			.hasMessageContaining(RESTAURANT_INVALID_ADDRESS.getMessage());
	}

	@Test
	@DisplayName("[Restaurant] - 식당을 생성할때 코드 검증을 실패하면 예외를 던진다")
	void 식당을_생성할때_코드_검증을_실패하면_예외를_던진다() {
		// given & when & then
		assertThatThrownBy(CREATE_FAIL_BY_CODE::toEntity)
			.isInstanceOf(BusinessException.class)
			.hasMessageContaining(RESTAURANT_INVALID_CODE.getMessage());
	}

	@Test
	@DisplayName("[Restaurant] - 식당의 썸네일을 업데이트 한다")
	void 식당의_썸네일을_업데이트_한다() {
		// given
		final String validThumbnail = "Some Thumbnail Url";
		final Restaurant restaurant = CREATE_SUCCESS.toEntity();

		// when
		restaurant.updateThumbnail(validThumbnail);

		// then
		assertThat(restaurant.getThumbnail()).isEqualTo(validThumbnail);
	}

	@Test
	@DisplayName("[Restaurant] - 식당의 썸네일을 업데이트 할 때 검증을 실패하면 예외를 던진다")
	void 식당의_썸네일을_업데이트할때_검증을_실패하면_예외를_던진다() {
		// given
		final Restaurant restaurant = CREATE_SUCCESS.toEntity();

		// when & then
		assertThatThrownBy(() -> restaurant.updateThumbnail(null))
			.isInstanceOf(BusinessException.class)
			.hasMessageContaining(RESTAURANT_INVALID_THUMBNAIL.getMessage());
	}

	@Test
	@DisplayName("[Restaurant] - 식당의 조회수를 증가시킨다")
	void 식당의_조회수를_증가시킨다() {
		// given
		final Restaurant restaurant = CREATE_SUCCESS.toEntity();

		// when
		restaurant.upViews();

		// then
		assertThat(restaurant.getViews().getValue()).isEqualTo(1);
	}
}
