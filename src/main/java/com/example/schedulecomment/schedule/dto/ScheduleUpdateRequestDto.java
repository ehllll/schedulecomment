package com.example.schedulecomment.schedule.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleUpdateRequestDto {

	private String title;
	private String content;
}