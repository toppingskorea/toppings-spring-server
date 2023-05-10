package kr.co.toppings.core.restaurant.domain;

import static kr.co.toppings.core.global.error.ErrorCode.*;
import static kr.co.toppings.core.global.fixture.RestaurantFixture.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import kr.co.toppings.core.domain.restaurant.Restaurant;
import kr.co.toppings.core.global.error.BusinessException;
import kr.co.toppings.core.global.error.ErrorCode;
import kr.co.toppings.core.global.fixture.RestaurantFixture;

@DisplayName("[Domain] - Restaurant Test")
public class RestaurantTest {

	@Test
	@DisplayName("[Restaurant] - Create Restaurant Test")
	void 식당을_생성한다() {
		// given
		final Restaurant restaurant = CREATE_SUCCESS.toEntity();

		// when & then
		assertAll(
			() -> assertThat(restaurant.getName()).isEqualTo(CREATE_SUCCESS.getName()),
			() -> assertThat(restaurant.getAddress()).isEqualTo(CREATE_SUCCESS.getAddress()),
			() -> assertThat(restaurant.getCode()).isEqualTo(CREATE_SUCCESS.getCode()),
			() -> assertThat(restaurant.getPoint().getLatitude()).isEqualTo(CREATE_SUCCESS.getLatitude()),
			() -> assertThat(restaurant.getPoint().getLongitude()).isEqualTo(CREATE_SUCCESS.getLongitude())
		);
	}

	@Test
	@DisplayName("[Restaurant] - Invalid Restaurant Name Test")
	void 식당을_생성할때_이름_검증을_실패하면_예외를_던진다() {
		// given & when & then
		assertThatThrownBy(CREATE_FAIL_BY_NAME::toEntity)
			.isInstanceOf(BusinessException.class)
			.hasMessageContaining(RESTAURANT_INVALID_NAME.getMessage());
	}

	@Test
	@DisplayName("[Restaurant] - Invalid Restaurant Address Test")
	void 식당을_생성할때_주소_검증을_실패하면_예외를_던진다() {
		// given & when & then
		assertThatThrownBy(CREATE_FAIL_BY_ADDRESS::toEntity)
			.isInstanceOf(BusinessException.class)
			.hasMessageContaining(RESTAURANT_INVALID_ADDRESS.getMessage());
	}

	@Test
	@DisplayName("[Restaurant] - Invalid Restaurant Code Test")
	void 식당을_생성할때_코드_검증을_실패하면_예외를_던진다() {
		// given & when & then
		assertThatThrownBy(CREATE_FAIL_BY_CODE::toEntity)
			.isInstanceOf(BusinessException.class)
			.hasMessageContaining(RESTAURANT_INVALID_CODE.getMessage());
	}

	@Test
	@DisplayName("[Restaurant] - Update Restaurant Thumbnail Test")
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
	@DisplayName("[Restaurant] - Invalid Restaurant Thumbnail Test")
	void 식당의_썸네일을_업데이트할때_검증을_실패하면_예외를_던진다() {
		// given
		final Restaurant restaurant = CREATE_SUCCESS.toEntity();

		// when & then
		assertThatThrownBy(() -> restaurant.updateThumbnail(null))
			.isInstanceOf(BusinessException.class)
			.hasMessageContaining(RESTAURANT_INVALID_THUMBNAIL.getMessage());
	}
}
