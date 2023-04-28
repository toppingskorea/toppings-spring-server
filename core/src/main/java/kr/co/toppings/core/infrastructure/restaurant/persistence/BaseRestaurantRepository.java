package kr.co.toppings.core.infrastructure.restaurant.persistence;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class BaseRestaurantRepository {

	private final RestaurantJpaRepository restaurantJpaRepository;
}
