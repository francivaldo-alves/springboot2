package com.f3pro.springboot2.repository;

import com.f3pro.springboot2.domain.Anime;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnimeRepository  extends JpaRepository<Anime,Long> {
    List<Anime> findByName(String name);




}
