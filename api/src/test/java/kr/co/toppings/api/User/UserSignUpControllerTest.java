package kr.co.toppings.api.User;

import static kr.co.toppings.core.domain.user.constants.Habit.*;
import static org.mockito.ArgumentMatchers.*;
import static org.springframework.http.MediaType.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.net.URI;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.http.ResponseEntity;
import org.springframework.restdocs.payload.PayloadDocumentation;
import org.springframework.restdocs.payload.ResponseFieldsSnippet;
import org.springframework.restdocs.snippet.Attributes;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.fasterxml.jackson.core.JsonProcessingException;

import kr.co.toppings.api.global.base.ControllerTestSupport;
import kr.co.toppings.api.global.dto.response.Success;
import kr.co.toppings.core.application.user.dto.request.UserSignUpRequest;
import kr.co.toppings.core.application.user.service.UserSignUpService;
import kr.co.toppings.core.domain.user.constants.Country;
import kr.co.toppings.core.domain.user.constants.Habit;

@DisplayName("[Controller] UserSignUp Test")
public class UserSignUpControllerTest extends ControllerTestSupport {

	private static final String BASE_URL = "/api/user";

	@Test
	@DisplayName("[UserSignUp] 회원가입에 성공한다")
	void 회원가입_성공() throws Exception {
		//given
		UserSignUpRequest request = new UserSignUpRequest("hbeeen", "hbyeon@student.42seoul.kr", Country.JAPAN,
			List.of(HALAL, MUSLIMFRIENDLY, NOSUGAR));
		BDDMockito.<Long>given(userSignUpService.signUpUser(any())).willReturn(1L);

		//when
		MockHttpServletRequestBuilder requestBuilder = buildJoinRequest(request);

		//then
		mockMvc.perform(requestBuilder)
			.andExpect(status().isCreated())
			.andDo(
				restDocs.document(
					requestFields(
						fieldWithPath("nickName").description("닉네임")
							.attributes(constraint("닉네임 패턴 준수")),
						fieldWithPath("email").description("이메일")
							.attributes(constraint("이메일 패턴 준수")),
						fieldWithPath("country").description("국적").attributes(constraint("단일 값, Not Null")),
						fieldWithPath("habits").description("식습관").attributes(constraint("다중 값, Nullable"))
					),
					successResponseDocument()
				)
			);
	}

	private MockHttpServletRequestBuilder buildJoinRequest(UserSignUpRequest request) throws JsonProcessingException {
		return MockMvcRequestBuilders
			.post(BASE_URL)
			.content(toJson(request))
			.contentType(APPLICATION_JSON);
	}

	protected ResponseFieldsSnippet successResponseDocument() {
		return PayloadDocumentation.responseFields(
			fieldWithPath("success").description("성공 여부")
		);
	}

	protected Attributes.Attribute constraint(String value) {
		return new Attributes.Attribute("constraints", value);
	}

	@PostMapping
	public ResponseEntity<Success> createUser(@RequestBody UserSignUpRequest createRequest) {
		Long userId = userSignUpService.signUpUser(createRequest);

		return ResponseEntity
			.created(URI.create("/api/user/" + userId))
			.body(new Success());
	}
}
