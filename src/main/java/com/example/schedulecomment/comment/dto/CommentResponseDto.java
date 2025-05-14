package com.example.schedulecomment.comment.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CommentResponseDto {

	private Long id;
	private Long writerId;
	private String content;
	private LocalDateTime createdAt;

}
