package kr.co.toppings.core.global.error;

import static org.springframework.http.HttpStatus.*;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

	// Common
	INVALID_INPUT_VALUE("C001", "Invalid Input Value", 400),
	INTERNAL_SERVER_ERROR("C002", "Server Error", 500),
	METHOD_NOT_ALLOWED("C003", "지원하지 않은 HTTP Method 입니다.", 405),
	NOT_EXIST_KEY("C004", "존재하지 않는 키 입니다", 404),

	// User
	USER_INVALID_NICKNAME("U001", "닉네임 형식이 맞지 않습니다.", 400),
	USER_DUPLICATED_NICKNAME("U002", "이미 존재하는 닉네임 입니다.", 409),

	// Restaurant
	RESTAURANT_INVALID_NAME("R001", "식당 이름이 올바르지 않습니다.", 400),
	RESTAURANT_INVALID_ADDRESS("R002", "식당 주소가 올바르지 않습니다.", 400),
	RESTAURANT_INVALID_CODE("R003", "식당 코드가 올바르지 않습니다.", 400),
	RESTAURANT_INVALID_CATEGORY("R004", "식당 카테고리가 올바르지 않습니다.", 400),
	RESTAURANT_INVALID_THUMBNAIL("R005", "식당 썸네일이 올바르지 않습니다.", 400),

	;
	private final String code;
	private final String message;
	private final int status;
}
