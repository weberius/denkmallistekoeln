package de.illilli.opendata.koeln.json;

import java.io.IOException;
import java.io.InputStream;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import de.illilli.opendata.service.denkmallistekoeln.json.Denkmal;

/**
 * IT'S NOT WORKIN
 */
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

	public AskForDenkmallisteKoelnCsv(InputStream inputStream)
			throws IOException {

		CsvMapper mapper = new CsvMapper();
		CsvSchema schema = mapper.schemaFor(Denkmal.class);
		schema.withColumnSeparator(';');

		MappingIterator<Denkmal> it = mapper.reader(Denkmal.class).with(schema)
				.readValues(inputStream);

		while (it.hasNextValue()) {
			try {
				Denkmal denkmal = it.nextValue();
				denkmalListe.add(denkmal);
			} catch (JsonParseException e) {
				e.printStackTrace();
			}
		}

	}

}
