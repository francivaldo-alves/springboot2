package com.f3pro.springboot2.controller;

import com.f3pro.springboot2.domain.Anime;
import com.f3pro.springboot2.dto.AnimePostDTO;
import com.f3pro.springboot2.dto.AnimePutDTO;
import com.f3pro.springboot2.service.AnimeService;
import com.f3pro.springboot2.util.DateUltil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        return ResponseEntity.ok(animeService.findAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Anime>findById(@PathVariable long id){
        log.info(dateUltil.formatLocalDateToDatebaseStylw(LocalDateTime.now()));
        return ResponseEntity.ok(animeService.findById(id));
    }

    @GetMapping(path = "/find")
    public ResponseEntity<List<Anime>>findByName(@RequestParam String name){
        return ResponseEntity.ok(animeService.findByName(name));
    }




    @PostMapping
    public ResponseEntity<Anime> save(@RequestBody AnimePostDTO animePostDTO ){
        return new ResponseEntity<>( animeService.save(animePostDTO), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id){
        animeService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody AnimePutDTO animePutDTO){
        animeService.replace(animePutDTO);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
