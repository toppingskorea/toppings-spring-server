package kr.co.toppings.core.global.error;

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
	USER_INVALID_EMAIL("U003", "이메일 형식이 맞지 않습니다.", 400),
	USER_DUPLICATED_EMAIL("U004", "이미 가입된 이메일 입니다.", 409),

	// Restaurant
	RESTAURANT_INVALID_NAME("R001", "식당 이름이 올바르지 않습니다.", 400),
	RESTAURANT_INVALID_ADDRESS("R002", "식당 주소가 올바르지 않습니다.", 400),
	RESTAURANT_INVALID_CODE("R003", "식당 코드가 올바르지 않습니다.", 400),
	RESTAURANT_INVALID_CATEGORY("R004", "식당 카테고리가 올바르지 않습니다.", 400),
	RESTAURANT_INVALID_THUMBNAIL("R005", "식당 썸네일이 올바르지 않습니다.", 400),

	// Image
	IMAGE_INVALID_URL("IMG001", "이미지 URL이 올바르지 않습니다.", 400),
	IMAGE_INVALID_PATH("IMG002", "이미지 경로가 올바르지 않습니다.", 400),

	// Review
	REVIEW_INVALID_VALUE("REV001", "리뷰 정보가 올바르지 않습니다.", 400),
	REVIEW_INVALID_RESTAURANT("REV002", "리뷰 식당 정보가 올바르지 않습니다.", 400),
	REVIEW_INVALID_USER("REV003", "리뷰 유저 정보가 올바르지 않습니다.", 400),
	REVIEW_INVALID_CONTENT("REV004", "리뷰 내용이 올바르지 않습니다.", 400),
	REVIEW_INVALID_IMAGE("REV005", "리뷰 이미지가 올바르지 않습니다.", 400),

	;
	private final String code;
	private final String message;
	private final int status;
}
