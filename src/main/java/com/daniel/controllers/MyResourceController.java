package com.daniel.controllers;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.daniel.model.FileService;
import org.glassfish.jersey.server.mvc.Viewable;

import java.util.HashMap;
import java.util.Map;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResourceController {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "hello";
    }

    @GET
    @Path("makeFile")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response makeFile() {
        FileService fileService = new FileService();
        try{
            fileService.readWrite();
        }
        catch (Exception e) {
        }

        return Response.ok(fileService.getOutput(), MediaType.APPLICATION_OCTET_STREAM)
                .header("Content-Disposition", "attachment; filename=\"" + fileService.getOutput().getName() + "\"" )
                .build();
    }

}
