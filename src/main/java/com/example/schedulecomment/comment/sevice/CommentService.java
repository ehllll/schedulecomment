package com.example.schedulecomment.comment.sevice;

import java.util.List;

import com.example.schedulecomment.comment.dto.CommentRequestDto;
import com.example.schedulecomment.comment.dto.CommentResponseDto;
import com.example.schedulecomment.comment.dto.CommentUpdateRequestDto;
import com.example.schedulecomment.schedule.dto.ScheduleResponseDto;

public interface CommentService {
	void createComment(Long scheduleId, CommentRequestDto commentRequestDto);

	List<CommentResponseDto> getAll();

	CommentResponseDto findById(Long id);

	void updateComment(Long scheduleId, Long commentId, CommentUpdateRequestDto commentUpdateRequestDto);

	void deleteComment(Long scheduleId, Long commentId, CommentRequestDto commentRequestDto);
}
