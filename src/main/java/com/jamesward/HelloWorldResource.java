package com.jamesward;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class HelloWorldResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Message getMessage() {
        Message message = new Message();
        message.value = "hello, world";
        return message;
    }

    static class Message {
        public String value;
    }

}
