package kr.co.toppings.core.domain.restaurant;

import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import kr.co.toppings.core.global.entity.BaseEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(callSuper = true)
@DynamicUpdate
@DynamicInsert
@Table(name = "t_restaurant")
public class Restaurant extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "restaurant_id")
	private Long id;

	@Column(name = "restaurant_name", columnDefinition = "varchar(100)")
	private String name;

	@Column(name = "restaurant_address", columnDefinition = "varchar(150)")
	private String address;

	@Column(name = "restaurant_code", columnDefinition = "varchar(200)", unique = true)
	private String code;

	@Column(name = "restaurant_thumbnail", columnDefinition = "text")
	private String thumbnail;

	@Embedded
	@AttributeOverride(name = "latitude", column = @Column(name = "restaurant_latitude"))
	@AttributeOverride(name = "longitude", column = @Column(name = "restaurant_longitude"))
	private RestaurantPoint point;

	@OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<RestaurantCategory> categories;

	@Builder
	private Restaurant(
		String name,
		String address,
		String code,
		RestaurantPoint point
	) {
		this.name = name;
		this.address = address;
		this.code = code;
		this.point = point;
	}

	public static Restaurant of(
		String name,
		String address,
		String code,
		double latitude,
		double longitude
	) {
		return Restaurant.builder()
			.name(name)
			.address(address)
			.code(code)
			.point(RestaurantPoint.of(latitude, longitude))
			.build();
	}
}
