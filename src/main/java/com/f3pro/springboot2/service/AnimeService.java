package com.f3pro.springboot2.service;

import com.f3pro.springboot2.domain.Anime;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimeService {

    public List<Anime> listAll(){

        return List.of(new Anime(1L,"aa"), new Anime(2L,"Berserk"));

    }
}
