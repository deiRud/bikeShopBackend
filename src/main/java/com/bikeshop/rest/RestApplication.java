package com.bikeshop.rest;
import org.glassfish.jersey.server.ResourceConfig;
import javax.ws.rs.ApplicationPath;

@ApplicationPath("/api") 
public class RestApplication extends ResourceConfig {
    public RestApplication() {
        // REST endpoints
        packages("com.bikeshop.rest"); // Specify the package where your resources are located
    }
}
