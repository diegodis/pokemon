package com.pockemon.services;

import com.pockemon.model.Metadata;
import com.pockemon.model.PokemonGeneral;
import com.pockemon.model.PokemonResponseDto;
import com.pockemon.model.PokemonsResponseDto;
import com.pockemon.model.dto.PockemonApiResponse;
import com.pockemon.model.dto.PockemonDetailModel;
import com.pockemon.model.dto.StandarLinkPockemonModel;
import com.pockemon.repository.PokemonRepository;

import java.net.http.HttpClient;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

@Service
public class PockemonServiceImpl implements IPockemonService {

  @Autowired
  private PokemonRepository pokemonRepository;

  @Override
  @Cacheable(cacheNames = "pockemons", key = "{#range, #page}")
  public PokemonsResponseDto getPockemonList(String range, String page) throws Exception {
    PockemonApiResponse response = pokemonRepository.execute(range, page);

    return PokemonsResponseDto.builder()
        .metadata(Metadata.builder()
            .count(String.valueOf(response.getCount()))
            .page(page)
            .range(range)
            .build())
        .pokemons(response.getResults().stream().map(pokemon -> buildPokemon(pokemon)).collect(
            Collectors.toList()))
        .build();
  }

  private PokemonGeneral buildPokemon(StandarLinkPockemonModel pokemon) {
    return PokemonGeneral.builder()
        .name(pokemon.getName())
        .id(pokemon.getUrl().split("/")[6])
        .build();
  }

  @Override
  @Cacheable(cacheNames = "pockemon", key = "#name")
  public PokemonResponseDto getPockemonDetail(String name) throws HttpClientErrorException {
    PockemonDetailModel response = pokemonRepository.executeDetail(name);

    return PokemonResponseDto.builder()
        .id(String.valueOf(response.getId()))
        .name(response.getName())
        .height(String.valueOf(response.getHeight()))
        .weight(String.valueOf(response.getWeight()))
        .abilities(
            response.getAbilities().stream().map(abilityName -> abilityName.getAbility().getName())
                .collect(
                    Collectors.toList()))
        .types(response.getTypes().stream().map(typeName -> typeName.getType().getName()).collect(
            Collectors.toList()))
        .moves(response.getMoves().stream().map(move -> move.getMove().getName()).collect(
            Collectors.toList()))
        .urlImgFront(response.getSprites().getFront_default())
        .urlImgBack(response.getSprites().getBack_default())
        .build();
  }

}
