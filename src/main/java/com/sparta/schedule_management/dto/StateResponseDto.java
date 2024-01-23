package com.sparta.schedule_management.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class StateResponseDto {
    private String errorCode;
    private String errorMessage;
}
