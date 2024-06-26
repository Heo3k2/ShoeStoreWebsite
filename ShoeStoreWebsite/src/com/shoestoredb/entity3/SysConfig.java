package com.shoestoredb.entity3;
// Generated Apr 20, 2024, 2:20:15 PM by Hibernate Tools 4.3.6.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * SysConfig generated by hbm2java
 */
@Entity
@Table(name = "sys_config", catalog = "sys")
public class SysConfig implements java.io.Serializable {

	private String variable;
	private String value;
	private Date setTime;
	private String setBy;

	public SysConfig() {
	}

	public SysConfig(String variable) {
		this.variable = variable;
	}

	public SysConfig(String variable, String value, Date setTime, String setBy) {
		this.variable = variable;
		this.value = value;
		this.setTime = setTime;
		this.setBy = setBy;
	}

	@Id

	@Column(name = "variable", unique = true, nullable = false, length = 128)
	public String getVariable() {
		return this.variable;
	}

	public void setVariable(String variable) {
		this.variable = variable;
	}

	@Column(name = "value", length = 128)
	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "set_time", length = 19)
	public Date getSetTime() {
		return this.setTime;
	}

	public void setSetTime(Date setTime) {
		this.setTime = setTime;
	}

	@Column(name = "set_by", length = 128)
	public String getSetBy() {
		return this.setBy;
	}

	public void setSetBy(String setBy) {
		this.setBy = setBy;
	}

}
