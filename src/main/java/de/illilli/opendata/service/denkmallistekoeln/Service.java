package de.illilli.opendata.service.denkmallistekoeln;

import java.io.IOException;
import java.net.URISyntaxException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Path("/")
public class Service {

	private final static Logger logger = Logger.getLogger(Service.class);

	@Context
	HttpServletRequest request;

	@Context
	HttpServletResponse response;

	/**
	 * Dieser Service liest den Service <a
	 * href="http://www.offenedaten-koeln.de/dataset/denkmalliste-stadt-koeln"
	 * >Denkmalliste K&ouml;ln</a> von Offene Daten K&ouln;ln ein und gibt ein
	 * geoJson zur&uuml;ck.
	 * <p>
	 * http://localhost:8080/denkmallistekoeln/service
	 * </p>
	 * <p>
	 * http://localhost:8080/denkmallistekoeln/service?res
	 * </p>
	 * 
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/")
	public String getKoeln() throws JsonParseException, JsonMappingException,
			IOException, URISyntaxException {
		String json = "";
		boolean fromResource = request.getParameter("res") != null ? true
				: false;
		// setze das Character-Encoding fuer die Antwort auf UTF-8
		response.setCharacterEncoding("UTF-8");
		logger.debug("requesting denkmalliste koeln");
		if (fromResource) {
			json = new DenkmallisteKoelnByResourceFacade().getJson();
		} else {
			json = new DenkmallisteKoelnFacade().getJson();
		}

		return json;
	}

}
