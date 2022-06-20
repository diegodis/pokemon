package com.pockemon.services;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.pockemon.model.PockemonApiResponse;
import com.pockemon.model.PockemonDetailModel;
import com.pockemon.model.StandarLinkPockemonModel;
import com.pockemon.properties.ConfigProperties;

@SpringBootTest
class PockemonServiceTests {

    @Mock
    private RestTemplate restTemplate;
    
    @Mock
	ConfigProperties configProperties;

    @InjectMocks
    private PockemonServiceImpl pockemonService = new PockemonServiceImpl();
    

    @Test
    public void getPockemonListTest() {
    	
    	PockemonApiResponse  responseMock = new PockemonApiResponse();
    	responseMock.setCount(1126);
    	responseMock.setNext("http://pockeapi/2");
    	responseMock.setNext("http://pockeapi/4");
    	
    	StandarLinkPockemonModel pockemon = new StandarLinkPockemonModel();
    	pockemon.setName("charmander");
    	pockemon.setUrl("http://pockemon/charm/2");
    	
    	ArrayList<StandarLinkPockemonModel> pockemons = new ArrayList<StandarLinkPockemonModel>();
    	pockemons.add(pockemon); 
    	responseMock.setResults(pockemons);
    	
    	
        Mockito
          .when(restTemplate.getForEntity(
            "https://pokeapi.co/api/v2/pokemon?offset=2&limit=2", PockemonApiResponse.class))
          .thenReturn(new ResponseEntity<PockemonApiResponse>(responseMock, HttpStatus.OK));
        
        Mockito
        .when(configProperties.getUrlPockemonsInit())
        .thenReturn("https://pokeapi.co/api/v2/pokemon/");

        PockemonApiResponse responseTest = pockemonService.getPockemonList("2", "2");
        
        Assertions.assertEquals(responseMock.getCount(), responseTest.getCount());
        
        
    }
    
    @Test
    public void getPockemonDetailTest() {
    	
    	PockemonDetailModel  responseMock = new PockemonDetailModel();
    	responseMock.setHeight(6);;
    	
        Mockito
        .when(configProperties.getUrlPockemonsInit())
        .thenReturn("https://pokeapi.co/api/v2/pokemon/");

        PockemonDetailModel responseTest = pockemonService.getPockemonDetail("charmander");
        
        Assertions.assertEquals(responseMock.getHeight(), responseTest.getHeight());
        
        
    }
}