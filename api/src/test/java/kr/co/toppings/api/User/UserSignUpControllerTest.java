package kr.co.toppings.api.User;

import static kr.co.toppings.api.global.config.RestDocsConfig.*;
import static kr.co.toppings.core.domain.user.constants.Habit.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.*;
import static org.springframework.http.MediaType.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import kr.co.toppings.api.global.base.ControllerTestSupport;
import kr.co.toppings.core.application.user.dto.request.UserSignUpRequest;
import kr.co.toppings.core.application.user.service.UserSignUpService;
import kr.co.toppings.core.domain.user.constants.Country;

@DisplayName("[Controller] UserSignUp Test")
public class UserSignUpControllerTest extends ControllerTestSupport {

	@MockBean
	protected UserSignUpService userSignUpService;

	private static final String BASE_URL = "/api/user";

	@Test
	@DisplayName("[UserSignUp] 회원가입에 성공한다")
	void 회원가입을_성공한다() throws Exception {
		//given
		UserSignUpRequest request = new UserSignUpRequest(
			"hbeeen",
			"hbyeon@student.42seoul.kr",
			Country.KOREA,
			List.of(VEGAN, VEGETARIAN, NOSUGAR)
		);
		given(userSignUpService.signUpUser(any())).willReturn(1L);

		//when & then
		mockMvc.perform(post(BASE_URL)
			.content(toJson(request))
			.contentType(APPLICATION_JSON)
		)
			.andExpect(status().isCreated())
			.andDo(
				restDocs.document(
					requestFields(
						fieldWithPath("nickName").description("닉네임").attributes(field("constraint", "닉네임 패턴 준수")),
						fieldWithPath("email").description("이메일").attributes(field("constraint", "이메일 패턴 준수")),
						fieldWithPath("country").description("국적").attributes(field("constraint", "단일 값, Not Null")),
						fieldWithPath("habits").optional().description("식습관").attributes(field("constraint", "다중 값, Nullable"))
					)
				)
			);
	}
}
