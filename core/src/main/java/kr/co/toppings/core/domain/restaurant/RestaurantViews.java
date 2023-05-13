package kr.co.toppings.core.domain.restaurant;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RestaurantViews {

	@Column(name = "restaurant_views")
	private long value;

	@Builder
	private RestaurantViews(final long value) {
		this.value = value;
	}

	public static RestaurantViews of(final long value) {
		return RestaurantViews.builder()
			.value(value)
			.build();
	}
}
