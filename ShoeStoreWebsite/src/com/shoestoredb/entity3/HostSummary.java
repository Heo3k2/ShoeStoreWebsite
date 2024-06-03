package com.shoestoredb.entity3;
// Generated Apr 20, 2024, 2:20:15 PM by Hibernate Tools 4.3.6.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * HostSummary generated by hbm2java
 */
@Entity
@Table(name = "host_summary", catalog = "sys")
public class HostSummary implements java.io.Serializable {

	private HostSummaryId id;

	public HostSummary() {
	}

	public HostSummary(HostSummaryId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "host", column = @Column(name = "host")),
			@AttributeOverride(name = "statements", column = @Column(name = "statements", precision = 64, scale = 0)),
			@AttributeOverride(name = "statementLatency", column = @Column(name = "statement_latency", length = 11)),
			@AttributeOverride(name = "statementAvgLatency", column = @Column(name = "statement_avg_latency", length = 11)),
			@AttributeOverride(name = "tableScans", column = @Column(name = "table_scans", precision = 65, scale = 0)),
			@AttributeOverride(name = "fileIos", column = @Column(name = "file_ios", precision = 64, scale = 0)),
			@AttributeOverride(name = "fileIoLatency", column = @Column(name = "file_io_latency", length = 11)),
			@AttributeOverride(name = "currentConnections", column = @Column(name = "current_connections", precision = 41, scale = 0)),
			@AttributeOverride(name = "totalConnections", column = @Column(name = "total_connections", precision = 41, scale = 0)),
			@AttributeOverride(name = "uniqueUsers", column = @Column(name = "unique_users", nullable = false)),
			@AttributeOverride(name = "currentMemory", column = @Column(name = "current_memory", length = 11)),
			@AttributeOverride(name = "totalMemoryAllocated", column = @Column(name = "total_memory_allocated", length = 11)) })
	public HostSummaryId getId() {
		return this.id;
	}

	public void setId(HostSummaryId id) {
		this.id = id;
	}

}
