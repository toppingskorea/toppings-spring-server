package kr.co.toppings.core.restaurant.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;

import kr.co.toppings.core.domain.restaurant.RestaurantPoint;

@DisplayName("[Domain] - RestaurantPoint Test")
@ActiveProfiles("test")
class RestaurantPointTest {

	private static final double VALID_LATITUDE = 10.0;
	private static final double VALID_LONGITUDE = 10.0;

	@Test
	@DisplayName("[RestaurantPoint] - Create RestaurantPoint Test")
	void 식당의_좌표를_생성한다() {
		// given
		final RestaurantPoint point = RestaurantPoint.of(VALID_LATITUDE, VALID_LONGITUDE);

		// when & then
		assertAll(
			() -> assertThat(point.getLatitude()).isEqualTo(VALID_LATITUDE),
			() -> assertThat(point.getLongitude()).isEqualTo(VALID_LONGITUDE)
		);
	}
}