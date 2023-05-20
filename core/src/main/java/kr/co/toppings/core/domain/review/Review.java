package kr.co.toppings.core.domain.review;

import static org.springframework.util.StringUtils.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import kr.co.toppings.core.domain.common.entity.BaseAggregateRoot;
import kr.co.toppings.core.domain.restaurant.Restaurant;
import kr.co.toppings.core.domain.user.User;
import kr.co.toppings.core.global.error.BusinessException;
import kr.co.toppings.core.global.error.ErrorCode;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DynamicUpdate
@DynamicInsert
@Table(name = "t_review")
public class Review extends BaseAggregateRoot {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "review_id")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "restaurant_id")
	private Restaurant restaurant;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;

	@Column(name = "review_content", columnDefinition = "text")
	private String content;

	@OneToMany(mappedBy = "review", cascade = CascadeType.REMOVE, orphanRemoval = true)
	private List<ReviewImage> images = new ArrayList<>();

	@Builder
	private Review(
		final Restaurant restaurant,
		final User user,
		final String content
	) {
		validateRestaurant(restaurant);
		validateUser(user);
		validateContent(content);
		this.restaurant = restaurant;
		this.user = user;
		this.content = content;
	}

	/* static factory method */
	public static Review of(
		final Restaurant restaurant,
		final User user,
		final String content
	) {
		return Review.builder()
			.restaurant(restaurant)
			.user(user)
			.content(content)
			.build();
	}

	/* validation */
	public void validateRestaurant(final Restaurant restaurant) {
		if (Objects.isNull(restaurant))
			throw new BusinessException(ErrorCode.REVIEW_INVALID_RESTAURANT);
	}

	public void validateUser(final User user) {
		if (Objects.isNull(user))
			throw new BusinessException(ErrorCode.REVIEW_INVALID_USER);
	}

	public void validateContent(final String content) {
		if (!hasText(content))
			throw new BusinessException(ErrorCode.REVIEW_INVALID_CONTENT);
	}

	public void validateReviewImage(final ReviewImage image) {
		if (Objects.isNull(image))
			throw new BusinessException(ErrorCode.REVIEW_INVALID_IMAGE);
	}

	/* business */
	public void addImage(final ReviewImage image) {
		validateReviewImage(image);
		this.images.add(image);
		// TODO: add image event
	}
}
