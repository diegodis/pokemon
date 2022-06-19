package com.pockemon.services;
import com.pockemon.model.PockemonApiResponse;
import com.pockemon.model.PockemonDetailModel;


public interface IPockemonService {
	public PockemonApiResponse getPockemonList(String range, String page);

	public PockemonDetailModel getPockemonDetail(String name);

}
