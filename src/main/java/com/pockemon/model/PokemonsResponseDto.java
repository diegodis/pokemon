package com.pockemon.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PokemonsResponseDto {

  private Metadata metadata;
  private List<PokemonGeneral> pokemons;
}
