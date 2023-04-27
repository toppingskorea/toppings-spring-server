package kr.co.toppings.api.presentation.auth;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import kr.co.toppings.core.domain.user.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
public class AuthController {

    // 인증토큰 -> 사용자 인가
    @GetMapping("/auth/kakao/callback")
    public String kakaoLogInCallBack(String code) throws JsonProcessingException {

        // Post 방식으로 key=value 데이터 요청 (to Kakao)
        RestTemplate rt = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", "authorization_code");
        params.add("client_id", "aa16853c76ace046dd466333bfd4ec18");
        params.add("redirect_uri", "http://localhost:28080/auth/kakao/callback");
        params.add("code", code);

        HttpEntity<MultiValueMap<String, String>> kakaoTokenRequest = new HttpEntity<>(params, headers);

        ResponseEntity<String> response = rt.exchange(
                "https://kauth.kakao.com/oauth/token",
                HttpMethod.POST,
                kakaoTokenRequest,
                String.class
        );

        String responseString = response.getBody();
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(responseString);

        String idToken = jsonNode.get("id_token")
                                 .asText();
        String accessToken = jsonNode.get("access_token")
                                     .asText();
        String refreshToken = jsonNode.get("refresh_token")
                                      .asText();

        System.out.println("idToken = " + idToken);
        System.out.println("accessToken = " + accessToken);
        System.out.println("refreshToken = " + refreshToken);

        return "redirect:/";
    }


}
