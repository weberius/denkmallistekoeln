package de.illilli.opendata.service.denkmallistekoeln;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

public class DenkmallisteKoelnByResourceFacade implements Facade {

	private static final Logger logger = Logger
			.getLogger(DenkmallisteKoelnByResourceFacade.class);

	private String json;

	public DenkmallisteKoelnByResourceFacade() {
		InputStream inputStream = this.getClass().getResourceAsStream(
				"/denkmallistekoeln.json");
		try {
			json = IOUtils.toString(inputStream, "UTF-8");
		} catch (IOException e) {
			logger.error(e);
		}
	}

	@Override
	public String getJson() {
		return json;
	}

}
