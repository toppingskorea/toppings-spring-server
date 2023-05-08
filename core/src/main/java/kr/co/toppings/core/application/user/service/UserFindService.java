package kr.co.toppings.core.application.user.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.toppings.core.infrastructure.user.persistence.UserQueryRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserFindService {

	private final UserQueryRepository userQueryRepository;
}
