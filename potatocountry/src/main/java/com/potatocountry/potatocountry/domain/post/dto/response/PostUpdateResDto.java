package com.potatocountry.potatocountry.domain.post.dto.response;

import com.potatocountry.potatocountry.data.entitiy.type.PostCategory;
import com.potatocountry.potatocountry.data.entitiy.type.PostStatus;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Schema(description = "게시판 수정 응답 DTO")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostUpdateResDto {
	private Long id;

	private PostCategory category;

	private String title;

	private String content;

	private String userNickname;

	private Long imageCollectionId;

	private Long viewCount;

	private Long likeCount;

	private PostStatus status;
}
