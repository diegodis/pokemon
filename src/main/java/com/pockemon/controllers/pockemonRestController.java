package com.pockemon.controllers;

import com.pockemon.model.PokemonResponseDto;
import com.pockemon.model.PokemonsResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pockemon.services.IPockemonService;
import com.pockemon.model.dto.PockemonApiResponse;
import com.pockemon.model.dto.PockemonDetailModel;

@CrossOrigin("*")
@RestController
@RequestMapping("/pockemonapi")
public class pockemonRestController {
	
	@Autowired
	IPockemonService pockemonService;

	
	@GetMapping("/get")
	public PokemonsResponseDto index(@RequestParam String range , @RequestParam String page) {
		return pockemonService.getPockemonList(range, page);
	}
	
	@GetMapping("/get/{name}")
	public PokemonResponseDto index(@PathVariable String name) {
		return pockemonService.getPockemonDetail(name);
	}

}