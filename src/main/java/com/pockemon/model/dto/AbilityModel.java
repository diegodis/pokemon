package com.pockemon.model.dto;

public class AbilityModel {
	
	private StandarLinkPockemonModel ability;
	private boolean is_hidden;
	private int slot;
	
	public StandarLinkPockemonModel getAbility() {
		return ability;
	}
	public void setAbility(StandarLinkPockemonModel ability) {
		this.ability = ability;
	}
	public boolean isIs_hidden() {
		return is_hidden;
	}
	public void setIs_hidden(boolean is_hidden) {
		this.is_hidden = is_hidden;
	}
	public int getSlot() {
		return slot;
	}
	public void setSlot(int slot) {
		this.slot = slot;
	}
	
}


