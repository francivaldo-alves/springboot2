package com.f3pro.springboot2.mapper;

import com.f3pro.springboot2.domain.Anime;
import com.f3pro.springboot2.dto.AnimePutDTO;
import com.f3pro.springboot2.dto.AnimePostDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public  interface AnimeMapper {


   Anime toAnime(AnimePostDTO animePostDTO);
    Anime toAnime(AnimePutDTO animePutDTO);
}
