package com.shoestoredb.entity3;
// Generated Apr 20, 2024, 2:20:15 PM by Hibernate Tools 4.3.6.Final


import com.shoestoredb.entity3.X.memoryByThreadByCurrentBytesId;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * X.memoryByThreadByCurrentBytes generated by hbm2java
 */
@Entity
@Table(name="x$memory_by_thread_by_current_bytes"
    ,catalog="sys"
)
public class X.memoryByThreadByCurrentBytes  implements java.io.Serializable {


     private X.memoryByThreadByCurrentBytesId id;

    public X.memoryByThreadByCurrentBytes() {
    }

    public X.memoryByThreadByCurrentBytes(X.memoryByThreadByCurrentBytesId id) {
       this.id = id;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="threadId", column=@Column(name="thread_id", nullable=false) ), 
        @AttributeOverride(name="user", column=@Column(name="user", length=288) ), 
        @AttributeOverride(name="currentCountUsed", column=@Column(name="current_count_used", precision=41, scale=0) ), 
        @AttributeOverride(name="currentAllocated", column=@Column(name="current_allocated", precision=41, scale=0) ), 
        @AttributeOverride(name="currentAvgAlloc", column=@Column(name="current_avg_alloc", nullable=false, precision=45, scale=4) ), 
        @AttributeOverride(name="currentMaxAlloc", column=@Column(name="current_max_alloc") ), 
        @AttributeOverride(name="totalAllocated", column=@Column(name="total_allocated", precision=42, scale=0) ) } )
    public X.memoryByThreadByCurrentBytesId getId() {
        return this.id;
    }
    
    public void setId(X.memoryByThreadByCurrentBytesId id) {
        this.id = id;
    }




}

