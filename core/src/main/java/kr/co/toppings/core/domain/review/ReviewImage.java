package kr.co.toppings.core.domain.review;

import java.util.Objects;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embedded;
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

import kr.co.toppings.core.domain.common.embedded.Image;
import kr.co.toppings.core.global.error.BusinessException;
import kr.co.toppings.core.global.error.ErrorCode;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DynamicUpdate
@DynamicInsert
@Table(name = "t_review_image")
public class ReviewImage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "review_image_id")
	private Long id;

	@Embedded
	@AttributeOverride(name = "url", column = @Column(name = "review_image", columnDefinition = "longtext"))
	@AttributeOverride(name = "path", column = @Column(name = "review_image_path", columnDefinition = "varchar(200)"))
	private Image image;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "review_id")
	private Review review;

	@Builder
	private ReviewImage(
		final Image image,
		final Review review
	) {
		validateReview(review);
		this.image = image;
		this.review = review;
	}

	/* static factory method */
	public static ReviewImage of(
		final String url,
		final String path,
		final Review review
	) {
		return ReviewImage.builder()
			.image(Image.of(url, path))
			.review(review)
			.build();
	}

	/* validation */
	private void validateReview(final Review review) {
		if (Objects.isNull(review))
			throw new BusinessException(ErrorCode.REVIEW_INVALID_VALUE);
	}

	/* business */
	public String getImageUrl() {
		return this.image.getUrl();
	}

	public String getImagePath() {
		return this.image.getPath();
	}
}
