package de.illilli.opendata.service.denkmallistekoeln.json;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Result {

	@JsonProperty("fields")
	public Field[] fields;
	@JsonProperty("resource_id")
	public String[] resource_id;
	@JsonProperty("limit")
	public int limit;
	@JsonProperty("total")
	public int total;
	@JsonProperty("")
	public Denkmal[] records;

	@Override
	public String toString() {
		return "Result [fields=" + Arrays.toString(fields) + ", resource_id="
				+ Arrays.toString(resource_id) + ", limit=" + limit
				+ ", total=" + total + ", records=" + Arrays.toString(records)
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(fields);
		result = prime * result + limit;
		result = prime * result + Arrays.hashCode(records);
		result = prime * result + Arrays.hashCode(resource_id);
		result = prime * result + total;
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
		Result other = (Result) obj;
		if (!Arrays.equals(fields, other.fields))
			return false;
		if (limit != other.limit)
			return false;
		if (!Arrays.equals(records, other.records))
			return false;
		if (!Arrays.equals(resource_id, other.resource_id))
			return false;
		if (total != other.total)
			return false;
		return true;
	}

}
