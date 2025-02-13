package com.potatocountry.potatocountry.domain.auth.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Schema(description = "회원가입 요청 DTO")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class JoinReqDto {

	@Schema(description = "로그인 아이디", example = "user")
	@NotBlank
	@Size(max = 30)
	private String loginId;

	@Schema(description = "로그인 비밀번호", example = "1234")
	@NotBlank
	@Size(max = 30)
	private String password;

	@Schema(description = "유저의 이름", example = "감자")
	@NotBlank
	@Size(max = 30)
	private String username;

	@Schema(description = "닉네임", example = "배고픈감자")
	@NotBlank
	@Size(max = 30)
	private String nickname;
}
