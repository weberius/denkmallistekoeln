package de.illilli.opendata.koeln.json;

import java.io.InputStream;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import de.illilli.opendata.service.denkmallistekoeln.json.Denkmal;

public class AskForDenkmallisteKoelnCsvTest {

	private List<Denkmal> denkmal;

	@Before
	public void setUp() throws Exception {
		InputStream inputStream = this.getClass().getResourceAsStream(
				"/20150522_Denkmalliste.csv");

		AskForDenkmallisteKoeln askfor = new AskForDenkmallisteKoelnCsv(
				inputStream);

		denkmal = askfor.getDenkmallisteKoeln();
	}

	@Test
	public void testGetDenkmallisteKoeln() {
		System.out.println(denkmal.toString());
	}

}
