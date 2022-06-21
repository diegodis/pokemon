package com.pockemon.repository;

import com.pockemon.model.dto.PockemonApiResponse;
import com.pockemon.model.dto.PockemonDetailModel;
import com.pockemon.properties.ConfigProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class PokemonRepository {


  private final RestTemplate restTemplate = new RestTemplate();
  private String URL;

  @Autowired
  ConfigProperties configProperties;


  public PockemonApiResponse execute(String range, String page) {
    URL = configProperties.getUrlPockemonsInit().concat("?offset=").concat(range).concat("&limit=").concat(page);
    System.out.printf("La url quedo %s", URL);
    PockemonApiResponse response = restTemplate.getForObject(URL, PockemonApiResponse.class);
    System.out.println(response);
    return response;
  }

  public PockemonDetailModel executeDetail(String name) {
    URL = configProperties.getUrlPockemonsInit().concat(name);
    PockemonDetailModel response = restTemplate.getForObject(URL, PockemonDetailModel.class);
    System.out.println(response);
    return response;
  }
}
