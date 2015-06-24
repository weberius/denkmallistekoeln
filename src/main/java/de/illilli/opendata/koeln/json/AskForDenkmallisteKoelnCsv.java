package de.illilli.opendata.koeln.json;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import de.illilli.opendata.service.denkmallistekoeln.json.DenkmallisteKoeln;

public class AskForDenkmallisteKoelnCsv extends AskForDenkmallisteKoeln {

	/**
	 * <p>
	 * <a href=
	 * "http://offenedaten-koeln.de/api/action/datastore/search.json?resource_id=4bab19f6-726b-4cc6-8284-f81ec45c61b2"
	 * >Denkmalliste Koeln 2015 JSON</a>
	 * </p>
	 */
	public static final String URL = "http://www.offenedaten-koeln.de/sites/default/files/20150522_Denkmalliste.csv";

	private static final Logger logger = Logger
			.getLogger(AskForDenkmallisteKoelnCsv.class);

	public AskForDenkmallisteKoelnCsv() throws MalformedURLException,
			IOException {

		InputStream inputStream = new URL(URL).openStream();
		ObjectMapper mapper = new ObjectMapper();
		denkmallisteKoeln = mapper.readValue(inputStream,
				DenkmallisteKoeln.class);
		logger.debug(denkmallisteKoeln.toString());
	}

	public AskForDenkmallisteKoelnCsv(InputStream inputStream)
			throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		denkmallisteKoeln = mapper.readValue(inputStream,
				DenkmallisteKoeln.class);
		logger.debug(denkmallisteKoeln.toString());
	}

	public DenkmallisteKoeln getDenkmallisteKoeln() {
		return denkmallisteKoeln;
	}

}
