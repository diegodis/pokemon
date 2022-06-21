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
public class PokemonResponseDto {

  private String id;
  private String name;
  private String height;
  private String weight;
  private List<String> types;
  private List<String> abilities;
  private List<String> moves;
  private String urlImgFront;
  private String urlImgBack;

  //TODO evoluciones se saca de pokemon-species/3/ evolution_chain pero este solo muestra nombres no fotos


}
