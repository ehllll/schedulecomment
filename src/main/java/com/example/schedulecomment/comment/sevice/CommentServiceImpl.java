package com.example.schedulecomment.comment.sevice;



import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


import com.example.schedulecomment.comment.dto.CommentRequestDto;
import com.example.schedulecomment.comment.dto.CommentResponseDto;
import com.example.schedulecomment.comment.dto.CommentUpdateRequestDto;
import com.example.schedulecomment.comment.entity.Comment;
import com.example.schedulecomment.comment.repository.CommentRepository;
import com.example.schedulecomment.schedule.entity.Schedule;
import com.example.schedulecomment.schedule.repository.ScheduleRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService{

	private final CommentRepository commentRepository;
	private final ScheduleRepository scheduleRepository;

	@Override
	public void createComment(Long scheduleId, CommentRequestDto commentRequestDto) {

		if (commentRequestDto.getContent() == null || commentRequestDto.getContent().isBlank()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "내용은 필수입니다.");
		}

		Schedule schedule = scheduleRepository.findById(scheduleId)
			.orElseThrow(() -> new IllegalArgumentException("스케줄을 찾을 수 없습니다."));

		Comment comment = new Comment(commentRequestDto.getWriterId(), commentRequestDto.getContent(), schedule);
		commentRepository.save(comment);

	}


	@Override
	public List<CommentResponseDto> getAll() {
		List<Comment> commentList = commentRepository.findAll();
		List<CommentResponseDto> responseDtoList = new ArrayList<>();
		for(Comment comment : commentList) {
			CommentResponseDto commentResponseDto = new CommentResponseDto(comment.getId(), comment.getWriterId(), comment.getContent(), comment.getCreatedAt());
			responseDtoList.add(commentResponseDto);
		}
		return responseDtoList;
	}

	@Override
	public CommentResponseDto findById(Long id) {
		Comment comment = commentRepository.findById(id).orElseThrow(
			() -> new RuntimeException("댓글이 존재하지 않습니다")
		);
		return new CommentResponseDto(comment.getId(), comment.getWriterId(), comment.getContent(), comment.getCreatedAt());
	}

	@Override
	public void updateComment(Long scheduleId, Long commentId, CommentUpdateRequestDto commentUpdateRequestDto) {
		Comment comment = commentRepository.findById(commentId)
			.orElseThrow(() -> new IllegalArgumentException("댓글을 찾을 수 없습니다."));

		comment.setContent(commentUpdateRequestDto.getContent());

		commentRepository.save(comment);

	}


	@Override
	public void deleteComment(Long scheduleId, Long commentId, CommentRequestDto commentRequestDto) {
		Comment comment = commentRepository.findById(commentId)
			.orElseThrow(() -> new IllegalArgumentException("댓글을 찾을 수 없습니다."));

		commentRepository.delete(comment);
	}
}
