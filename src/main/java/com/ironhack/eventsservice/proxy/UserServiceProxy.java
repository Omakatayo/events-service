package com.ironhack.eventsservice.proxy;

import com.ironhack.eventsservice.dto.CoachDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("user-service")
public interface UserServiceProxy {

    @GetMapping("/api/coaches/active/{coachId}")
    CoachDTO findById(@PathVariable(name = "coachId") long id);

}
