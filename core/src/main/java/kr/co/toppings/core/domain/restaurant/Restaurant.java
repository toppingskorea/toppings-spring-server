package kr.co.toppings.core.domain.restaurant;

import java.util.ArrayList;
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
import kr.co.toppings.core.global.entity.embedded.Image;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
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

	@Column(name = "restaurant_description", columnDefinition = "text")
	private String description;

	@Column(name = "restaurant_address", columnDefinition = "varchar(150)")
	private String address;

	@Embedded
	@AttributeOverride(name = "latitude", column = @Column(name = "restaurant_latitude"))
	@AttributeOverride(name = "longitude", column = @Column(name = "restaurant_longitude"))
	private RestaurantPoint point;

	@Column(name = "restaurant_code", columnDefinition = "varchar(200)", unique = true)
	private String code;

	@OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<RestaurantCategory> categories;

	@Column(name = "delete_yn", columnDefinition = "varchar(1) default 'N'")
	private String deleteYn;

	@OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<RestaurantImage> images = new ArrayList<>();
}
