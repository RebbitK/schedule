package com.sparta.schedule_management.service;

import com.sparta.schedule_management.Exception.ForbiddenException;
import com.sparta.schedule_management.dto.ScheduleRequestDto;
import com.sparta.schedule_management.dto.ScheduleResponseDto;
import com.sparta.schedule_management.entity.Schedule;
import com.sparta.schedule_management.repository.ScheduleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.util.List;

@Service
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;

    public ScheduleService(ScheduleRepository scheduleRepository){
        this.scheduleRepository = scheduleRepository;
    }
    public ScheduleResponseDto createSchedule(ScheduleRequestDto scheduleRequestDto){
        Schedule schedule = new Schedule(scheduleRequestDto);

        Schedule saveSchedule = scheduleRepository.save(schedule);

        ScheduleResponseDto scheduleResponseDto = new ScheduleResponseDto(schedule);

        return scheduleResponseDto;
    }

    public List<ScheduleResponseDto> getSchedule(){
        return scheduleRepository.findAllByOrderByModifiedAtDesc().stream().map(ScheduleResponseDto::new).toList();
    }

    public ScheduleResponseDto getSchedule(Long id){
        Schedule schedule= findSchedule(id);
        ScheduleResponseDto scheduleResponseDto = new ScheduleResponseDto(schedule);
        return  scheduleResponseDto;
    }

    @Transactional
    public ScheduleResponseDto updateSchedule(Long id, ScheduleRequestDto scheduleRequestDto){
        Schedule schedule= findSchedule(id);
        schedule.update(scheduleRequestDto);
        ScheduleResponseDto scheduleResponseDto = new ScheduleResponseDto(schedule);
        return scheduleResponseDto;
    }

    public Long deleteSchedule(Long id,String password) {

        Schedule schedule = findSchedule(id);
        if(passwordCheckSchedule(password,schedule)){
            scheduleRepository.delete(schedule);
            return id;
        }
        else{

        }

    }

    private Schedule findSchedule(Long id) {
        return scheduleRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("선택하신 일정은 존재하지 않습니다.")
        );
    }

    private boolean passwordCheckSchedule(String password,Schedule schedule){
        int statusCode = 0;
        HttpClient client = HttpClientBuilder.create().build();

        HttpResponse response = client.execute(new HttpGet(url));

        statusCode = response.getStatusLine().getStatusCode();
        return password.equals(schedule.getPassword());
    }

}
