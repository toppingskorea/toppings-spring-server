package kr.co.toppings.core.infrastructure.restaurant.persistence;

import kr.co.toppings.core.application.restaurant.persistence.RestaurantRepository;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class BaseRestaurantRepository implements RestaurantRepository {

	private final RestaurantJpaRepository restaurantJpaRepository;
}
