package com.jamesward;

import org.glassfish.grizzly.http.server.CLStaticHttpHandler;
import org.glassfish.grizzly.http.server.HttpHandler;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.net.URI;


public class App {

    public static void main(String[] args) {
        final String port = System.getenv("PORT")!=null ? System.getenv("PORT") : "9998";
        final URI apiUri = URI.create(String.format("http://0.0.0.0:%s/api", port));

        final ResourceConfig resourceConfig = new ResourceConfig(HelloWorldResource.class);
        HttpHandler httpHandler = new CLStaticHttpHandler(HttpServer.class.getClassLoader(), "/META-INF/resources/");

        final HttpServer server = GrizzlyHttpServerFactory.createHttpServer(apiUri, resourceConfig);
        server.getServerConfiguration().addHttpHandler(httpHandler, "/");

        System.out.println(String.format("Starting Grizzly at: http://localhost:%s", port));
    }
}
