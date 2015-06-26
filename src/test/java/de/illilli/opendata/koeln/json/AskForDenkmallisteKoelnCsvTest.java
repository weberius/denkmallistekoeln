package de.illilli.opendata.koeln.json;

import java.io.InputStream;

import org.junit.Before;
import org.junit.Test;

import de.illilli.opendata.service.denkmallistekoeln.json.Denkmal;
import de.illilli.opendata.service.denkmallistekoeln.json.DenkmallisteKoeln;

public class AskForDenkmallisteKoelnCsvTest {

	private Denkmal[] denkmal;

	@Before
	public void setUp() throws Exception {
		InputStream inputStream = this.getClass().getResourceAsStream(
				"/20150522_Denkmalliste.csv");

		AskForDenkmallisteKoeln askfor = new AskForDenkmallisteKoelnCsv(
				inputStream);

		DenkmallisteKoeln denkmallisteKoeln = askfor.getDenkmallisteKoeln();
		denkmal = denkmallisteKoeln.result.records;
	}

	@Test
	public void testGetDenkmallisteKoeln() {
		System.out.println(denkmal.toString());
	}

}
