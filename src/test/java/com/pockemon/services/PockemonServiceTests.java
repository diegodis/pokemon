package com.pockemon.services;

import java.util.ArrayList;
import java.util.List;

import com.pockemon.model.PokemonResponseDto;
import com.pockemon.model.PokemonsResponseDto;
import com.pockemon.model.dto.*;
import com.pockemon.repository.PokemonRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.pockemon.properties.ConfigProperties;

@SpringBootTest
class PockemonServiceTests {

    @Mock
    private RestTemplate restTemplate;
    
    @Mock
	ConfigProperties configProperties;

    @Mock
    private PokemonRepository pockemonRepository;

    @InjectMocks
    private PockemonServiceImpl pockemonService = new PockemonServiceImpl();
    

    @Test
    public void getPockemonListTest() throws Exception {
    	
    	PockemonApiResponse  responseMock = new PockemonApiResponse();
    	responseMock.setCount(1126);
    	responseMock.setPrevious("http://pokeapi.co/api/v2/pokemon/2");
    	responseMock.setNext("http://pokeapi.co/api/v2/pokemon/4");
    	
    	StandarLinkPockemonModel pockemon = new StandarLinkPockemonModel();
    	pockemon.setName("charmander");
    	pockemon.setUrl("http://pokeapi.co/api/v2/pokemon/charm/2");
    	
    	ArrayList<StandarLinkPockemonModel> pockemons = new ArrayList<StandarLinkPockemonModel>();
    	pockemons.add(pockemon); 
    	responseMock.setResults(pockemons);

        Mockito
          .when(restTemplate.getForEntity(
            "https://pokeapi.co/api/v2/pokemon?offset=2&limit=2", PockemonApiResponse.class))
          .thenReturn(new ResponseEntity<PockemonApiResponse>(responseMock, HttpStatus.OK));

        Mockito
                .when(pockemonRepository.execute("2", "2"))
                .thenReturn(responseMock);
        
        Mockito
        .when(configProperties.getUrlPockemonsInit())
        .thenReturn("https://pokeapi.co/api/v2/pokemon/");

        PokemonsResponseDto responseTest = pockemonService.getPockemonList("2", "2");
        
        Assertions.assertEquals(String.valueOf(responseMock.getCount()), responseTest.getMetadata().getCount());
        
    }
    
    @Test
    public void getPockemonDetailTest() {

    	PockemonDetailModel  responseMock = new PockemonDetailModel();
    	responseMock.setHeight(6);

    	StandarLinkPockemonModel sh = new StandarLinkPockemonModel();
    	sh.setName("a");
    	sh.setUrl("http://");

        AbilityModel abilities = new AbilityModel();
        abilities.setAbility(sh);
        List<AbilityModel> abilitiesList = new ArrayList<>();
        abilitiesList.add(abilities);
        List<TypesModel> typesModels = new ArrayList<>();
        abilitiesList.add(abilities);
        responseMock.setAbilities(abilitiesList);

        TypesModel type = new TypesModel();
        type.setType(sh);
        List<TypesModel> typesList = new ArrayList<>();
        typesList.add(type);
        responseMock.setTypes(typesList);

        MovesModel move = new MovesModel();
        move.setMoves(sh);
        List<MovesModel> movesList = new ArrayList<>();
        movesList.add(move);
        responseMock.setMoves(movesList);

        SpritesModel sprites = new SpritesModel();
        sprites.setBack_default("http://a");
        sprites.setFront_default("http://b");
        responseMock.setSprites(sprites);

        Mockito
        .when(configProperties.getUrlPockemonsInit())
        .thenReturn("https://pokeapi.co/api/v2/pokemon/");

        Mockito
                .when(pockemonRepository.executeDetail("charmander"))
                .thenReturn(responseMock);

        PokemonResponseDto responseTest = pockemonService.getPockemonDetail("charmander");
        
        Assertions.assertEquals(String.valueOf(responseMock.getHeight()), responseTest.getHeight());
    }
}
