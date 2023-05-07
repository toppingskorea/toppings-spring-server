package kr.co.toppings.core.application.restaurant.service;

import kr.co.toppings.core.application.restaurant.persistence.RestaurantQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RestaurantFindService {

    private final RestaurantQueryRepository restaurantQueryRepository;
}
