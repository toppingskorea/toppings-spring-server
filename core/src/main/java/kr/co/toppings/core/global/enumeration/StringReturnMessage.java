package kr.co.toppings.core.global.enumeration;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum StringReturnMessage {

	REGISTRATION_SUCCESS("Registration completed"),
	DELETE_SUCCESS("Delete completed"),

	;

	private final String message;
}
