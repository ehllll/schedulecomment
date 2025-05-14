package com.example.schedulecomment.schedule.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.schedulecomment.schedule.dto.ScheduleRequestDto;
import com.example.schedulecomment.schedule.dto.ScheduleResponseDto;
import com.example.schedulecomment.schedule.dto.ScheduleUpdateRequestDto;
import com.example.schedulecomment.schedule.service.ScheduleService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ScheduleController {

	private final ScheduleService scheduleService;

	@PostMapping("/schedules")
	public ResponseEntity<ScheduleResponseDto> createSchedule(@RequestBody @Valid ScheduleRequestDto scheduleRequestDto) {
		ScheduleResponseDto scheduleResponseDto = scheduleService.createSchedule(scheduleRequestDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(scheduleResponseDto);
	}

	@GetMapping("/schedules/{scheduleId}")
	public ResponseEntity<ScheduleResponseDto> findById(@PathVariable Long scheduleId) {
		ScheduleResponseDto responseDto = scheduleService.findById(scheduleId);
		return new ResponseEntity<>(responseDto,HttpStatus.OK);
	}

	@GetMapping("/schedules")
	public ResponseEntity<List<ScheduleResponseDto>> getAll() {
		return  ResponseEntity.ok(scheduleService.getAll());
	}

	@PutMapping("/schedules/{scheduleId}")
	public ResponseEntity<String> updateSchedule(@PathVariable Long scheduleId, @RequestBody ScheduleUpdateRequestDto scheduleUpdateRequestDto) {
		scheduleService.updateSchedule(scheduleId, scheduleUpdateRequestDto);
		return ResponseEntity.ok("스케줄 수정 완료");
	}

	@DeleteMapping("/schedules/{scheduleId}")
	public ResponseEntity<String> deleteSchedule(@PathVariable Long scheduleId) {
		scheduleService.deleteSchedule(scheduleId);
		return ResponseEntity.ok("스케줄 삭제 완료");
	}


}
