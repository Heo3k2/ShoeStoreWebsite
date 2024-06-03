package com.shoestoredb.entity3;
// Generated Apr 20, 2024, 2:20:15 PM by Hibernate Tools 4.3.6.Final

import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * SchemaTableStatisticsId generated by hbm2java
 */
@Embeddable
public class SchemaTableStatisticsId implements java.io.Serializable {

	private String tableSchema;
	private String tableName;
	private String totalLatency;
	private long rowsFetched;
	private String fetchLatency;
	private long rowsInserted;
	private String insertLatency;
	private long rowsUpdated;
	private String updateLatency;
	private long rowsDeleted;
	private String deleteLatency;
	private BigInteger ioReadRequests;
	private String ioRead;
	private String ioReadLatency;
	private BigInteger ioWriteRequests;
	private String ioWrite;
	private String ioWriteLatency;
	private BigInteger ioMiscRequests;
	private String ioMiscLatency;

	public SchemaTableStatisticsId() {
	}

	public SchemaTableStatisticsId(long rowsFetched, long rowsInserted, long rowsUpdated, long rowsDeleted) {
		this.rowsFetched = rowsFetched;
		this.rowsInserted = rowsInserted;
		this.rowsUpdated = rowsUpdated;
		this.rowsDeleted = rowsDeleted;
	}

	public SchemaTableStatisticsId(String tableSchema, String tableName, String totalLatency, long rowsFetched,
			String fetchLatency, long rowsInserted, String insertLatency, long rowsUpdated, String updateLatency,
			long rowsDeleted, String deleteLatency, BigInteger ioReadRequests, String ioRead, String ioReadLatency,
			BigInteger ioWriteRequests, String ioWrite, String ioWriteLatency, BigInteger ioMiscRequests,
			String ioMiscLatency) {
		this.tableSchema = tableSchema;
		this.tableName = tableName;
		this.totalLatency = totalLatency;
		this.rowsFetched = rowsFetched;
		this.fetchLatency = fetchLatency;
		this.rowsInserted = rowsInserted;
		this.insertLatency = insertLatency;
		this.rowsUpdated = rowsUpdated;
		this.updateLatency = updateLatency;
		this.rowsDeleted = rowsDeleted;
		this.deleteLatency = deleteLatency;
		this.ioReadRequests = ioReadRequests;
		this.ioRead = ioRead;
		this.ioReadLatency = ioReadLatency;
		this.ioWriteRequests = ioWriteRequests;
		this.ioWrite = ioWrite;
		this.ioWriteLatency = ioWriteLatency;
		this.ioMiscRequests = ioMiscRequests;
		this.ioMiscLatency = ioMiscLatency;
	}

	@Column(name = "table_schema", length = 64)
	public String getTableSchema() {
		return this.tableSchema;
	}

	public void setTableSchema(String tableSchema) {
		this.tableSchema = tableSchema;
	}

