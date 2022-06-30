package com.f3pro.springboot2.service;

import com.f3pro.springboot2.domain.Anime;
import com.f3pro.springboot2.dto.AnimeDTO;
import com.f3pro.springboot2.repository.AnimeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnimeService {

    private final AnimeRepository animeRepository;


    public List<Anime> findAll() {
        return animeRepository.findAll();
    }

    public Anime findById(long id) {
        return animeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Anime not Found"));
    }

    public Anime save(AnimeDTO animeDTO) {

        return animeRepository.save(Anime
                .builder().name(animeDTO.getName()).build());


    }

    public void delete(long id) {
        animeRepository.delete(findById(id));
    }

    public void replace(AnimeDTO animeDTO) {
       Anime savedAnime = findById(animeDTO.getId());
       Anime anime = Anime.builder()
               .id(savedAnime.getId())
               .name(animeDTO.getName())
               .build();
       animeRepository.save(anime);


    }
}
