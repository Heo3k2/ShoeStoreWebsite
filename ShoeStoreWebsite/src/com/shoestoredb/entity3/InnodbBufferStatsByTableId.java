package com.shoestoredb.entity3;
// Generated Apr 20, 2024, 2:20:15 PM by Hibernate Tools 4.3.6.Final

import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * InnodbBufferStatsByTableId generated by hbm2java
 */
@Embeddable
public class InnodbBufferStatsByTableId implements java.io.Serializable {

	private String objectSchema;
	private String objectName;
	private String allocated;
	private String data;
	private long pages;
	private long pagesHashed;
	private long pagesOld;
	private BigInteger rowsCached;

	public InnodbBufferStatsByTableId() {
	}

	public InnodbBufferStatsByTableId(long pages, long pagesHashed, long pagesOld) {
		this.pages = pages;
		this.pagesHashed = pagesHashed;
		this.pagesOld = pagesOld;
	}

	public InnodbBufferStatsByTableId(String objectSchema, String objectName, String allocated, String data, long pages,
			long pagesHashed, long pagesOld, BigInteger rowsCached) {
		this.objectSchema = objectSchema;
		this.objectName = objectName;
		this.allocated = allocated;
		this.data = data;
		this.pages = pages;
		this.pagesHashed = pagesHashed;
		this.pagesOld = pagesOld;
		this.rowsCached = rowsCached;
	}

	@Column(name = "object_schema", length = 65535)
	public String getObjectSchema() {
		return this.objectSchema;
	}

	public void setObjectSchema(String objectSchema) {
		this.objectSchema = objectSchema;
	}

	@Column(name = "object_name", length = 65535)
	public String getObjectName() {
		return this.objectName;
	}

	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}

	@Column(name = "allocated", length = 11)
	public String getAllocated() {
		return this.allocated;
	}

	public void setAllocated(String allocated) {
		this.allocated = allocated;
	}

	@Column(name = "data", length = 11)
	public String getData() {
		return this.data;
	}

	public void setData(String data) {
		this.data = data;
	}

	@Column(name = "pages", nullable = false)
	public long getPages() {
		return this.pages;
	}

	public void setPages(long pages) {
		this.pages = pages;
	}

	@Column(name = "pages_hashed", nullable = false)
	public long getPagesHashed() {
		return this.pagesHashed;
	}

	public void setPagesHashed(long pagesHashed) {
		this.pagesHashed = pagesHashed;
	}

	@Column(name = "pages_old", nullable = false)
	public long getPagesOld() {
		return this.pagesOld;
	}

	public void setPagesOld(long pagesOld) {
		this.pagesOld = pagesOld;
	}

	@Column(name = "rows_cached", precision = 45, scale = 0)
	public BigInteger getRowsCached() {
		return this.rowsCached;
	}

	public void setRowsCached(BigInteger rowsCached) {
		this.rowsCached = rowsCached;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof InnodbBufferStatsByTableId))
			return false;
		InnodbBufferStatsByTableId castOther = (InnodbBufferStatsByTableId) other;

		return ((this.getObjectSchema() == castOther.getObjectSchema()) || (this.getObjectSchema() != null
				&& castOther.getObjectSchema() != null && this.getObjectSchema().equals(castOther.getObjectSchema())))
				&& ((this.getObjectName() == castOther.getObjectName()) || (this.getObjectName() != null
						&& castOther.getObjectName() != null && this.getObjectName().equals(castOther.getObjectName())))
				&& ((this.getAllocated() == castOther.getAllocated()) || (this.getAllocated() != null
						&& castOther.getAllocated() != null && this.getAllocated().equals(castOther.getAllocated())))
				&& ((this.getData() == castOther.getData()) || (this.getData() != null && castOther.getData() != null
						&& this.getData().equals(castOther.getData())))
				&& (this.getPages() == castOther.getPages()) && (this.getPagesHashed() == castOther.getPagesHashed())
				&& (this.getPagesOld() == castOther.getPagesOld())
				&& ((this.getRowsCached() == castOther.getRowsCached())
						|| (this.getRowsCached() != null && castOther.getRowsCached() != null
								&& this.getRowsCached().equals(castOther.getRowsCached())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getObjectSchema() == null ? 0 : this.getObjectSchema().hashCode());
		result = 37 * result + (getObjectName() == null ? 0 : this.getObjectName().hashCode());
		result = 37 * result + (getAllocated() == null ? 0 : this.getAllocated().hashCode());
		result = 37 * result + (getData() == null ? 0 : this.getData().hashCode());
		result = 37 * result + (int) this.getPages();
		result = 37 * result + (int) this.getPagesHashed();
		result = 37 * result + (int) this.getPagesOld();
		result = 37 * result + (getRowsCached() == null ? 0 : this.getRowsCached().hashCode());
		return result;
	}

}
