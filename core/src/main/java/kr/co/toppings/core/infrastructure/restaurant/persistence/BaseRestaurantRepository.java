package kr.co.toppings.core.infrastructure.restaurant.persistence;

import kr.co.toppings.core.application.restaurant.persistence.RestaurantRepository;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@Repository
@RequiredArgsConstructor
@Transactional
public class BaseRestaurantRepository implements RestaurantRepository {

	private final RestaurantJpaRepository restaurantJpaRepository;
}