	@Column(name = "table_name", length = 64)
	public String getTableName() {
		return this.tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	@Column(name = "total_latency", length = 11)
	public String getTotalLatency() {
		return this.totalLatency;
	}

	public void setTotalLatency(String totalLatency) {
		this.totalLatency = totalLatency;
	}

	@Column(name = "rows_fetched", nullable = false)
	public long getRowsFetched() {
		return this.rowsFetched;
	}

	public void setRowsFetched(long rowsFetched) {
		this.rowsFetched = rowsFetched;
	}

	@Column(name = "fetch_latency", length = 11)
	public String getFetchLatency() {
		return this.fetchLatency;
	}

	public void setFetchLatency(String fetchLatency) {
		this.fetchLatency = fetchLatency;
	}

	@Column(name = "rows_inserted", nullable = false)
	public long getRowsInserted() {
		return this.rowsInserted;
	}

	public void setRowsInserted(long rowsInserted) {
		this.rowsInserted = rowsInserted;
	}

	@Column(name = "insert_latency", length = 11)
	public String getInsertLatency() {
		return this.insertLatency;
	}

	public void setInsertLatency(String insertLatency) {
		this.insertLatency = insertLatency;
	}

	@Column(name = "rows_updated", nullable = false)
	public long getRowsUpdated() {
		return this.rowsUpdated;
	}

	public void setRowsUpdated(long rowsUpdated) {
		this.rowsUpdated = rowsUpdated;
	}

	@Column(name = "update_latency", length = 11)
	public String getUpdateLatency() {
		return this.updateLatency;
	}

	public void setUpdateLatency(String updateLatency) {
		this.updateLatency = updateLatency;
	}

	@Column(name = "rows_deleted", nullable = false)
	public long getRowsDeleted() {
		return this.rowsDeleted;
	}

	public void setRowsDeleted(long rowsDeleted) {
		this.rowsDeleted = rowsDeleted;
	}

	@Column(name = "delete_latency", length = 11)
	public String getDeleteLatency() {
		return this.deleteLatency;
	}

	public void setDeleteLatency(String deleteLatency) {
		this.deleteLatency = deleteLatency;
	}

	@Column(name = "io_read_requests", precision = 42, scale = 0)
	public BigInteger getIoReadRequests() {
		return this.ioReadRequests;
	}

	public void setIoReadRequests(BigInteger ioReadRequests) {
		this.ioReadRequests = ioReadRequests;
	}

	@Column(name = "io_read", length = 11)
	public String getIoRead() {
		return this.ioRead;
	}

	public void setIoRead(String ioRead) {
		this.ioRead = ioRead;
	}

	@Column(name = "io_read_latency", length = 11)
	public String getIoReadLatency() {
		return this.ioReadLatency;
	}

	public void setIoReadLatency(String ioReadLatency) {
		this.ioReadLatency = ioReadLatency;
	}

	@Column(name = "io_write_requests", precision = 42, scale = 0)
	public BigInteger getIoWriteRequests() {
		return this.ioWriteRequests;
	}

	public void setIoWriteRequests(BigInteger ioWriteRequests) {
		this.ioWriteRequests = ioWriteRequests;
	}

	@Column(name = "io_write", length = 11)
	public String getIoWrite() {
		return this.ioWrite;
	}

	public void setIoWrite(String ioWrite) {
		this.ioWrite = ioWrite;
	}

	@Column(name = "io_write_latency", length = 11)
	public String getIoWriteLatency() {
		return this.ioWriteLatency;
	}

	public void setIoWriteLatency(String ioWriteLatency) {
		this.ioWriteLatency = ioWriteLatency;
	}

	@Column(name = "io_misc_requests", precision = 42, scale = 0)
	public BigInteger getIoMiscRequests() {
		return this.ioMiscRequests;
	}

	public void setIoMiscRequests(BigInteger ioMiscRequests) {
		this.ioMiscRequests = ioMiscRequests;
	}

	@Column(name = "io_misc_latency", length = 11)
	public String getIoMiscLatency() {
		return this.ioMiscLatency;
	}

	public void setIoMiscLatency(String ioMiscLatency) {
		this.ioMiscLatency = ioMiscLatency;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof SchemaTableStatisticsId))
			return false;
		SchemaTableStatisticsId castOther = (SchemaTableStatisticsId) other;

