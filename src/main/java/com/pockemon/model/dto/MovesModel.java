package com.pockemon.model.dto;

import java.util.List;

public class MovesModel {
	private StandarLinkPockemonModel moves;
	private List<VersionGrupDetailModel> version_group_details;
	
	public StandarLinkPockemonModel getMoves() {
		return moves;
	}
	public void setMoves(StandarLinkPockemonModel moves) {
		this.moves = moves;
	}
	public List<VersionGrupDetailModel> getVersion_group_details() {
		return version_group_details;
	}
	public void setVersion_group_details(List<VersionGrupDetailModel> version_group_details) {
		this.version_group_details = version_group_details;
	}
}
