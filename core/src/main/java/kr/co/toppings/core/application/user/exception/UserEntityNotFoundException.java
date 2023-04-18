package kr.co.toppings.core.application.user.exception;

import kr.co.toppings.core.global.error.BusinessException;
import kr.co.toppings.core.global.error.ErrorCode;

public class UserEntityNotFoundException extends BusinessException {

	public UserEntityNotFoundException(ErrorCode errorCode) {
		super(errorCode);
	}
}
