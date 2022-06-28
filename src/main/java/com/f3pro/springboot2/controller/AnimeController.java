package com.f3pro.springboot2.controller;

import com.f3pro.springboot2.domain.Anime;
import com.f3pro.springboot2.service.AnimeService;
import com.f3pro.springboot2.util.DateUltil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(value = "animes")
@Log4j2
@RequiredArgsConstructor
public class AnimeController {

    private final DateUltil dateUltil;
    private final AnimeService animeService;

    @GetMapping
    public ResponseEntity<List<Anime>>list(){
        log.info(dateUltil.formatLocalDateToDatebaseStylw(LocalDateTime.now()));
        return ResponseEntity.ok(animeService.listAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Anime>findById(@PathVariable long id){
        log.info(dateUltil.formatLocalDateToDatebaseStylw(LocalDateTime.now()));
        return ResponseEntity.ok(animeService.findById(id));
    }
}
