package kr.co.toppings.core.domain.auth;

import javax.persistence.Id;

import org.springframework.data.redis.core.RedisHash;

@RedisHash(value = "refreshToken", timeToLive = 60)
public class RefreshToken {

	@Id
	private String refreshToken;
	
}
