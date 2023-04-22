package kr.co.toppings.core.global.entity.embedded;

import javax.persistence.Embeddable;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Image {

	private String url;

	private String path;

	public Image(
		String url,
		String path
	) {
		this.url = url;
		this.path = path;
	}
}
