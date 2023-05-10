package kr.co.toppings.core.domain.restaurant;

import static kr.co.toppings.core.global.error.ErrorCode.*;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import kr.co.toppings.core.domain.restaurant.constants.FoodCategory;
import kr.co.toppings.core.global.error.BusinessException;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "t_restaurant_category")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RestaurantCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "restaurant_category_id")
	private Long id;

	@Enumerated(EnumType.STRING)
	@Column(name = "restaurant_category", columnDefinition = "varchar(50)")
	private FoodCategory category;

	@OnDelete(action = OnDeleteAction.CASCADE)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "restaurant_id")
	private Restaurant restaurant;

	@Builder
	private RestaurantCategory(
		final FoodCategory category,
		final Restaurant restaurant
	) {
		validateCategory(category);
		this.category = category;
		this.restaurant = restaurant;
	}

	/* static factory method */
	public static RestaurantCategory of(
		final FoodCategory category,
		final Restaurant restaurant
	) {
		return RestaurantCategory.builder()
			.category(category)
			.restaurant(restaurant)
			.build();
	}

	/* validation */
	private void validateCategory(final FoodCategory category) {
		if (Objects.isNull(category))
			throw new BusinessException(RESTAURANT_INVALID_CATEGORY);
	}
}
