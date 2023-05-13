package kr.co.toppings.core.restaurant.domain;

import static kr.co.toppings.core.domain.restaurant.constants.FoodCategory.*;
import static kr.co.toppings.core.global.error.ErrorCode.*;
import static kr.co.toppings.core.global.fixture.RestaurantFixture.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;

import kr.co.toppings.core.domain.restaurant.Restaurant;
import kr.co.toppings.core.domain.restaurant.RestaurantCategory;
import kr.co.toppings.core.global.error.BusinessException;

@DisplayName("[Domain] - RestaurantCategory Test")
@ActiveProfiles("test")
class RestaurantCategoryTest {

	@Test
	@DisplayName("[RestaurantCategory] - Create RestaurantCategory Test")
	void 식당의_카테고리를_생성한다() {
		// given
		final Restaurant restaurant = CREATE_SUCCESS.toEntity();
		final RestaurantCategory category = RestaurantCategory.of(KOREAN, restaurant);

		// when & then
		assertAll(
			() -> assertThat(category.getCategory()).isEqualTo(KOREAN),
			() -> assertThat(category.getRestaurant()).isEqualTo(restaurant)
		);
	}

	@Test
	@DisplayName("[RestaurantCategory] - Invalid RestaurantCategory Test")
	void 식당의_카테고리를_생성할때_카테고리가_NULL_이면_예외를_던진다() {
		// given
		final Restaurant restaurant = CREATE_SUCCESS.toEntity();

		// when & then
		assertThatThrownBy(() -> RestaurantCategory.of(null, restaurant))
			.isInstanceOf(BusinessException.class)
			.hasMessageContaining(RESTAURANT_INVALID_CATEGORY.getMessage());
	}
}