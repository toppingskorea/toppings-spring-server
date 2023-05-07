package kr.co.toppings.core.global.error;

import static org.springframework.http.HttpStatus.*;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

	// Common
	INVALID_INPUT_VALUE("C001", "Invalid Input Value", HttpStatus.BAD_REQUEST),
	INTERNAL_SERVER_ERROR("C002", "Server Error", HttpStatus.INTERNAL_SERVER_ERROR),
	METHOD_NOT_ALLOWED("C003", "지원하지 않은 HTTP Method 입니다.", HttpStatus.METHOD_NOT_ALLOWED),

	// User
	USER_INVALID_NICKNAME("U001", "닉네임 형식이 맞지 않습니다.", HttpStatus.BAD_REQUEST),
	USER_DUPLICATED_NICKNAME("U002", "이미 존재하는 닉네임 입니다.", HttpStatus.CONFLICT);

	private final String code;
	private final String message;
	private final HttpStatus status;
}
