package com.shoestoredb.entity3;
// Generated Apr 20, 2024, 2:20:15 PM by Hibernate Tools 4.3.6.Final


import com.shoestoredb.entity3.X.userSummaryByFileIoTypeId;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * X.userSummaryByFileIoType generated by hbm2java
 */
@Entity
@Table(name="x$user_summary_by_file_io_type"
    ,catalog="sys"
)
public class X.userSummaryByFileIoType  implements java.io.Serializable {


     private X.userSummaryByFileIoTypeId id;

    public X.userSummaryByFileIoType() {
    }

    public X.userSummaryByFileIoType(X.userSummaryByFileIoTypeId id) {
       this.id = id;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="user", column=@Column(name="user", length=32) ), 
        @AttributeOverride(name="eventName", column=@Column(name="event_name", nullable=false, length=128) ), 
        @AttributeOverride(name="total", column=@Column(name="total", nullable=false) ), 
        @AttributeOverride(name="latency", column=@Column(name="latency", nullable=false) ), 
        @AttributeOverride(name="maxLatency", column=@Column(name="max_latency", nullable=false) ) } )
    public X.userSummaryByFileIoTypeId getId() {
        return this.id;
    }
    
    public void setId(X.userSummaryByFileIoTypeId id) {
        this.id = id;
    }




}


