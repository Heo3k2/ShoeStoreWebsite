package com.shoestoredb.entity3;
// Generated Apr 20, 2024, 2:20:15 PM by Hibernate Tools 4.3.6.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * SchemaTableStatistics generated by hbm2java
 */
@Entity
@Table(name = "schema_table_statistics", catalog = "sys")
public class SchemaTableStatistics implements java.io.Serializable {

	private SchemaTableStatisticsId id;

	public SchemaTableStatistics() {
	}

	public SchemaTableStatistics(SchemaTableStatisticsId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "tableSchema", column = @Column(name = "table_schema", length = 64)),
			@AttributeOverride(name = "tableName", column = @Column(name = "table_name", length = 64)),
			@AttributeOverride(name = "totalLatency", column = @Column(name = "total_latency", length = 11)),
			@AttributeOverride(name = "rowsFetched", column = @Column(name = "rows_fetched", nullable = false)),
			@AttributeOverride(name = "fetchLatency", column = @Column(name = "fetch_latency", length = 11)),
			@AttributeOverride(name = "rowsInserted", column = @Column(name = "rows_inserted", nullable = false)),
			@AttributeOverride(name = "insertLatency", column = @Column(name = "insert_latency", length = 11)),
			@AttributeOverride(name = "rowsUpdated", column = @Column(name = "rows_updated", nullable = false)),
			@AttributeOverride(name = "updateLatency", column = @Column(name = "update_latency", length = 11)),
			@AttributeOverride(name = "rowsDeleted", column = @Column(name = "rows_deleted", nullable = false)),
			@AttributeOverride(name = "deleteLatency", column = @Column(name = "delete_latency", length = 11)),
			@AttributeOverride(name = "ioReadRequests", column = @Column(name = "io_read_requests", precision = 42, scale = 0)),
			@AttributeOverride(name = "ioRead", column = @Column(name = "io_read", length = 11)),
			@AttributeOverride(name = "ioReadLatency", column = @Column(name = "io_read_latency", length = 11)),
			@AttributeOverride(name = "ioWriteRequests", column = @Column(name = "io_write_requests", precision = 42, scale = 0)),
			@AttributeOverride(name = "ioWrite", column = @Column(name = "io_write", length = 11)),
			@AttributeOverride(name = "ioWriteLatency", column = @Column(name = "io_write_latency", length = 11)),
			@AttributeOverride(name = "ioMiscRequests", column = @Column(name = "io_misc_requests", precision = 42, scale = 0)),
			@AttributeOverride(name = "ioMiscLatency", column = @Column(name = "io_misc_latency", length = 11)) })
	public SchemaTableStatisticsId getId() {
		return this.id;
	}

	public void setId(SchemaTableStatisticsId id) {
		this.id = id;
	}

}
