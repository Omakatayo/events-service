package com.ironhack.eventsservice.service;

import com.ironhack.eventsservice.dao.Event;
import com.ironhack.eventsservice.dto.CoachDTO;
import com.ironhack.eventsservice.dto.EventDTO;
import com.ironhack.eventsservice.proxy.UserServiceProxy;
import com.ironhack.eventsservice.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    @Autowired
    EventRepository eventRepository;

    @Autowired
    UserServiceProxy userServiceProxy;

    public List<Event> findAll() { return eventRepository.findAll();}

    public EventDTO findById(long id) {
        Event foundEvent = eventRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Event with id " + id + " does not exist."));
        EventDTO foundEventDTO = convertEventToDto(foundEvent);
        return foundEventDTO;
    }

    public EventDTO createNewEvent(EventDTO eventDTO) {
        if (isValidCoach(eventDTO)) {
            Event event = convertDtoToEvent(eventDTO);
            eventRepository.save(event);
            EventDTO newEventDTO = convertEventToDto(event);
            return newEventDTO;
        }
        else {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN,"You do not have access to create events");
        }
    }

    public Boolean isValidCoach(EventDTO eventDto) {
        CoachDTO coach = userServiceProxy.findById(eventDto.getCoachId());
        if (coach.getEmail() != null) {
            return true;
        }
        return false;
    }

    public EventDTO convertEventToDto(Event event) {
        EventDTO newEventDto = new EventDTO(event.getId(), event.getName(),
                event.getWhen(), event.getDuration(), event.getCoachId(),
                event.getEventType());
        return newEventDto;
    }

    public Event convertDtoToEvent(EventDTO eventDTO) {
        Event newEvent = new Event(eventDTO.getId(), eventDTO.getName(),
                eventDTO.getWhen(), eventDTO.getDuration(), eventDTO.getCoachId(),
                eventDTO.getEventType());
        return newEvent;
    }
}
