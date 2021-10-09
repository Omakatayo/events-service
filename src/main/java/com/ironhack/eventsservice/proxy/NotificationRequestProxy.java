package com.ironhack.eventsservice.proxy;

import com.ironhack.eventsservice.dao.Event;
import com.ironhack.eventsservice.dto.EventDTO;
import com.ironhack.eventsservice.dto.NotificationRequestDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("notification-service")
public interface NotificationRequestProxy {

//    @PostMapping("/api/notifications")
//    public EventDTO createNotificationRequestFromEvent(@RequestBody EventDTO eventDTO);
//    public NotificationRequestDTO @PostMapping("/api/notifications")
//    public EventDTO createNotificationRequestFromEvent(@RequestBody EventDTO eventDTO);(@RequestBody NotificationRequestDTO notificationRequestDTO);

    @PostMapping("/api/notifications")
    public NotificationRequestDTO createNotificationRequestFromEvent(@RequestBody NotificationRequestDTO notificationRequestDTO);
}
