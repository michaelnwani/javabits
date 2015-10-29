package com.michaelnwani.helloworld;

import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;

// Using Jackson for ORM
// Configuration object params seem to populate our Representations
public class HelloWorldConfiguration extends Configuration {
	
// if the YAML configuration file has blank values for template
// or defaultName or is missing them entirely an informative exception
// will be thrown and your application won’t start.
	
	@NotEmpty
	private String template;
	
	@NotEmpty
	private String defaultName = "Stranger";
	
	@JsonProperty
	public String getTemplate() {
		return template;
	}
	
	@JsonProperty
	public void setTemplate(String template) {
		this.template = template;
	}
	
	@JsonProperty
	public String getDefaultName() {
		return defaultName;
	}
	
	@JsonProperty
	public void setDefaultName(String name) {
		this.defaultName = name;
	}
}
