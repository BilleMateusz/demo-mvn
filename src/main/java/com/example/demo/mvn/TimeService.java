package com.example.demo.mvn;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class TimeService {

    private final DateTimeFormatter ISO8601Format = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");

    public String getCurrentDateTimeISO8601() {
        ZonedDateTime currentZonedDateTime = LocalDateTime
                .now()
                .atZone(ZoneId.of("Europe/Paris"));
        return ISO8601Format.format(currentZonedDateTime);
    }
}
