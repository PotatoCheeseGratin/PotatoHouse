package com.potatocountry.potatocountry.domain.comment.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Schema(description = "댓글 생성 응답 DTO")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CommentCreateResDto {
	@Schema(description = "댓글 고유 아이디", example = "1")
	private Long id;

	@Schema(description = "부모 댓글 고유 아이디", example = "2")
	private Long parentId;

	@Schema(description = "유저 고유 아이디", example = "1")
	private Long userId;

	@Schema(description = "게시판 고유 아이디", example = "1")
	private Long postId;

	@Schema(description = "댓글 내용", example = "안녕하세요.")
	private String content;
}
