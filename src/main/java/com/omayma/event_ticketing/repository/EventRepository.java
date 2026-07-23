package com.omayma.event_ticketing.repository;

import com.omayma.event_ticketing.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long>{

}
