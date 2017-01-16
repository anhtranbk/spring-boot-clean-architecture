package com.ezgo.resource;

import com.ezgo.domain.Comments;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
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
    @Path("/me/events/{eventId}/comments/{commentId}")
    public Response updateComment(@PathParam("eventId") String eventId,
                                  @PathParam("commentId") String commentId,
                                  Comments comment) {
        return Response.ok(comment).build();
    }
}
