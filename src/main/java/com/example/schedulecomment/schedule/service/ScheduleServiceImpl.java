package com.example.schedulecomment.schedule.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.example.schedulecomment.schedule.dto.ScheduleRequestDto;
import com.example.schedulecomment.schedule.dto.ScheduleResponseDto;
import com.example.schedulecomment.schedule.dto.ScheduleUpdateRequestDto;
import com.example.schedulecomment.schedule.entity.Schedule;
import com.example.schedulecomment.schedule.repository.ScheduleRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ScheduleServiceImpl implements ScheduleService {

	private final ScheduleRepository scheduleRepository;

	@Override
	public ScheduleResponseDto createSchedule(ScheduleRequestDto scheduleRequestDto) {

		if (scheduleRequestDto.getTitle() == null || scheduleRequestDto.getTitle().isBlank()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "제목은 필수입니다.");
		}

		if (scheduleRequestDto.getContent() == null || scheduleRequestDto.getContent().isBlank()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "내용은 필수입니다.");
		}

		Schedule saveschedule = new Schedule(scheduleRequestDto.getWriterId(), scheduleRequestDto.getTitle(),
			scheduleRequestDto.getContent());

		Schedule saved = scheduleRepository.save(saveschedule);

		return new ScheduleResponseDto(
			saved.getId(),
			saved.getWriterId(),
			saved.getTitle(),
			saved.getContent(),
			saved.getCreatedAt()
		);
	}

	@Override
	public ScheduleResponseDto findById(Long id) {
		Schedule schedule = scheduleRepository.findById(id).orElseThrow(
			() -> new RuntimeException("게시물이 존재하지 않습니다")
		);
		return new ScheduleResponseDto(schedule.getId(), schedule.getWriterId(), schedule.getTitle(), schedule.getContent(), schedule.getCreatedAt());
	}

	@Override
	public List<ScheduleResponseDto> getAll() {
		List<Schedule> scheduleList = scheduleRepository.findAll();
		List<ScheduleResponseDto> responseDtoList = new ArrayList<>();
		for(Schedule schedule : scheduleList) {
			ScheduleResponseDto scheduleResponseDto = new ScheduleResponseDto(schedule.getId(),schedule.getWriterId(), schedule.getTitle(), schedule.getContent(), schedule.getCreatedAt());
			responseDtoList.add(scheduleResponseDto);
		}// 엔티티를 하나씩 순회하며 ScheduleResponseDto로 변환 -> 변환된 리스트는 응답리스트에 추가됨
		return responseDtoList;
	}

	@Transactional
	@Override
	public void updateSchedule(Long id, ScheduleUpdateRequestDto scheduleUpdateRequestDto) {
		Schedule schedule = scheduleRepository.findById(id)
			.orElseThrow(() -> new IllegalArgumentException("스케줄을 찾을 수 없습니다."));

		schedule.updateSchedule(scheduleUpdateRequestDto);
	}



	@Override
	public void deleteSchedule(Long id) {

		Schedule schedule = scheduleRepository.findById(id)
			.orElseThrow(() -> new IllegalArgumentException("스케줄을 찾을 수 없습니다"));


		scheduleRepository.delete(schedule);
	}

}