package com.pockemon.repository;

import com.pockemon.model.dto.PockemonApiResponse;
import com.pockemon.model.dto.PockemonDetailModel;
import com.pockemon.properties.ConfigProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Repository
public class PokemonRepository {


  private final RestTemplate restTemplate = new RestTemplate();
  private String URL;

  @Autowired
  ConfigProperties configProperties;


  public PockemonApiResponse execute(String range, String page) {
    URL = configProperties.getUrlPockemonsInit().concat("?offset=").concat(range).concat("&limit=").concat(page);
    PockemonApiResponse response = restTemplate.getForObject(URL, PockemonApiResponse.class);
    return response;
  }

  public PockemonDetailModel executeDetail(String name) throws HttpClientErrorException {
    try{
      URL = configProperties.getUrlPockemonsInit().concat(name);
      PockemonDetailModel response = restTemplate.getForObject(URL, PockemonDetailModel.class);
      return response;
    }catch (Exception e){
      throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Pockemon not found");
    }
  }

}
