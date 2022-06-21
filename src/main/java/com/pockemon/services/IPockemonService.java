package com.pockemon.services;
import com.pockemon.model.PokemonResponseDto;
import com.pockemon.model.PokemonsResponseDto;
import com.pockemon.model.dto.PockemonApiResponse;
import com.pockemon.model.dto.PockemonDetailModel;


public interface IPockemonService {
	public PokemonsResponseDto getPockemonList(String range, String page);

	public PokemonResponseDto getPockemonDetail(String name);

}
