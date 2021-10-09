package com.ironhack.eventsservice.controller;

import com.ironhack.eventsservice.dao.Event;
import com.ironhack.eventsservice.dto.EventDTO;
import com.ironhack.eventsservice.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EventController {

    @Autowired
    EventService eventService;

    @GetMapping("/events")
    public List<Event> getAllEvents() {
        return eventService.findAll();
    }

    @GetMapping("/events/{id}")
    public EventDTO getEventsById(@PathVariable Long id) {
        return eventService.findById(id);
    }

    @PostMapping("/events/{userId}")
    public EventDTO createNewEvent(@PathVariable(name = "userId") Long userId, @RequestBody EventDTO eventDTO) {
        return eventService.createNewEvent(eventDTO);
    }

    @GetMapping("/classes")
    public List<Event> getAllClasses() {
        return eventService.findAll();
    }

    @GetMapping("/classes/{id}")
    public EventDTO getClassesById(@PathVariable Long id) {
        return eventService.findById(id);
    }

    @PostMapping("/classes/{userId}")
    public EventDTO createNewClass(@PathVariable(name = "userId") Long userId, @RequestBody EventDTO eventDTO) {
        return eventService.createNewEvent(eventDTO);
    }
}
