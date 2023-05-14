package kr.co.toppings.core.domain.restaurant;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.*;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RestaurantPoint {

	@Column(name = "restaurant_latitude")
	private double latitude;

	@Column(name = "restaurant_longitude")
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
