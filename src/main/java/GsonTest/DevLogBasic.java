package GsonTest;

import com.google.gson.annotations.SerializedName;

public class DevLogBasic {
	private String type;

	private String logip;

	private String logport;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLogip() {
		return logip;
	}

	public void setLogip(String logip) {
		this.logip = logip;
	}

	public String getLogport() {
		return logport;
	}

	public void setLogport(String logport) {
		this.logport = logport;
	}

	@Override
	public String toString() {
		return "DevLogBasic{" +
				"type='" + type + '\'' +
				", logip='" + logip + '\'' +
				", logport='" + logport + '\'' +
				'}';
	}
}
