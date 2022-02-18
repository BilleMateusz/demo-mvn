package com.example.demo.mvn;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@RequiredArgsConstructor
@RestController
public class TimeController {

    private final TimeService timeService;

    @GetMapping("/now")
    public String now() {
        return timeService.getCurrentDateTimeISO8601();
    }
}