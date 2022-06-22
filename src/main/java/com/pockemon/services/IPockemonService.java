package com.pockemon.services;
import com.pockemon.model.PokemonResponseDto;
import com.pockemon.model.PokemonsResponseDto;
import com.pockemon.model.dto.PockemonApiResponse;
import com.pockemon.model.dto.PockemonDetailModel;
import org.springframework.web.client.HttpClientErrorException;


public interface IPockemonService {
	public PokemonsResponseDto getPockemonList(String range, String page) throws Exception;

	public PokemonResponseDto getPockemonDetail(String name) throws HttpClientErrorException;

}
