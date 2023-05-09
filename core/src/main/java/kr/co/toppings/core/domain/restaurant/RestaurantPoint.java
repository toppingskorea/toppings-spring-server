package kr.co.toppings.core.domain.restaurant;

import javax.persistence.Embeddable;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RestaurantPoint {

	private double latitude;

	private double longitude;

	@Builder
	private RestaurantPoint(
		final double latitude,
		final double longitude
	) {
		this.latitude = latitude;
		this.longitude = longitude;
	}
	public static RestaurantPoint of(
		final double latitude,
		final double longitude
	) {
		return RestaurantPoint.builder()
			.latitude(latitude)
			.longitude(longitude)
			.build();
	}
}
