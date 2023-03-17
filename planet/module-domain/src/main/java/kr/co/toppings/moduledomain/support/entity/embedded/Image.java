package kr.co.toppings.moduledomain.support.entity.embedded;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Image {

	private String url;

	private String path;
}
