package com.shoestoredb.entity3;
// Generated Apr 20, 2024, 2:20:15 PM by Hibernate Tools 4.3.6.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * LatestFileIo generated by hbm2java
 */
@Entity
@Table(name = "latest_file_io", catalog = "sys")
public class LatestFileIo implements java.io.Serializable {

	private LatestFileIoId id;

	public LatestFileIo() {
	}

	public LatestFileIo(LatestFileIoId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "thread", column = @Column(name = "thread", length = 317)),
			@AttributeOverride(name = "file", column = @Column(name = "file", length = 512)),
			@AttributeOverride(name = "latency", column = @Column(name = "latency", length = 11)),
			@AttributeOverride(name = "operation", column = @Column(name = "operation", nullable = false, length = 32)),
			@AttributeOverride(name = "requested", column = @Column(name = "requested", length = 11)) })
	public LatestFileIoId getId() {
		return this.id;
	}

	public void setId(LatestFileIoId id) {
		this.id = id;
	}

}
