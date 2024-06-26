package com.shoestoredb.entity2;
// Generated Apr 19, 2024, 5:25:59 PM by Hibernate Tools 5.6.15.Final

import java.math.BigInteger;

/**
 * HostSummaryByFileIoId generated by hbm2java
 */
public class HostSummaryByFileIoId implements java.io.Serializable {

	private String host;
	private BigInteger ios;
	private String ioLatency;

	public HostSummaryByFileIoId() {
	}

	public HostSummaryByFileIoId(String host, BigInteger ios, String ioLatency) {
		this.host = host;
		this.ios = ios;
		this.ioLatency = ioLatency;
	}

	public String getHost() {
		return this.host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public BigInteger getIos() {
		return this.ios;
	}

	public void setIos(BigInteger ios) {
		this.ios = ios;
	}

	public String getIoLatency() {
		return this.ioLatency;
	}

	public void setIoLatency(String ioLatency) {
		this.ioLatency = ioLatency;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof HostSummaryByFileIoId))
			return false;
		HostSummaryByFileIoId castOther = (HostSummaryByFileIoId) other;

		return ((this.getHost() == castOther.getHost()) || (this.getHost() != null && castOther.getHost() != null
				&& this.getHost().equals(castOther.getHost())))
				&& ((this.getIos() == castOther.getIos()) || (this.getIos() != null && castOther.getIos() != null
						&& this.getIos().equals(castOther.getIos())))
				&& ((this.getIoLatency() == castOther.getIoLatency()) || (this.getIoLatency() != null
						&& castOther.getIoLatency() != null && this.getIoLatency().equals(castOther.getIoLatency())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getHost() == null ? 0 : this.getHost().hashCode());
		result = 37 * result + (getIos() == null ? 0 : this.getIos().hashCode());
		result = 37 * result + (getIoLatency() == null ? 0 : this.getIoLatency().hashCode());
		return result;
	}

}
