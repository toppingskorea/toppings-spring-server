package kr.co.toppings.core.domain.restaurant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import kr.co.toppings.core.domain.restaurant.constants.CategoryContent;
import kr.co.toppings.core.domain.restaurant.constants.CategoryTitle;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class RestaurantCategory {

	@Id
	@Column(name = "food_category_id")
	private String id;

	@Enumerated(EnumType.STRING)
	@Column(name = "food_category_title", columnDefinition = "varchar(50)")
	private CategoryTitle title;

	@Enumerated(EnumType.STRING)
	@Column(name = "food_category_content", columnDefinition = "varchar(50)")
	private CategoryContent content;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "restaurant_id")
	private Restaurant restaurant;
}
