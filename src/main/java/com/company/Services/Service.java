package com.company.Services;

import com.company.DAO.UserDao;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Date;

@Path("/hw56")
public class Service {
    @GET
    @Path("/time")
    @Produces(MediaType.APPLICATION_JSON)
    public String getDate() {
        return new Date().toString();
    }

    @GET
    @Path("/{num1}&{num2}")
    @Produces(MediaType.APPLICATION_JSON)
    public int getSum(@PathParam("num1") Integer num1, @PathParam("num2") Integer num2) {
        return num1 + num2;
    }

    @GET
    @Path("{name}&{password}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getMessage(@PathParam("name") String name, @PathParam("password") String password) throws Exception {
        if (UserDao.getUserByNamePassword(name, password))
            return "TemporalKey";
        else throw new Exception();
    }
}
