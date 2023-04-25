package kr.co.toppings.core.infrastructure.restaurant.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.co.toppings.core.domain.restaurant.Restaurant;

public interface RestaurantJpaRepository extends JpaRepository<Restaurant, Long> {
}
