package kr.co.toppings.core.domain.restaurant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@DynamicUpdate
@DynamicInsert
@Table(name = "t_restaurant_attach")
public class RestaurantImage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "restaurant_attach_id")
	private Long id;

	@Column(name = "restaurant_image", columnDefinition = "longtext")
	private String image;

	@Column(name = "restaurant_image_path", columnDefinition = "varchar(200)")
	private String path;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "restaurant_id")
	private Restaurant restaurant;

}
