package com.srisaisadan.homeautomation.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author Indraneel C S
 *
 * Mail to me @ indraneelcs@gmail.com
 */
@Path("/")
public class RestResource {

	@GET
	@Path("getTestData")
	@Produces(MediaType.TEXT_PLAIN)
	public String testGetRest() {
		return "Hiiii"; 
	}
}
 