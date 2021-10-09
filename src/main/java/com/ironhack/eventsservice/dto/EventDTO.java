package com.ironhack.eventsservice.dto;

import com.ironhack.eventsservice.EventType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EventDTO {
    private Long id;
    private String name;
    private LocalDateTime when;
    private int duration;
    private Long coachId;
    private EventType eventType;
}
