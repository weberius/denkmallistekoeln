package de.illilli.opendata.service.denkmallistekoeln;

import java.io.IOException;
import java.net.MalformedURLException;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import de.illilli.opendata.koeln.json.AskForDenkmallisteKoeln;
import de.illilli.opendata.koeln.json.AskForDenkmallisteKoelnJson;
import de.illilli.opendata.service.denkmallistekoeln.json.Denkmal;

public class DenkmallisteKoelnFacade implements Facade {

	private static final Logger logger = Logger
			.getLogger(DenkmallisteKoelnFacade.class);

	private StringBuilder json = new StringBuilder("{}");

	public DenkmallisteKoelnFacade() {
		try {
			AskForDenkmallisteKoeln askFor = new AskForDenkmallisteKoelnJson();
			Denkmal[] denkmalArray = askFor.getDenkmallisteKoeln().result.records;
			GsonBuilder gsonBuilder = new GsonBuilder();
			Gson gson = gsonBuilder.create();
			json = new StringBuilder(gson.toJson(denkmalArray));
		} catch (MalformedURLException e) {
			logger.error(e);
		} catch (IOException e) {
			logger.error(e);
		}
	}

	@Override
	public String getJson() {
		return json.toString();
	}

}
