package com.michaelnwani.helloworld.health;

import com.codahale.metrics.health.HealthCheck;

// Health checks give you a way to add small tests to your app
// to allow you to verify that its functioning correctly in production.

// We’re adding a health check to make sure we can actually format the provided template
public class TemplateHealthCheck extends HealthCheck {
	private final String template;
	
	public TemplateHealthCheck(String template) {
		this.template = template;
	}
	
	@Override
	protected Result check() throws Exception {
		final String saying = String.format(template, "TEST");
		if (!saying.contains("TEST")) {
			return Result.unhealthy("template doesn't include a name");
		}
		
		return Result.healthy();
	}
}
