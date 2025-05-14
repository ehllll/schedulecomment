package com.example.schedulecomment.comment.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@AllArgsConstructor
public class CommentRequestDto {

	private Long writerId;

	@NotBlank(message = "내용을 입력해주세요.")
	@Size(min = 1, max = 100, message = "내용은 1 글자 이상 100 글자 이하로 입력해주세요.")
	private String content;


}
