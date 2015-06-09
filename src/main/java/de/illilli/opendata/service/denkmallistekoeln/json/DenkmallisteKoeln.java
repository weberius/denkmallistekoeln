package de.illilli.opendata.service.denkmallistekoeln.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DenkmallisteKoeln {

	@JsonProperty("help")
	public String help;
	@JsonProperty("success")
	public boolean success;
	@JsonProperty("result")
	public Result result;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((help == null) ? 0 : help.hashCode());
		result = prime * result
				+ ((this.result == null) ? 0 : this.result.hashCode());
		result = prime * result + (success ? 1231 : 1237);
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
		DenkmallisteKoeln other = (DenkmallisteKoeln) obj;
		if (help == null) {
			if (other.help != null)
				return false;
		} else if (!help.equals(other.help))
			return false;
		if (result == null) {
			if (other.result != null)
				return false;
		} else if (!result.equals(other.result))
			return false;
		if (success != other.success)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DenkmallisteKoeln [help=" + help + ", success=" + success
				+ ", result=" + result + "]";
	}

}
