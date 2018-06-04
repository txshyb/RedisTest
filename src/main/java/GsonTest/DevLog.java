package GsonTest;

import com.google.gson.annotations.SerializedName;

public class DevLog {
	private Integer id;
	private String logip;
	private String logport;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogip() {
		return logip;
	}

	public void setLogip(String logip) {
		this.logip = logip == null ? null : logip.trim();
	}

	public String getLogport() {
		return logport;
	}

	public void setLogport(String logport) {
		this.logport = logport == null ? null : logport.trim();
	}

	public DevLog(Integer id, String logip, String logport) {
		this.id = id;
		this.logip = logip;
		this.logport = logport;
	}

	public DevLog() {
	}

	@Override
	public String toString() {
		return "DevLog{" +
				"id=" + id +
				", logip='" + logip + '\'' +
				", logport='" + logport + '\'' +
				'}';
	}
}