package com.f3pro.springboot2.service;

import com.f3pro.springboot2.domain.Anime;
import com.f3pro.springboot2.dto.AnimePostDTO;
import com.f3pro.springboot2.dto.AnimePutDTO;
import com.f3pro.springboot2.mapper.AnimeMapper;
import com.f3pro.springboot2.repository.AnimeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnimeService {

    private final AnimeRepository animeRepository;

    private final AnimeMapper mapper;

    public List<Anime> findByName(String name) {
        return animeRepository.findByName(name);
    }

    public List<Anime> findAll() {
        return animeRepository.findAll();
    }

    public Anime findById(long id) {
        return animeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Anime not Found"));
    }

    public Anime save(AnimePostDTO animePostDTO) {

        return animeRepository.save(mapper.toAnime(animePostDTO));


    }

    public void delete(long id) {
        animeRepository.delete(findById(id));
    }

    public void replace(AnimePutDTO animePutDTO) {
        Anime savedAnime = findById(animePutDTO.getId());
        Anime anime = mapper.toAnime(animePutDTO);
        anime.setId(savedAnime.getId());
        animeRepository.save(anime);


    }
}
