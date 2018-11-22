package com.dasanjos.example.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.springframework.stereotype.Component;

@Component
@Path("/hello")
public class HelloWorldEndpoint {

  @GET
  @Path("/world")
  @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
  public String test() {
    return "<Hello>World!</Hello>";
  }

}
