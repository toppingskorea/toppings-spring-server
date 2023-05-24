package kr.co.toppings.core.global.fixture;

import kr.co.toppings.core.domain.restaurant.Restaurant;
import kr.co.toppings.core.domain.review.Review;
import kr.co.toppings.core.domain.review.ReviewStar;
import kr.co.toppings.core.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ReviewFixture {

	CREATE_SUCCESS("너무너무 맛있는 음식이 많아요!", 5, UserFixture.CREATE_SUCCESS_0HABIT.toEntity(), RestaurantFixture.CREATE_SUCCESS.toEntity()),
	CREATE_FAIL_BY_NULL_CONTENT(null, 5, UserFixture.CREATE_SUCCESS_0HABIT.toEntity(), RestaurantFixture.CREATE_SUCCESS.toEntity()),
	CREATE_FAIL_BY_EMPTY_CONTENT(" ", 5, UserFixture.CREATE_SUCCESS_0HABIT.toEntity(), RestaurantFixture.CREATE_SUCCESS.toEntity()),
	CREATE_FAIL_BY_USER("너무너무 맛있는 음식이 많아요!", 5, null, RestaurantFixture.CREATE_SUCCESS.toEntity()),
	CREATE_FAIL_BY_RESTAURANT("너무너무 맛있는 음식이 많아요!", 5, UserFixture.CREATE_SUCCESS_0HABIT.toEntity(), null),
	;

	private final String content;

	private final int starValue;

	private final User user;

	private final Restaurant restaurant;

	public Review toEntity() {
		return Review.of(
			restaurant,
			user,
			content,
			starValue
		);
	}
}
