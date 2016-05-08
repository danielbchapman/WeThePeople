package wethepeople.data.services;

import javax.annotation.security.PermitAll;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;

import wethepeople.data.backend.User;
import wethepeople.data.backend.Users;

@Path("/users")
public class UserService
{
  @GET
  @Path("/find/{uuid}")
  @PermitAll
  public Response getUserById(@PathParam("uuid") String uuid, @Context Request req)
  {
    User u = Users.find(uuid);
    return Response
        .status(200)
        .entity(u == null ? "no such user" : u.toString())
        .build();

  }
  // @PUT
  // @Path("/users/{uuid}")
  // public Response updateUserById(@PathParam("uuid") String uuid)
  // {
  // //Update the User resource
  // UserDatabase.updateUser(id);
  // return Response.status(200).build();
  // }
}
