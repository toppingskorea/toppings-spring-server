package kr.co.toppings.core.domain.notification;


import io.jsonwebtoken.lang.Assert;
import lombok.Builder;

public class Notification {

	private Long id;

	private Long type;

	@Builder.Default private String message = "";

	@Builder(builderMethodName = "typeBuilder")
	public Notification(final Long type) {
		Assert.hasText(type.toString(), "type has text");
		this.type = type;
	}
}
