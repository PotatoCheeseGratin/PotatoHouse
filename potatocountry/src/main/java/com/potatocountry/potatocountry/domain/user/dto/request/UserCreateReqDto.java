package com.potatocountry.potatocountry.domain.user.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserCreateReqDto {
	@NotBlank
	@Size(max = 30)
	private String loginId;

	@NotBlank
	@Size(max = 30)
	private String password;

	@NotBlank
	@Size(max = 30)
	private String username;

	@NotBlank
	@Size(max = 30)
	private String nickname;
}
