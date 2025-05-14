package com.example.schedulecomment.schedule.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.schedulecomment.schedule.entity.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}
