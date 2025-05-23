package com.example.schedulecomment.schedule.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@AllArgsConstructor
public class ScheduleRequestDto {

	@NotBlank
	private String title;

	@NotBlank
	private String content;

	private Long writerId;
}
