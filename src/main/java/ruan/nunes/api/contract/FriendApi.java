package ruan.nunes.api.contract;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import ruan.nunes.domain.FriendEntity;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Set;

/**
 * @author: Ruan Nunes
 * @version: 1.0 23/12/22
 */
@Path("/api/friend/v1/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "Friends Api", description = "Operations on resources Friend.")
public interface FriendApi {
    @GET
    @Operation(summary = "Get all Friends")
    public List<FriendEntity> get();

    @GET
    @Path("{name}")
    @APIResponse(responseCode = "200")
    @APIResponse(responseCode = "404", description = "friend not found")
    @Operation(summary = "Find friend by name")
    public FriendEntity findByName(@PathParam("name") String name);

    @POST
    @Transactional
    @APIResponse(responseCode = "201",
            description = "friend created",
            content = @Content(schema = @Schema(implementation = FriendEntity.class)))
    @APIResponse(responseCode = "406", description = "Invalid data")
    @APIResponse(responseCode = "409", description = "friend already exists")
    @Operation(summary = "Create new friend")
    public Response create( FriendEntity entity) ;

    @PUT
    @Path("{name}")
    @Transactional
    @APIResponse(responseCode = "200",
            description = "friend updated",
            content = @Content(schema = @Schema(implementation = FriendEntity.class)))
    @APIResponse(responseCode = "404", description = "friend not found")
    @APIResponse(responseCode = "409", description = "friend already exists")
    @Operation(summary = "Edit friend by name")
    public Response update(@PathParam("name") String name,  FriendEntity newEntity) ;

    @DELETE
    @Transactional
    @Path("{name}")
    @APIResponse(responseCode = "204", description = "friend deleted")
    @APIResponse(responseCode = "404", description = "friend not found")
    @Operation(summary = "Delete friend by name")
    public Response delete(@PathParam("name") String name);
}
