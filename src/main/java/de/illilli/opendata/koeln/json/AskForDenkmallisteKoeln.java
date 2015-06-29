package de.illilli.opendata.koeln.json;

import java.util.ArrayList;
import java.util.List;

import de.illilli.opendata.service.denkmallistekoeln.json.Denkmal;

public abstract class AskForDenkmallisteKoeln {

	List<Denkmal> denkmalListe = new ArrayList<Denkmal>();

	public List<Denkmal> getDenkmallisteKoeln() {
		return denkmalListe;
	}

}
