package kr.co.toppings.core.application.restaurant.service;

import kr.co.toppings.core.application.restaurant.dto.request.RestaurantRegisterRequest;
import kr.co.toppings.core.application.restaurant.persistence.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RestaurantRegisterService {

    private final RestaurantRepository restaurantRepository;

    /**
     * 음식점 등록하기
     */
    @Transactional
    public void register(RestaurantRegisterRequest request) {

    }
}
