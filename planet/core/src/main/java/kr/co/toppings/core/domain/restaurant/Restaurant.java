package kr.co.toppings.core.domain.restaurant;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import kr.co.toppings.core.support.entity.BaseEntity;
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

	@Column(name = "restaurant_latitude")
	private Double latitude;

	@Column(name = "restaurant_longitude")
	private Double longitude;

	@Column(name = "restaurant_code", columnDefinition = "varchar(200)", unique = true)
	private String code;

	@OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<FoodCategory> categories;

	@Column(name = "delete_yn", columnDefinition = "varchar(1) default 'N'")
	private String deleteYn;

	@Column(name = "restaurant_like_count", columnDefinition = "int default 0")
	private Integer likeCount;

	@Column(name = "restaurant_scrap_count", columnDefinition = "int default 0")
	private Integer scrapCount;

	@Column(name = "public_yn", columnDefinition = "varchar(1) default 'P'")
	private String publicYn;

	@Column(name = "reject_cause")
	private String cause;

	@Column(name = "instagram_id")
	private String instagramId;

	@OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<RestaurantAttach> images = new ArrayList<>();

	@Column(name = "restaurant_thumbnail", columnDefinition = "longtext")
	private String thumbnail;
}
