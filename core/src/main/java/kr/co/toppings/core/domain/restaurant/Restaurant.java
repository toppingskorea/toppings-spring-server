package kr.co.toppings.core.domain.restaurant;

import static kr.co.toppings.core.global.error.ErrorCode.*;
import static org.springframework.util.StringUtils.*;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import kr.co.toppings.core.global.entity.BaseEntity;
import kr.co.toppings.core.global.error.BusinessException;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
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

	@Builder
	private Restaurant(
		final String name,
		final String address,
		final String code,
		final RestaurantPoint point
	) {
		validateName(name);
		validateAddress(address);
		validateCode(code);
		this.name = name;
		this.address = address;
		this.code = code;
		this.point = point;
	}

	/* static factory method */
	public static Restaurant of(
		final String name,
		final String address,
		final String code,
		final double latitude,
		final double longitude
	) {
		return Restaurant.builder()
			.name(name)
			.address(address)
			.code(code)
			.point(RestaurantPoint.of(latitude, longitude))
			.build();
	}

	/* validation */
	private void validateCode(final String code) {
		if (!hasText(code))
			throw new BusinessException(RESTAURANT_INVALID_CODE);
	}

	private void validateAddress(final String address) {
		if (!hasText(address))
			throw new BusinessException(RESTAURANT_INVALID_ADDRESS);
	}

	private void validateName(final String name) {
		if (!hasText(name))
			throw new BusinessException(RESTAURANT_INVALID_NAME);
	}

	private void validateThumbnail(final String thumbnail) {
		if (!hasText(thumbnail))
			throw new BusinessException(RESTAURANT_INVALID_THUMBNAIL);
	}

	/* business */
	public void updateThumbnail(final String thumbnail) {
		validateThumbnail(thumbnail);
		this.thumbnail = thumbnail;
	}
}
