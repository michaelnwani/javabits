package com.michaelnwani.helloworld;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import com.michaelnwani.helloworld.resources.HelloWorldResource;
import com.michaelnwani.helloworld.health.TemplateHealthCheck;


public class HelloWorldApplication extends Application<HelloWorldConfiguration> {
	
	public static void main(String[] args) throws Exception {
		new HelloWorldApplication().run(args);
	}
	
	// returns the name of the application
	@Override
	public String getName() {
		return "hello-world";
	}
	
	// used to configure aspects of the application required before the application is run,
	// like bundles, configuration source providers, etc
	@Override
	public void initialize(Bootstrap<HelloWorldConfiguration> bootstrap) {
		// nothing to do yet
	}
	
	@Override
	public void run(HelloWorldConfiguration configuration, Environment environment) {
		// Must register our resources in the application subclass
		// to the Jersey environment
		final HelloWorldResource resource = 
			new HelloWorldResource(configuration.getTemplate(), configuration.getDefaultName());
		
		final TemplateHealthCheck healthCheck =
			new TemplateHealthCheck(configuration.getTemplate());
		// acts like a registry of all the things the app can do.
		environment.healthChecks().register("template", healthCheck);
		environment.jersey().register(resource);
	}
}