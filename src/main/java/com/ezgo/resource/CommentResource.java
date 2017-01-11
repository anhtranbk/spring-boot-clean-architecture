package com.ezgo.resource;

import com.ezgo.domain.Comments;
import org.springframework.stereotype.Component;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO: Class description here.
 *
 * @author <a href="https://github.com/tjeubaoit">tjeubaoit</a>
 */
@Component
@Path("/")
public class CommentResource {

    @GET
    @Path("/events/{eventId}/comments")
    public List<Comments> getCommentsByEventId(@PathParam("eventId") String eventId,
                                               @DefaultValue("0") @QueryParam("offset") int offset,
                                               @DefaultValue("20") @QueryParam("limit") int limit) {
        return new ArrayList<>();
    }

    @POST
    @Path("/me/events/{eventId}/comments")
    public Response createComment(@PathParam("eventId") String eventId,
                                  Comments comment) {
        return Response.ok(comment).build();
    }

    @PUT
    @Path("/me/events/{eventId}/comments")
    public Response updateComment(@PathParam("eventId") String eventId,
                                  Comments comment) {
        return Response.ok(comment).build();
    }
}
