package com.potatocountry.potatocountry.domain.user.dto.response;

import com.potatocountry.potatocountry.data.entitiy.User;

import lombok.Builder;

public class UserCreateResDto {
	private Long id;

	private String loginId;

	private String nickname;

	@Builder
	private UserCreateResDto(Long id, String loginId, String nickname) {
		this.id = id;
		this.loginId = loginId;
		this.nickname = nickname;
	}

	public static UserCreateResDto toDto(User user) {
		return builder()
			.id(user.getId())
			.loginId(user.getLoginId())
			.nickname(user.getNickname())
			.build();
	}
}
