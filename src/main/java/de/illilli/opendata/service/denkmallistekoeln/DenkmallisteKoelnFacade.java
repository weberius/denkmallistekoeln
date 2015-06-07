package de.illilli.opendata.service.denkmallistekoeln;

public class DenkmallisteKoelnFacade implements Facade {

	private StringBuilder sb = new StringBuilder("{}");

	@Override
	public String getJson() {
		return sb.toString();
	}

}
