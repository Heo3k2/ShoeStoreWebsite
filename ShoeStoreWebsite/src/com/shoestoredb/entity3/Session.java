package com.shoestoredb.entity3;
// Generated Apr 20, 2024, 2:20:15 PM by Hibernate Tools 4.3.6.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Session generated by hbm2java
 */
@Entity
@Table(name = "session", catalog = "sys")
public class Session implements java.io.Serializable {

	private SessionId id;

	public Session() {
	}

	public Session(SessionId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "thdId", column = @Column(name = "thd_id", nullable = false)),
			@AttributeOverride(name = "connId", column = @Column(name = "conn_id")),
			@AttributeOverride(name = "user", column = @Column(name = "user", length = 288)),
			@AttributeOverride(name = "db", column = @Column(name = "db", length = 64)),
			@AttributeOverride(name = "command", column = @Column(name = "command", length = 16)),
			@AttributeOverride(name = "state", column = @Column(name = "state", length = 64)),
			@AttributeOverride(name = "time", column = @Column(name = "time")),
			@AttributeOverride(name = "currentStatement", column = @Column(name = "current_statement")),
			@AttributeOverride(name = "executionEngine", column = @Column(name = "execution_engine", length = 9)),
			@AttributeOverride(name = "statementLatency", column = @Column(name = "statement_latency", length = 11)),
			@AttributeOverride(name = "progress", column = @Column(name = "progress", precision = 26)),
			@AttributeOverride(name = "lockLatency", column = @Column(name = "lock_latency", length = 11)),
			@AttributeOverride(name = "cpuLatency", column = @Column(name = "cpu_latency", length = 11)),
			@AttributeOverride(name = "rowsExamined", column = @Column(name = "rows_examined")),
			@AttributeOverride(name = "rowsSent", column = @Column(name = "rows_sent")),
			@AttributeOverride(name = "rowsAffected", column = @Column(name = "rows_affected")),
			@AttributeOverride(name = "tmpTables", column = @Column(name = "tmp_tables")),
			@AttributeOverride(name = "tmpDiskTables", column = @Column(name = "tmp_disk_tables")),
			@AttributeOverride(name = "fullScan", column = @Column(name = "full_scan", nullable = false, length = 3)),
			@AttributeOverride(name = "lastStatement", column = @Column(name = "last_statement")),
			@AttributeOverride(name = "lastStatementLatency", column = @Column(name = "last_statement_latency", length = 11)),
			@AttributeOverride(name = "currentMemory", column = @Column(name = "current_memory", length = 11)),
			@AttributeOverride(name = "lastWait", column = @Column(name = "last_wait", length = 128)),
			@AttributeOverride(name = "lastWaitLatency", column = @Column(name = "last_wait_latency", length = 13)),
			@AttributeOverride(name = "source", column = @Column(name = "source", length = 64)),
			@AttributeOverride(name = "trxLatency", column = @Column(name = "trx_latency", length = 11)),
			@AttributeOverride(name = "trxState", column = @Column(name = "trx_state", length = 11)),
			@AttributeOverride(name = "trxAutocommit", column = @Column(name = "trx_autocommit", length = 3)),
			@AttributeOverride(name = "pid", column = @Column(name = "pid", length = 1024)),
			@AttributeOverride(name = "programName", column = @Column(name = "program_name", length = 1024)) })
	public SessionId getId() {
		return this.id;
	}

	public void setId(SessionId id) {
		this.id = id;
	}

}