		return ((this.getTableSchema() == castOther.getTableSchema()) || (this.getTableSchema() != null
				&& castOther.getTableSchema() != null && this.getTableSchema().equals(castOther.getTableSchema())))
				&& ((this.getTableName() == castOther.getTableName()) || (this.getTableName() != null
						&& castOther.getTableName() != null && this.getTableName().equals(castOther.getTableName())))
				&& ((this.getTotalLatency() == castOther.getTotalLatency())
						|| (this.getTotalLatency() != null && castOther.getTotalLatency() != null
								&& this.getTotalLatency().equals(castOther.getTotalLatency())))
				&& (this.getRowsFetched() == castOther.getRowsFetched())
				&& ((this.getFetchLatency() == castOther.getFetchLatency())
						|| (this.getFetchLatency() != null && castOther.getFetchLatency() != null
								&& this.getFetchLatency().equals(castOther.getFetchLatency())))
				&& (this.getRowsInserted() == castOther.getRowsInserted())
				&& ((this.getInsertLatency() == castOther.getInsertLatency())
						|| (this.getInsertLatency() != null && castOther.getInsertLatency() != null
								&& this.getInsertLatency().equals(castOther.getInsertLatency())))
				&& (this.getRowsUpdated() == castOther.getRowsUpdated())
				&& ((this.getUpdateLatency() == castOther.getUpdateLatency())
						|| (this.getUpdateLatency() != null && castOther.getUpdateLatency() != null
								&& this.getUpdateLatency().equals(castOther.getUpdateLatency())))
				&& (this.getRowsDeleted() == castOther.getRowsDeleted())
				&& ((this.getDeleteLatency() == castOther.getDeleteLatency())
						|| (this.getDeleteLatency() != null && castOther.getDeleteLatency() != null
								&& this.getDeleteLatency().equals(castOther.getDeleteLatency())))
				&& ((this.getIoReadRequests() == castOther.getIoReadRequests())
						|| (this.getIoReadRequests() != null && castOther.getIoReadRequests() != null
								&& this.getIoReadRequests().equals(castOther.getIoReadRequests())))
				&& ((this.getIoRead() == castOther.getIoRead()) || (this.getIoRead() != null
						&& castOther.getIoRead() != null && this.getIoRead().equals(castOther.getIoRead())))
				&& ((this.getIoReadLatency() == castOther.getIoReadLatency())
						|| (this.getIoReadLatency() != null && castOther.getIoReadLatency() != null
								&& this.getIoReadLatency().equals(castOther.getIoReadLatency())))
				&& ((this.getIoWriteRequests() == castOther.getIoWriteRequests())
						|| (this.getIoWriteRequests() != null && castOther.getIoWriteRequests() != null
								&& this.getIoWriteRequests().equals(castOther.getIoWriteRequests())))
				&& ((this.getIoWrite() == castOther.getIoWrite()) || (this.getIoWrite() != null
						&& castOther.getIoWrite() != null && this.getIoWrite().equals(castOther.getIoWrite())))
				&& ((this.getIoWriteLatency() == castOther.getIoWriteLatency())
						|| (this.getIoWriteLatency() != null && castOther.getIoWriteLatency() != null
								&& this.getIoWriteLatency().equals(castOther.getIoWriteLatency())))
				&& ((this.getIoMiscRequests() == castOther.getIoMiscRequests())
						|| (this.getIoMiscRequests() != null && castOther.getIoMiscRequests() != null
								&& this.getIoMiscRequests().equals(castOther.getIoMiscRequests())))
				&& ((this.getIoMiscLatency() == castOther.getIoMiscLatency())
						|| (this.getIoMiscLatency() != null && castOther.getIoMiscLatency() != null
								&& this.getIoMiscLatency().equals(castOther.getIoMiscLatency())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getTableSchema() == null ? 0 : this.getTableSchema().hashCode());
		result = 37 * result + (getTableName() == null ? 0 : this.getTableName().hashCode());
		result = 37 * result + (getTotalLatency() == null ? 0 : this.getTotalLatency().hashCode());
		result = 37 * result + (int) this.getRowsFetched();
		result = 37 * result + (getFetchLatency() == null ? 0 : this.getFetchLatency().hashCode());
		result = 37 * result + (int) this.getRowsInserted();
		result = 37 * result + (getInsertLatency() == null ? 0 : this.getInsertLatency().hashCode());
		result = 37 * result + (int) this.getRowsUpdated();
		result = 37 * result + (getUpdateLatency() == null ? 0 : this.getUpdateLatency().hashCode());
		result = 37 * result + (int) this.getRowsDeleted();
		result = 37 * result + (getDeleteLatency() == null ? 0 : this.getDeleteLatency().hashCode());
		result = 37 * result + (getIoReadRequests() == null ? 0 : this.getIoReadRequests().hashCode());
		result = 37 * result + (getIoRead() == null ? 0 : this.getIoRead().hashCode());
		result = 37 * result + (getIoReadLatency() == null ? 0 : this.getIoReadLatency().hashCode());
		result = 37 * result + (getIoWriteRequests() == null ? 0 : this.getIoWriteRequests().hashCode());
		result = 37 * result + (getIoWrite() == null ? 0 : this.getIoWrite().hashCode());
		result = 37 * result + (getIoWriteLatency() == null ? 0 : this.getIoWriteLatency().hashCode());
		result = 37 * result + (getIoMiscRequests() == null ? 0 : this.getIoMiscRequests().hashCode());
		result = 37 * result + (getIoMiscLatency() == null ? 0 : this.getIoMiscLatency().hashCode());
		return result;
	}

}
