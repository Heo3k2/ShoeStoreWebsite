package com.shoestoredb.entity3;
// Generated Apr 20, 2024, 2:20:15 PM by Hibernate Tools 4.3.6.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * WaitsByUserByLatency generated by hbm2java
 */
@Entity
@Table(name = "waits_by_user_by_latency", catalog = "sys")
public class WaitsByUserByLatency implements java.io.Serializable {

	private WaitsByUserByLatencyId id;

	public WaitsByUserByLatency() {
	}

	public WaitsByUserByLatency(WaitsByUserByLatencyId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "user", column = @Column(name = "user", length = 32)),
			@AttributeOverride(name = "event", column = @Column(name = "event", nullable = false, length = 128)),
			@AttributeOverride(name = "total", column = @Column(name = "total", nullable = false)),
			@AttributeOverride(name = "totalLatency", column = @Column(name = "total_latency", length = 11)),
			@AttributeOverride(name = "avgLatency", column = @Column(name = "avg_latency", length = 11)),
			@AttributeOverride(name = "maxLatency", column = @Column(name = "max_latency", length = 11)) })
	public WaitsByUserByLatencyId getId() {
		return this.id;
	}

	public void setId(WaitsByUserByLatencyId id) {
		this.id = id;
	}

}
