package kr.co.toppings.core.domain.restaurant;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantPoint {

	private Double latitude;

	private Double longitude;
}
