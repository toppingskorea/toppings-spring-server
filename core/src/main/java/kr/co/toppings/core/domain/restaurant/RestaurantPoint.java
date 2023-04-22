package kr.co.toppings.core.domain.restaurant;

import javax.persistence.Embeddable;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RestaurantPoint {

	private Double latitude = 0.0;

	private Double longitude = 0.0;

	public RestaurantPoint(
		Double latitude,
		Double longitude
	) {
		this.latitude = latitude;
		this.longitude = longitude;
	}
}
