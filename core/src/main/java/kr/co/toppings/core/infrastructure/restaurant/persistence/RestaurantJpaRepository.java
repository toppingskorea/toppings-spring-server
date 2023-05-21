package kr.co.toppings.core.infrastructure.restaurant.persistence;

import kr.co.toppings.core.domain.restaurant.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantJpaRepository extends JpaRepository<Restaurant, Long> {
}
