package com.example.schedulecomment.schedule.dto;


import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@AllArgsConstructor
public class ScheduleResponseDto {
	private Long id;
	private Long scheduleId;
	private String title;
	private String content;
	private LocalDateTime createdAt;


}
