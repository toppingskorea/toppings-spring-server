package kr.co.toppings.core.global.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

	// Common
	INVALID_INPUT_VALUE("C001", "Invalid Input Value", 400),
	INTERNAL_SERVER_ERROR("C002", "Server Error", 500),
	METHOD_NOT_ALLOWED("C002", "지원하지 않은 HTTP Method 입니다.", 405)
	;

	private final String code;
	private final String message;
	private final int status;
}
