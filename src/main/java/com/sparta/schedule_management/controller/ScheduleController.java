package com.sparta.schedule_management.controller;

import com.sparta.schedule_management.Exception.ForbiddenException;
import com.sparta.schedule_management.dto.ScheduleRequestDto;
import com.sparta.schedule_management.dto.ScheduleResponseDto;
import com.sparta.schedule_management.service.ScheduleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ScheduleController {
    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService){
        this.scheduleService = scheduleService;
    }

    @PostMapping("/schedules")
    public ScheduleResponseDto createSchedule(@RequestBody ScheduleRequestDto scheduleRequestDto) {
        return scheduleService.createSchedule(scheduleRequestDto);
    }

    @GetMapping("/schedules/{id}")
    public ScheduleResponseDto getSchedule(@PathVariable Long id){
        return scheduleService.getSchedule(id);
    }

    @GetMapping("/schedules")
    public List<ScheduleResponseDto> getSchedule(){
        return scheduleService.getSchedule();
    }

    @PutMapping("/schedules/{id}/{password}")
    public ScheduleResponseDto updateSchedule(@PathVariable Long id,@PathVariable String password,@RequestBody ScheduleRequestDto scheduleRequestDto) throws ForbiddenException {
        return scheduleService.updateSchedule(id,password,scheduleRequestDto);
    }

    @DeleteMapping("/schedules/{id}/{password}")
    public String deleteSchedule(@PathVariable Long id, @PathVariable String password) throws ForbiddenException {
        return scheduleService.deleteSchedule(id,password);

    }
}
