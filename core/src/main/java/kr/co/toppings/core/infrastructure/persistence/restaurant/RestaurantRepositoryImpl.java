package kr.co.toppings.core.infrastructure.persistence.restaurant;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class RestaurantRepositoryImpl {

	private final RestaurantJpaRepository restaurantJpaRepository;
}
