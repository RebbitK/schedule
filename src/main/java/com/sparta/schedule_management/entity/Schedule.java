package com.sparta.schedule_management.entity;

import com.sparta.schedule_management.dto.ScheduleRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="schedule")
@NoArgsConstructor
public class Schedule extends Timestamped{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="title",nullable = false)
    private String title;
    @Column(name="contents",nullable = false, length = 500)
    private String contents;
    @Column(name="manager",nullable = false)
    private String manager;
    @Column(name="password",nullable = false)
    private String password;

    public Schedule(ScheduleRequestDto scheduleRequestDto){
        this.title = scheduleRequestDto.getTitle();
        this.contents = scheduleRequestDto.getContents();
        this.manager = scheduleRequestDto.getManager();
        this.password = scheduleRequestDto.getPassword();
    }

    public void update(ScheduleRequestDto scheduleRequestDto){
        this.title = scheduleRequestDto.getTitle();
        this.contents = scheduleRequestDto.getContents();
        this.manager = scheduleRequestDto.getManager();
        this.password = scheduleRequestDto.getPassword();
    }
}
