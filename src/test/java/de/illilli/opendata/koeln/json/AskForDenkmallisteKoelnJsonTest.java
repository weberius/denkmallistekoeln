package de.illilli.opendata.koeln.json;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import de.illilli.opendata.service.denkmallistekoeln.json.Denkmal;

public class AskForDenkmallisteKoelnJsonTest {

	private List<Denkmal> denkmal;

	@Before
	public void setUp() throws Exception {
		InputStream inputStream = this.getClass().getResourceAsStream(
				"/denkmallistekoeln100.json");

		AskForDenkmallisteKoeln askfor = new AskForDenkmallisteKoelnJson(
				inputStream);

		denkmal = askfor.getDenkmallisteKoeln();
	}

	@Test
	public void testGetDenkmallisteKoelnSize() throws JsonParseException,
			JsonMappingException, IOException {

		int expected = 100;
		int actual = denkmal.size();
		Assert.assertEquals(expected, actual);

	}

	/**
	 * Denkmal [denkmalnummer=1, untergruppe1=, untergruppe2=0,
	 * strasse=Adolphstrasse, nummer=o.Nr., bezirk=1, plz=50679, ort=Deutz,
	 * unterSchutz=01.07.1980, baujahrZusatz=, baujahr=1910,
	 * kurzbezeichnung=Allee, feedsFlatstoreEntryId=1, timestamp=1432648733,
	 * feedsEntityId=1187], Denkmal [denkmalnummer=2, untergruppe1=,
	 * untergruppe2=0, strasse=Agrippinaufer , nummer=o.Nr., bezirk=1,
	 * plz=50678, ort=Neustadt-Süd, unterSchutz=01.07.1980, baujahrZusatz=um,
	 * baujahr=1900, kurzbezeichnung=Allee, feedsFlatstoreEntryId=2,
	 * timestamp=1432648733, feedsEntityId=1187]
	 * 
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonParseException
	 */
	@Test
	public void testGetDenkmal() throws JsonParseException,
			JsonMappingException, IOException {

		Denkmal allee = denkmal.get(0);
		Assert.assertEquals(1, allee.denkmalnummer);
		Assert.assertEquals(50679, allee.plz);
		Assert.assertEquals("Deutz", allee.ort);

	}

}
