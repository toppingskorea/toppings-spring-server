package kr.co.toppings.core.domain.common.embedded;

import static org.springframework.util.StringUtils.*;

import javax.persistence.Embeddable;

import kr.co.toppings.core.global.error.BusinessException;
import kr.co.toppings.core.global.error.ErrorCode;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Image {

	private String url;

	private String path;

	@Builder
	private Image(
		final String url,
		final String path
	) {
		validateUrl(url);
		validatePath(path);
		this.url = url;
		this.path = path;
	}

	/* static factory method */
	public static Image of(
		final String url,
		final String path
	) {
		return Image.builder()
			.url(url)
			.path(path)
			.build();
	}

	/* validation */
	public void validateUrl(final String url) {
		if (!hasText(url))
			throw new BusinessException(ErrorCode.IMAGE_INVALID_URL);
	}

	public void validatePath(final String path) {
		if (!hasText(path))
			throw new BusinessException(ErrorCode.IMAGE_INVALID_PATH);
	}
}
