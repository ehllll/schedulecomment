package com.example.schedulecomment.schedule.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;

import com.example.schedulecomment.BaseEntity;
import com.example.schedulecomment.schedule.dto.ScheduleUpdateRequestDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "schedule")
@Getter
@Setter
@NoArgsConstructor
public class Schedule extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long writerId;
	private String title;
	private String content;

	@Column(name = "created_at", updatable = false)
	@CreatedDate
	private LocalDateTime createdAt;


	public Schedule(Long writerId, String title, String content) {
		this.writerId = writerId;
		this.title = title;
		this.content = content;

	}

	public void updateSchedule(ScheduleUpdateRequestDto scheduleUpdateRequestDto) {
		if(scheduleUpdateRequestDto.getTitle() != null) {
			this.title = scheduleUpdateRequestDto.getTitle();
		}
		if(scheduleUpdateRequestDto.getContent() != null) {
			this.content = scheduleUpdateRequestDto.getContent();
		}
	}


}
