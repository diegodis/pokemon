package com.pockemon.model.dto;

import java.util.List;

public class PockemonDetailModel {
	
	
	private int base_experience;
	private int id;
	private boolean is_default;
	private int height;
	private int weight;
	private String name;
	private int order;
	private List<TypesModel> types;
	private List<StandarLinkPockemonModel> forms;
	private List<GameIndicesModel> game_indices;
	private List<AbilityModel> abilities;
	private String location_area_encounters;
	private List<MovesModel> moves;
	private StandarLinkPockemonModel species;
	private SpritesModel sprites;
	
	
	public List<AbilityModel> getAbilities() {
		return abilities;
	}
	public void setAbilities(List<AbilityModel> abilities) {
		this.abilities = abilities;
	}
	public int getBase_experience() {
		return base_experience;
	}
	public void setBase_experience(int base_experience) {
		this.base_experience = base_experience;
	}
	public List<StandarLinkPockemonModel> getForms() {
		return forms;
	}
	public void setForms(List<StandarLinkPockemonModel> forms) {
		this.forms = forms;
	}
	public List<GameIndicesModel> getGame_indices() {
		return game_indices;
	}
	public void setGame_indices(List<GameIndicesModel> game_indices) {
		this.game_indices = game_indices;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isIs_default() {
		return is_default;
	}
	public void setIs_default(boolean is_default) {
		this.is_default = is_default;
	}
	public String getLocation_area_encounters() {
		return location_area_encounters;
	}
	public void setLocation_area_encounters(String location_area_encounters) {
		this.location_area_encounters = location_area_encounters;
	}
	public List<MovesModel> getMoves() {
		return moves;
	}
	public void setMoves(List<MovesModel> moves) {
		this.moves = moves;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
	public StandarLinkPockemonModel getSpecies() {
		return species;
	}
	public void setSpecies(StandarLinkPockemonModel species) {
		this.species = species;
	}
	
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public List<TypesModel> getTypes() {
		return types;
	}
	public void setTypes(List<TypesModel> types) {
		this.types = types;
	}
	public SpritesModel getSprites() {
		return sprites;
	}
	public void setSprites(SpritesModel sprites) {
		this.sprites = sprites;
	}
	

}
