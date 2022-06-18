package com.pockemon.services;
import com.pockemon.model.PockemonApiResponse;


public interface IPockemonService {
	public PockemonApiResponse getPockemonList(String range, String page);

}
