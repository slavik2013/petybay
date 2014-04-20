package controllers;



import model.Location;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;
import java.util.List;

/**
 * Created by home on 15.03.14.
 */

@Path("/rest")
public class BasicService {

    @Inject
    BaseController mBaseController;

    @GET
    @Produces("application/json")
    @Path("/location")
    public JsonArray getClichedMessage() {
        List<Location> list = mBaseController.getAll();
        JsonArrayBuilder builder = Json.createArrayBuilder();
        for (Location location : list) {
            builder.add(Json.createObjectBuilder().add("id",location.getId()).add("country",location.getCountry())
            .add("region", location.getRegion()).add("city", location.getCity()));
        }
        return builder.build();
    }

}
