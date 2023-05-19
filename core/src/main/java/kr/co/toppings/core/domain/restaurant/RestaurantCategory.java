package kr.co.toppings.core.domain.restaurant;

import kr.co.toppings.core.domain.restaurant.constants.FoodCategory;
import kr.co.toppings.core.global.entity.BaseAggregateRoot;
import kr.co.toppings.core.global.error.BusinessException;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Objects;

import static kr.co.toppings.core.global.error.ErrorCode.RESTAURANT_INVALID_CATEGORY;

@Entity
@Getter
@Table(name = "t_restaurant_category")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RestaurantCategory extends BaseAggregateRoot {

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
