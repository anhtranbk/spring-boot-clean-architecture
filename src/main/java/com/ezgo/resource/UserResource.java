package com.ezgo.resource;

import com.ezgo.domain.Users;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * TODO: Class description here.
 *
 * @author <a href="https://github.com/tjeubaoit">tjeubaoit</a>
 */
@Component
@Path("/me")
public class UserResource {

    @Value("${root_photo_path}")
    private String rootPhotoPath;

    @GET
    public Response me() {
        return Response.ok(rootPhotoPath).build();
    }

    @PUT
    public Response updateUser(Users user) {
        return Response.ok().build();
    }
}
