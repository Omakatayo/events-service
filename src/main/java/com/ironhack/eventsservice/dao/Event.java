package com.ironhack.eventsservice.dao;

import com.ironhack.eventsservice.EventType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private LocalDateTime when;
    private int duration;
    private Long coachId;
    private EventType eventType;

    public Event(String name, LocalDateTime when, int duration, Long coachId, EventType eventType) {
        this.name = name;
        this.when = when;
        this.duration = duration;
        this.coachId = coachId;
        this.eventType = eventType;
    }
}
