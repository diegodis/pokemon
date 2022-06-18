package com.pockemon.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pockemon.services.IPockemonService;
import com.pockemon.model.Pockemon;
import com.pockemon.model.PockemonApiResponse;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/pockemonapi")
public class pockemonRestController {
	
	@Autowired
	IPockemonService pockemonService;

	
	@GetMapping("/get")
	public PockemonApiResponse index(@RequestParam String range , @RequestParam String page) {
		return pockemonService.getPockemonList(range, page);
	}

}