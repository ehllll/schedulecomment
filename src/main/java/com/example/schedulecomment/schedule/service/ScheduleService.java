package com.example.schedulecomment.schedule.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.example.schedulecomment.schedule.dto.ScheduleRequestDto;
import com.example.schedulecomment.schedule.dto.ScheduleResponseDto;
import com.example.schedulecomment.schedule.dto.ScheduleUpdateRequestDto;

public interface ScheduleService {

	ScheduleResponseDto createSchedule(ScheduleRequestDto scheduleRequestDto);

	ScheduleResponseDto findById(Long id);

	List<ScheduleResponseDto> getAll();

	@Transactional
	void updateSchedule(Long id, ScheduleUpdateRequestDto scheduleUpdateRequestDto);


	void deleteSchedule(Long id);
}
