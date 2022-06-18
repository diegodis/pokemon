package com.pockemon.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.pockemon.model.PockemonApiResponse;
import com.pockemon.properties.ConfigProperties;

@Service
public class PockemonServiceImpl implements IPockemonService {

	private final RestTemplate restTemplate = new RestTemplate();
	private String URL;
	
	@Autowired
	ConfigProperties configProperties;
	


	@Override
	public PockemonApiResponse getPockemonList(String range, String page) {
		URL = configProperties.getUrlPockemonsInit().concat("?offset=").concat(range).concat("&limit=").concat(page);
		System.out.printf("La url quedo %s", URL);
		PockemonApiResponse response = restTemplate.getForObject(URL, PockemonApiResponse.class);
		System.out.println(response);
		return response;
	}

}
