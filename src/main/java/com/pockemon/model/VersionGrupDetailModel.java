package com.pockemon.model;

public class VersionGrupDetailModel {
	
	private int level_learned_at;
	private StandarLinkPockemonModel move_learn_method;
	private StandarLinkPockemonModel version_group;
	
	public int getLevel_learned_at() {
		return level_learned_at;
	}
	public void setLevel_learned_at(int level_learned_at) {
		this.level_learned_at = level_learned_at;
	}
	public StandarLinkPockemonModel getMove_learn_method() {
		return move_learn_method;
	}
	public void setMove_learn_method(StandarLinkPockemonModel move_learn_method) {
		this.move_learn_method = move_learn_method;
	}
	public StandarLinkPockemonModel getVersion_group() {
		return version_group;
	}
	public void setVersion_group(StandarLinkPockemonModel version_group) {
		this.version_group = version_group;
	}
}
