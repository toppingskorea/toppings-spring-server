package kr.co.toppings.core.domain.restaurant;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Getter
public class RestaurantViews {

	private static final int INITIAL_VIEWS = 0;

	@Column(name = "restaurant_views")
	private long value;

	public RestaurantViews() {
		this.value = INITIAL_VIEWS;
	}

	public void upValue() {
		this.value++;
	}
}
