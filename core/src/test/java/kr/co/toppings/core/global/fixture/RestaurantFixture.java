package kr.co.toppings.core.global.fixture;

import kr.co.toppings.core.domain.restaurant.Restaurant;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RestaurantFixture {

	CREATE_SUCCESS("너무 맛있는 집", "서울 강남구 어딘가", "2937109827", 0.0, 0.0),
	CREATE_FAIL_BY_NAME(null, "서울 강남구 이름 없는 집", "2487988789", 0.0, 0.0),
	CREATE_FAIL_BY_ADDRESS("맛있는데 주소 없는 집", null, "7854352167", 0.0, 0.0),
	CREATE_FAIL_BY_CODE("너무 맛 없는 집", "서울 강남구 어딘가", null, 0.0, 0.0),
	;

	private final String name;

	private final String address;

	private final String code;

	private final double latitude;

	private final double longitude;

	public Restaurant toEntity() {
		return Restaurant.of(
			name,
			address,
			code,
			latitude,
			longitude
		);
	}
}
