package kr.co.toppings.core.application.restaurant.dto.request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RestaurantRegisterRequest {

	private String name;
	private String address;
	private String code;

	private double latitude;
	private double longitude;
}
