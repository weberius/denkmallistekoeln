package de.illilli.opendata.service.denkmallistekoeln.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * <pre>
 * "Denkmalnummer":"1",
 * "Untergruppe 1":"",
 * "Untergruppe 2":"0",
 * "Strasse":"Adolphstrasse",
 * "Nummer":"o.Nr.",
 * "Bezirk":"1",
 * "PLZ":"50679",
 * "Ort":"Deutz",
 * "unter Schutz":"01.07.1980",
 * "Baujahr Zusatz":"",
 * "Baujahr":"1910",
 * "Kurzbezeichnung":"Allee",
 * "feeds_flatstore_entry_id":"1",
 * "timestamp":"1432648733",
 * "feeds_entity_id":"1187"
 * </pre>
 *
 */
@JsonPropertyOrder({ "Denkmalnummer", "Untergruppe 1", "Untergruppe 2",
		"Strasse", "Nummer", "Bezirk", "PLZ", "Ort", "unter Schutz",
		"Baujahr Zusatz", "Baujahr", "Kurzbezeichnung",
		"feeds_flatstore_entry_id", "timestamp", "feeds_entity_id" })
public class Denkmal {

	@JsonProperty("Denkmalnummer")
	public int denkmalnummer;
	@JsonProperty("Untergruppe 1")
	public String untergruppe1;
	@JsonProperty("Untergruppe 2")
	public String untergruppe2;
	@JsonProperty("Strasse")
	public String strasse;
	@JsonProperty("Nummer")
	public String nummer;
	@JsonProperty("Bezirk")
	public int bezirk;
	@JsonProperty("PLZ")
	public int plz;
	@JsonProperty("Ort")
	public String ort;
	@JsonProperty("unter Schutz")
	public String unterSchutz;
	@JsonProperty("Baujahr Zusatz")
	public String baujahrZusatz;
	@JsonProperty("Baujahr")
	public String baujahr;
	@JsonProperty("Kurzbezeichnung")
	public String kurzbezeichnung;
	@JsonProperty("feeds_flatstore_entry_id")
	public int feedsFlatstoreEntryId;
	@JsonProperty("timestamp")
	public long timestamp;
	@JsonProperty("feeds_entity_id")
	public int feedsEntityId;

	@Override
	public String toString() {
		return "Denkmal [denkmalnummer=" + denkmalnummer + ", untergruppe1="
				+ untergruppe1 + ", untergruppe2=" + untergruppe2
				+ ", strasse=" + strasse + ", nummer=" + nummer + ", bezirk="
				+ bezirk + ", plz=" + plz + ", ort=" + ort + ", unterSchutz="
				+ unterSchutz + ", baujahrZusatz=" + baujahrZusatz
				+ ", baujahr=" + baujahr + ", kurzbezeichnung="
				+ kurzbezeichnung + ", feedsFlatstoreEntryId="
				+ feedsFlatstoreEntryId + ", timestamp=" + timestamp
				+ ", feedsEntityId=" + feedsEntityId + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((baujahr == null) ? 0 : baujahr.hashCode());
		result = prime * result
				+ ((baujahrZusatz == null) ? 0 : baujahrZusatz.hashCode());
		result = prime * result + bezirk;
		result = prime * result + denkmalnummer;
		result = prime * result + feedsEntityId;
		result = prime * result + feedsFlatstoreEntryId;
		result = prime * result
				+ ((kurzbezeichnung == null) ? 0 : kurzbezeichnung.hashCode());
		result = prime * result + ((nummer == null) ? 0 : nummer.hashCode());
		result = prime * result + ((ort == null) ? 0 : ort.hashCode());
		result = prime * result + plz;
		result = prime * result + ((strasse == null) ? 0 : strasse.hashCode());
		result = prime * result + (int) (timestamp ^ (timestamp >>> 32));
		result = prime * result
				+ ((unterSchutz == null) ? 0 : unterSchutz.hashCode());
		result = prime * result
				+ ((untergruppe1 == null) ? 0 : untergruppe1.hashCode());
		result = prime * result
				+ ((untergruppe2 == null) ? 0 : untergruppe2.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Denkmal other = (Denkmal) obj;
		if (baujahr == null) {
			if (other.baujahr != null)
				return false;
		} else if (!baujahr.equals(other.baujahr))
			return false;
		if (baujahrZusatz == null) {
			if (other.baujahrZusatz != null)
				return false;
		} else if (!baujahrZusatz.equals(other.baujahrZusatz))
			return false;
		if (bezirk != other.bezirk)
			return false;
		if (denkmalnummer != other.denkmalnummer)
			return false;
		if (feedsEntityId != other.feedsEntityId)
			return false;
		if (feedsFlatstoreEntryId != other.feedsFlatstoreEntryId)
			return false;
		if (kurzbezeichnung == null) {
			if (other.kurzbezeichnung != null)
				return false;
		} else if (!kurzbezeichnung.equals(other.kurzbezeichnung))
			return false;
		if (nummer == null) {
			if (other.nummer != null)
				return false;
		} else if (!nummer.equals(other.nummer))
			return false;
		if (ort == null) {
			if (other.ort != null)
				return false;
		} else if (!ort.equals(other.ort))
			return false;
		if (plz != other.plz)
			return false;
		if (strasse == null) {
			if (other.strasse != null)
				return false;
		} else if (!strasse.equals(other.strasse))
			return false;
		if (timestamp != other.timestamp)
			return false;
		if (unterSchutz == null) {
			if (other.unterSchutz != null)
				return false;
		} else if (!unterSchutz.equals(other.unterSchutz))
			return false;
		if (untergruppe1 == null) {
			if (other.untergruppe1 != null)
				return false;
		} else if (!untergruppe1.equals(other.untergruppe1))
			return false;
		if (untergruppe2 == null) {
			if (other.untergruppe2 != null)
				return false;
		} else if (!untergruppe2.equals(other.untergruppe2))
			return false;
		return true;
	}

}
