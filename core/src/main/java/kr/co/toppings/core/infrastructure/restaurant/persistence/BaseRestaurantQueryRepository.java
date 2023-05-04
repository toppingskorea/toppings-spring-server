package kr.co.toppings.core.infrastructure.restaurant.persistence;

import com.querydsl.jpa.impl.JPAQueryFactory;
import kr.co.toppings.core.application.restaurant.persistence.RestaurantQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BaseRestaurantQueryRepository implements RestaurantQueryRepository {

	private final JPAQueryFactory queryFactory;
}
