package com.example.schedulecomment.comment.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;

import com.example.schedulecomment.BaseEntity;
import com.example.schedulecomment.comment.dto.CommentUpdateRequestDto;
import com.example.schedulecomment.schedule.entity.Schedule;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "comment")
@Getter
@Setter
@NoArgsConstructor
public class Comment extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String content;

	@Column(name = "created_at", updatable = false)
	@CreatedDate
	private LocalDateTime createdAt;

	@Column(nullable = false)
	private Long writerId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "schedule_id")
	private Schedule schedule;

	public Comment(Long writerId, String content, Schedule schedule) {

	}

	public void updateComment(CommentUpdateRequestDto commentUpdateRequestDto) {
	}
}
