package com.michaelnwani.helloworld.resources;

import com.michaelnwani.helloworld.core.Saying;
import com.google.common.base.Optional; // Guava
import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.atomic.AtomicLong;

// A Resource Class. Jersey resources are the meat-and-potatoes of a Dropwizard
// application. Each Resource class is associated with a URI template.
// we use Representation instances to interact with the URI
// Jersey = the reference implementation of JAX-RS 
// (the Java API for RESTful Web Services)
// Resource classes are used by multiple threads concurrently

// one element whose name is 'value'; the name can be omitted;
// this resource produces representations which are of type 'application/json'
@Path("/hello-world")
@Produces(MediaType.APPLICATION_JSON)
public class HelloWorldResource {
	private final String template;
	private final String defaultName;
	// cheap, thread-safe way of generating unique(ish) IDs
	private final AtomicLong counter;
	
	public HelloWorldResource(String template, String defaultName) {
		this.template = template;
		this.defaultName = defaultName;
		this.counter = new AtomicLong();
	}
	
	// Dropwizard automatically records the duration and rate of the counter's 
	// invocations as a Metrics Timer
	@GET
	@Timed
	public Saying sayHello(@QueryParam("name") Optional<String> name) {
		// Replacing the %s in "Hello, %s!" with the user's name parameter
		final String value = String.format(template, name.or(defaultName));
		return new Saying(counter.incrementAndGet(), value);
	}
}
