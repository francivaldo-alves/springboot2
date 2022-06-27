package com.f3pro.springboot2.util;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class DateUltil {
    public String formatLocalDateToDatebaseStylw(LocalDateTime localDateTime){
        return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(localDateTime);
    }
}
