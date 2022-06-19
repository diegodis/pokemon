package com.pockemon.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.pockemon.model.PockemonApiResponse;
import com.pockemon.model.PockemonDetailModel;
import com.pockemon.properties.ConfigProperties;

@Service
public class PockemonServiceImpl implements IPockemonService {

	private final RestTemplate restTemplate = new RestTemplate();
	private String URL;
	
	@Autowired
	ConfigProperties configProperties;
	


	@Override
	@Cacheable(cacheNames = "pockemons", key="#page")
	public PockemonApiResponse getPockemonList(String range, String page) {
		URL = configProperties.getUrlPockemonsInit().concat("?offset=").concat(range).concat("&limit=").concat(page);
		System.out.printf("La url quedo %s", URL);
		PockemonApiResponse response = restTemplate.getForObject(URL, PockemonApiResponse.class);
		System.out.println(response);
		return response;
	}
	
	@Override
	@Cacheable(cacheNames = "pockemon", key="#name")
	public PockemonDetailModel getPockemonDetail(String name){
		URL = configProperties.getUrlPockemonsInit().concat(name);
		PockemonDetailModel response = restTemplate.getForObject(URL, PockemonDetailModel.class);
		System.out.println(response);
		return response;
	}

}
