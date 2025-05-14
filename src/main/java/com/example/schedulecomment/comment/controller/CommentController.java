package com.example.schedulecomment.comment.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.schedulecomment.comment.dto.CommentRequestDto;
import com.example.schedulecomment.comment.dto.CommentResponseDto;
import com.example.schedulecomment.comment.dto.CommentUpdateRequestDto;
import com.example.schedulecomment.comment.sevice.CommentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CommentController {

	private final CommentService commentService;

	@PostMapping("/schedules/{scheduleId}/comment")
	public ResponseEntity<String> createComment(@PathVariable Long scheduleId, @RequestBody CommentRequestDto commentRequestDto) {
		commentService.createComment(scheduleId, commentRequestDto);
		return ResponseEntity.ok("댓글 작성 완료");
	}

	@GetMapping("/schedules/{scheduleId}/comment")
	public ResponseEntity<List<CommentResponseDto>> getAll() {
		return ResponseEntity.ok(commentService.getAll());
	}

	@GetMapping("/schedules/{scheduleId}/comment/{commentId}")
	public ResponseEntity<CommentResponseDto> findById(@PathVariable Long scheduleId, @PathVariable Long commentId) {
		CommentResponseDto responseDto = commentService.findById(commentId);
		return ResponseEntity.ok(responseDto);
	}


	@PutMapping("/schedules/{scheduleId}/comments/{commentId}")
	public ResponseEntity<String> updateComment(@PathVariable Long scheduleId, @PathVariable Long commentId, @RequestBody CommentUpdateRequestDto commentUpdateRequestDto) {
		commentService.updateComment(scheduleId, commentId, commentUpdateRequestDto);
		return ResponseEntity.ok("댓글 수정 완료");
	}

	@DeleteMapping("/schedules/{scheduleId}/comments/{commentId}")
	public ResponseEntity<String> deleteComment(@PathVariable Long scheduleId, @PathVariable Long commentId, @RequestBody CommentRequestDto commentRequestDto) {
		commentService.deleteComment(scheduleId,commentId,commentRequestDto);
		return ResponseEntity.ok("댓글 삭제 완료");
	}
}
