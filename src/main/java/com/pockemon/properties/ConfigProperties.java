package com.pockemon.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigProperties {
	
	@Value("${pockemon.api.pockemons.init}")
	private String urlPockemonsInit;

	public String getUrlPockemonsInit() {
		return urlPockemonsInit;
	}

	public void setUrlPockemonsInit(String urlPockemonsInit) {
		this.urlPockemonsInit = urlPockemonsInit;
	}


}
