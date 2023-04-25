package kr.co.toppings.core.domain.restaurant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import kr.co.toppings.core.domain.restaurant.constants.FoodCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "t_restaurant_category")
public class RestaurantCategory {

	@Id
	@Column(name = "restaurant_category_id")
	private String id;

	@Enumerated(EnumType.STRING)
	@Column(name = "restaurant_category", columnDefinition = "varchar(50)")
	private FoodCategory category;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "restaurant_id")
	private Restaurant restaurant;
}
