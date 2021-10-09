package com.ironhack.eventsservice.repositories;

import com.ironhack.eventsservice.dao.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
}
