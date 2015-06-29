package de.illilli.opendata.koeln.json;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import de.illilli.opendata.service.denkmallistekoeln.json.DenkmallisteKoeln;

public class AskForDenkmallisteKoelnJson extends AskForDenkmallisteKoeln {

	/**
	 * <p>
	 * <a href=
	 * "http://offenedaten-koeln.de/api/action/datastore/search.json?resource_id=4bab19f6-726b-4cc6-8284-f81ec45c61b2"
	 * >Denkmalliste Koeln 2015 JSON</a>
	 * </p>
	 */
	String urlOdk = "http://offenedaten-koeln.de/api/action/datastore/search.json?resource_id=4bab19f6-726b-4cc6-8284-f81ec45c61b2";
	String limit = "&limit=100";
	String offset = "&offset=";

	private static final Logger logger = Logger
			.getLogger(AskForDenkmallisteKoelnJson.class);

	public AskForDenkmallisteKoelnJson() throws MalformedURLException,
			IOException {

		boolean hasNext = true;
		int offsetValue = 0;
		int index = 100;
		String url = "";

		while (hasNext) {
			url = urlOdk + limit + offset + Integer.toString(offsetValue);
			try {
				InputStream inputStream = new URL(url).openStream();
				ObjectMapper mapper = new ObjectMapper();
				DenkmallisteKoeln denkmallisteKoeln = mapper.readValue(
						inputStream, DenkmallisteKoeln.class);
				int recordLength = denkmallisteKoeln.result.records.length;
				if (recordLength == 0) {
					// wenn nichts mehr gelesen wird, braucht auch nichts mehr
					// hinzu gefuegt werden.
					hasNext = false;
					break;
				}
				denkmalListe.addAll(Arrays
						.asList(denkmallisteKoeln.result.records));
				logger.debug(denkmallisteKoeln.toString());
			} catch (InvalidFormatException e) {
				e.printStackTrace();
			}
			offsetValue += index;
			// reset url
			url = "";
		}
	}

	public AskForDenkmallisteKoelnJson(InputStream inputStream) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			DenkmallisteKoeln denkmallisteKoeln = mapper.readValue(inputStream,
					DenkmallisteKoeln.class);
			denkmalListe
					.addAll(Arrays.asList(denkmallisteKoeln.result.records));
			logger.debug(denkmallisteKoeln.toString());
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
