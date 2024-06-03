package com.shoestoredb.entity2;
// Generated Apr 19, 2024, 5:25:59 PM by Hibernate Tools 5.6.15.Final


import java.util.Date;

/**
 * X.innodbLockWaitsId generated by hbm2java
 */
public class X.innodbLockWaitsId  implements java.io.Serializable {


     private Date waitStarted;
     private Date waitAge;
     private Long waitAgeSecs;
     private String lockedTable;
     private String lockedTableSchema;
     private String lockedTableName;
     private String lockedTablePartition;
     private String lockedTableSubpartition;
     private String lockedIndex;
     private String lockedType;
     private long waitingTrxId;
     private Date waitingTrxStarted;
     private Date waitingTrxAge;
     private long waitingTrxRowsLocked;
     private long waitingTrxRowsModified;
     private long waitingPid;
     private String waitingQuery;
     private String waitingLockId;
     private String waitingLockMode;
     private long blockingTrxId;
     private long blockingPid;
     private String blockingQuery;
     private String blockingLockId;
     private String blockingLockMode;
     private Date blockingTrxStarted;
     private Date blockingTrxAge;
     private long blockingTrxRowsLocked;
     private long blockingTrxRowsModified;
     private String sqlKillBlockingQuery;
     private String sqlKillBlockingConnection;

    public X.innodbLockWaitsId() {
    }

	
    public X.innodbLockWaitsId(String lockedType, long waitingTrxId, Date waitingTrxStarted, long waitingTrxRowsLocked, long waitingTrxRowsModified, long waitingPid, String waitingLockId, String waitingLockMode, long blockingTrxId, long blockingPid, String blockingLockId, String blockingLockMode, Date blockingTrxStarted, long blockingTrxRowsLocked, long blockingTrxRowsModified, String sqlKillBlockingQuery, String sqlKillBlockingConnection) {
        this.lockedType = lockedType;
        this.waitingTrxId = waitingTrxId;
        this.waitingTrxStarted = waitingTrxStarted;
        this.waitingTrxRowsLocked = waitingTrxRowsLocked;
        this.waitingTrxRowsModified = waitingTrxRowsModified;
        this.waitingPid = waitingPid;
        this.waitingLockId = waitingLockId;
        this.waitingLockMode = waitingLockMode;
        this.blockingTrxId = blockingTrxId;
        this.blockingPid = blockingPid;
        this.blockingLockId = blockingLockId;
        this.blockingLockMode = blockingLockMode;
        this.blockingTrxStarted = blockingTrxStarted;
        this.blockingTrxRowsLocked = blockingTrxRowsLocked;
        this.blockingTrxRowsModified = blockingTrxRowsModified;
        this.sqlKillBlockingQuery = sqlKillBlockingQuery;
        this.sqlKillBlockingConnection = sqlKillBlockingConnection;
    }
    public X.innodbLockWaitsId(Date waitStarted, Date waitAge, Long waitAgeSecs, String lockedTable, String lockedTableSchema, String lockedTableName, String lockedTablePartition, String lockedTableSubpartition, String lockedIndex, String lockedType, long waitingTrxId, Date waitingTrxStarted, Date waitingTrxAge, long waitingTrxRowsLocked, long waitingTrxRowsModified, long waitingPid, String waitingQuery, String waitingLockId, String waitingLockMode, long blockingTrxId, long blockingPid, String blockingQuery, String blockingLockId, String blockingLockMode, Date blockingTrxStarted, Date blockingTrxAge, long blockingTrxRowsLocked, long blockingTrxRowsModified, String sqlKillBlockingQuery, String sqlKillBlockingConnection) {
       this.waitStarted = waitStarted;
       this.waitAge = waitAge;
       this.waitAgeSecs = waitAgeSecs;
       this.lockedTable = lockedTable;
       this.lockedTableSchema = lockedTableSchema;
       this.lockedTableName = lockedTableName;
       this.lockedTablePartition = lockedTablePartition;
       this.lockedTableSubpartition = lockedTableSubpartition;
       this.lockedIndex = lockedIndex;
       this.lockedType = lockedType;
       this.waitingTrxId = waitingTrxId;
       this.waitingTrxStarted = waitingTrxStarted;
       this.waitingTrxAge = waitingTrxAge;
       this.waitingTrxRowsLocked = waitingTrxRowsLocked;
       this.waitingTrxRowsModified = waitingTrxRowsModified;
       this.waitingPid = waitingPid;
       this.waitingQuery = waitingQuery;
       this.waitingLockId = waitingLockId;
       this.waitingLockMode = waitingLockMode;
       this.blockingTrxId = blockingTrxId;
       this.blockingPid = blockingPid;
       this.blockingQuery = blockingQuery;
       this.blockingLockId = blockingLockId;
       this.blockingLockMode = blockingLockMode;
       this.blockingTrxStarted = blockingTrxStarted;
       this.blockingTrxAge = blockingTrxAge;
       this.blockingTrxRowsLocked = blockingTrxRowsLocked;
       this.blockingTrxRowsModified = blockingTrxRowsModified;
       this.sqlKillBlockingQuery = sqlKillBlockingQuery;
       this.sqlKillBlockingConnection = sqlKillBlockingConnection;
    }
   
    public Date getWaitStarted() {
        return this.waitStarted;
    }
    
    public void setWaitStarted(Date waitStarted) {
        this.waitStarted = waitStarted;
    }
    public Date getWaitAge() {
        return this.waitAge;
    }
    
    public void setWaitAge(Date waitAge) {
        this.waitAge = waitAge;
    }
    public Long getWaitAgeSecs() {
        return this.waitAgeSecs;
    }
    
    public void setWaitAgeSecs(Long waitAgeSecs) {
        this.waitAgeSecs = waitAgeSecs;
    }
    public String getLockedTable() {
        return this.lockedTable;
    }
    
    public void setLockedTable(String lockedTable) {
        this.lockedTable = lockedTable;
    }
    public String getLockedTableSchema() {
        return this.lockedTableSchema;
    }
    
    public void setLockedTableSchema(String lockedTableSchema) {
        this.lockedTableSchema = lockedTableSchema;
    }
    public String getLockedTableName() {
        return this.lockedTableName;
    }
    
    public void setLockedTableName(String lockedTableName) {
        this.lockedTableName = lockedTableName;
    }
    public String getLockedTablePartition() {
        return this.lockedTablePartition;
    }
    
    public void setLockedTablePartition(String lockedTablePartition) {
        this.lockedTablePartition = lockedTablePartition;
    }
    public String getLockedTableSubpartition() {
        return this.lockedTableSubpartition;
    }
    
    public void setLockedTableSubpartition(String lockedTableSubpartition) {
        this.lockedTableSubpartition = lockedTableSubpartition;
    }
    public String getLockedIndex() {
        return this.lockedIndex;
    }
    
    public void setLockedIndex(String lockedIndex) {
        this.lockedIndex = lockedIndex;
    }
    public String getLockedType() {
        return this.lockedType;
    }
    
    public void setLockedType(String lockedType) {
        this.lockedType = lockedType;
    }
    public long getWaitingTrxId() {
        return this.waitingTrxId;
    }
    
    public void setWaitingTrxId(long waitingTrxId) {
        this.waitingTrxId = waitingTrxId;
    }
    public Date getWaitingTrxStarted() {
        return this.waitingTrxStarted;
    }
    
    public void setWaitingTrxStarted(Date waitingTrxStarted) {
        this.waitingTrxStarted = waitingTrxStarted;
    }
    public Date getWaitingTrxAge() {
        return this.waitingTrxAge;
    }
    
    public void setWaitingTrxAge(Date waitingTrxAge) {
        this.waitingTrxAge = waitingTrxAge;
    }
    public long getWaitingTrxRowsLocked() {
        return this.waitingTrxRowsLocked;
    }
    
    public void setWaitingTrxRowsLocked(long waitingTrxRowsLocked) {
        this.waitingTrxRowsLocked = waitingTrxRowsLocked;
    }
    public long getWaitingTrxRowsModified() {
        return this.waitingTrxRowsModified;
    }
    
    public void setWaitingTrxRowsModified(long waitingTrxRowsModified) {
        this.waitingTrxRowsModified = waitingTrxRowsModified;
    }
    public long getWaitingPid() {
        return this.waitingPid;
    }
    
    public void setWaitingPid(long waitingPid) {
        this.waitingPid = waitingPid;
    }
    public String getWaitingQuery() {
        return this.waitingQuery;
    }
    
    public void setWaitingQuery(String waitingQuery) {
        this.waitingQuery = waitingQuery;
    }
    public String getWaitingLockId() {
        return this.waitingLockId;
    }
    
    public void setWaitingLockId(String waitingLockId) {
        this.waitingLockId = waitingLockId;
    }
    public String getWaitingLockMode() {
        return this.waitingLockMode;
    }
    
    public void setWaitingLockMode(String waitingLockMode) {
        this.waitingLockMode = waitingLockMode;
    }
    public long getBlockingTrxId() {
        return this.blockingTrxId;
    }
    
    public void setBlockingTrxId(long blockingTrxId) {
        this.blockingTrxId = blockingTrxId;
    }
    public long getBlockingPid() {
        return this.blockingPid;
    }
    
    public void setBlockingPid(long blockingPid) {
        this.blockingPid = blockingPid;
    }
    public String getBlockingQuery() {
        return this.blockingQuery;
    }
    
    public void setBlockingQuery(String blockingQuery) {
        this.blockingQuery = blockingQuery;
    }
    public String getBlockingLockId() {
        return this.blockingLockId;
    }
    
    public void setBlockingLockId(String blockingLockId) {
        this.blockingLockId = blockingLockId;
    }
    public String getBlockingLockMode() {
        return this.blockingLockMode;
    }
    
    public void setBlockingLockMode(String blockingLockMode) {
        this.blockingLockMode = blockingLockMode;
    }
    public Date getBlockingTrxStarted() {
        return this.blockingTrxStarted;
    }
    
    public void setBlockingTrxStarted(Date blockingTrxStarted) {
        this.blockingTrxStarted = blockingTrxStarted;
    }
    public Date getBlockingTrxAge() {
        return this.blockingTrxAge;
    }
    
    public void setBlockingTrxAge(Date blockingTrxAge) {
        this.blockingTrxAge = blockingTrxAge;
    }
    public long getBlockingTrxRowsLocked() {
        return this.blockingTrxRowsLocked;
    }
    
    public void setBlockingTrxRowsLocked(long blockingTrxRowsLocked) {
        this.blockingTrxRowsLocked = blockingTrxRowsLocked;
    }
    public long getBlockingTrxRowsModified() {
        return this.blockingTrxRowsModified;
    }
    
    public void setBlockingTrxRowsModified(long blockingTrxRowsModified) {
        this.blockingTrxRowsModified = blockingTrxRowsModified;
    }
    public String getSqlKillBlockingQuery() {
        return this.sqlKillBlockingQuery;
    }
    
    public void setSqlKillBlockingQuery(String sqlKillBlockingQuery) {
        this.sqlKillBlockingQuery = sqlKillBlockingQuery;
    }
    public String getSqlKillBlockingConnection() {
        return this.sqlKillBlockingConnection;
    }
    
    public void setSqlKillBlockingConnection(String sqlKillBlockingConnection) {
        this.sqlKillBlockingConnection = sqlKillBlockingConnection;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof X.innodbLockWaitsId) ) return false;
		 X.innodbLockWaitsId castOther = ( X.innodbLockWaitsId ) other; 
         
		 return ( (this.getWaitStarted()==castOther.getWaitStarted()) || ( this.getWaitStarted()!=null && castOther.getWaitStarted()!=null && this.getWaitStarted().equals(castOther.getWaitStarted()) ) )
 && ( (this.getWaitAge()==castOther.getWaitAge()) || ( this.getWaitAge()!=null && castOther.getWaitAge()!=null && this.getWaitAge().equals(castOther.getWaitAge()) ) )
 && ( (this.getWaitAgeSecs()==castOther.getWaitAgeSecs()) || ( this.getWaitAgeSecs()!=null && castOther.getWaitAgeSecs()!=null && this.getWaitAgeSecs().equals(castOther.getWaitAgeSecs()) ) )
 && ( (this.getLockedTable()==castOther.getLockedTable()) || ( this.getLockedTable()!=null && castOther.getLockedTable()!=null && this.getLockedTable().equals(castOther.getLockedTable()) ) )
 && ( (this.getLockedTableSchema()==castOther.getLockedTableSchema()) || ( this.getLockedTableSchema()!=null && castOther.getLockedTableSchema()!=null && this.getLockedTableSchema().equals(castOther.getLockedTableSchema()) ) )
 && ( (this.getLockedTableName()==castOther.getLockedTableName()) || ( this.getLockedTableName()!=null && castOther.getLockedTableName()!=null && this.getLockedTableName().equals(castOther.getLockedTableName()) ) )
 && ( (this.getLockedTablePartition()==castOther.getLockedTablePartition()) || ( this.getLockedTablePartition()!=null && castOther.getLockedTablePartition()!=null && this.getLockedTablePartition().equals(castOther.getLockedTablePartition()) ) )
 && ( (this.getLockedTableSubpartition()==castOther.getLockedTableSubpartition()) || ( this.getLockedTableSubpartition()!=null && castOther.getLockedTableSubpartition()!=null && this.getLockedTableSubpartition().equals(castOther.getLockedTableSubpartition()) ) )
 && ( (this.getLockedIndex()==castOther.getLockedIndex()) || ( this.getLockedIndex()!=null && castOther.getLockedIndex()!=null && this.getLockedIndex().equals(castOther.getLockedIndex()) ) )
 && ( (this.getLockedType()==castOther.getLockedType()) || ( this.getLockedType()!=null && castOther.getLockedType()!=null && this.getLockedType().equals(castOther.getLockedType()) ) )
 && (this.getWaitingTrxId()==castOther.getWaitingTrxId())
 && ( (this.getWaitingTrxStarted()==castOther.getWaitingTrxStarted()) || ( this.getWaitingTrxStarted()!=null && castOther.getWaitingTrxStarted()!=null && this.getWaitingTrxStarted().equals(castOther.getWaitingTrxStarted()) ) )
 && ( (this.getWaitingTrxAge()==castOther.getWaitingTrxAge()) || ( this.getWaitingTrxAge()!=null && castOther.getWaitingTrxAge()!=null && this.getWaitingTrxAge().equals(castOther.getWaitingTrxAge()) ) )
 && (this.getWaitingTrxRowsLocked()==castOther.getWaitingTrxRowsLocked())
 && (this.getWaitingTrxRowsModified()==castOther.getWaitingTrxRowsModified())
 && (this.getWaitingPid()==castOther.getWaitingPid())
 && ( (this.getWaitingQuery()==castOther.getWaitingQuery()) || ( this.getWaitingQuery()!=null && castOther.getWaitingQuery()!=null && this.getWaitingQuery().equals(castOther.getWaitingQuery()) ) )
 && ( (this.getWaitingLockId()==castOther.getWaitingLockId()) || ( this.getWaitingLockId()!=null && castOther.getWaitingLockId()!=null && this.getWaitingLockId().equals(castOther.getWaitingLockId()) ) )
 && ( (this.getWaitingLockMode()==castOther.getWaitingLockMode()) || ( this.getWaitingLockMode()!=null && castOther.getWaitingLockMode()!=null && this.getWaitingLockMode().equals(castOther.getWaitingLockMode()) ) )
 && (this.getBlockingTrxId()==castOther.getBlockingTrxId())
 && (this.getBlockingPid()==castOther.getBlockingPid())
 && ( (this.getBlockingQuery()==castOther.getBlockingQuery()) || ( this.getBlockingQuery()!=null && castOther.getBlockingQuery()!=null && this.getBlockingQuery().equals(castOther.getBlockingQuery()) ) )
 && ( (this.getBlockingLockId()==castOther.getBlockingLockId()) || ( this.getBlockingLockId()!=null && castOther.getBlockingLockId()!=null && this.getBlockingLockId().equals(castOther.getBlockingLockId()) ) )
 && ( (this.getBlockingLockMode()==castOther.getBlockingLockMode()) || ( this.getBlockingLockMode()!=null && castOther.getBlockingLockMode()!=null && this.getBlockingLockMode().equals(castOther.getBlockingLockMode()) ) )
 && ( (this.getBlockingTrxStarted()==castOther.getBlockingTrxStarted()) || ( this.getBlockingTrxStarted()!=null && castOther.getBlockingTrxStarted()!=null && this.getBlockingTrxStarted().equals(castOther.getBlockingTrxStarted()) ) )
 && ( (this.getBlockingTrxAge()==castOther.getBlockingTrxAge()) || ( this.getBlockingTrxAge()!=null && castOther.getBlockingTrxAge()!=null && this.getBlockingTrxAge().equals(castOther.getBlockingTrxAge()) ) )
 && (this.getBlockingTrxRowsLocked()==castOther.getBlockingTrxRowsLocked())
 && (this.getBlockingTrxRowsModified()==castOther.getBlockingTrxRowsModified())
 && ( (this.getSqlKillBlockingQuery()==castOther.getSqlKillBlockingQuery()) || ( this.getSqlKillBlockingQuery()!=null && castOther.getSqlKillBlockingQuery()!=null && this.getSqlKillBlockingQuery().equals(castOther.getSqlKillBlockingQuery()) ) )
 && ( (this.getSqlKillBlockingConnection()==castOther.getSqlKillBlockingConnection()) || ( this.getSqlKillBlockingConnection()!=null && castOther.getSqlKillBlockingConnection()!=null && this.getSqlKillBlockingConnection().equals(castOther.getSqlKillBlockingConnection()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getWaitStarted() == null ? 0 : this.getWaitStarted().hashCode() );
         result = 37 * result + ( getWaitAge() == null ? 0 : this.getWaitAge().hashCode() );
         result = 37 * result + ( getWaitAgeSecs() == null ? 0 : this.getWaitAgeSecs().hashCode() );
         result = 37 * result + ( getLockedTable() == null ? 0 : this.getLockedTable().hashCode() );
         result = 37 * result + ( getLockedTableSchema() == null ? 0 : this.getLockedTableSchema().hashCode() );
         result = 37 * result + ( getLockedTableName() == null ? 0 : this.getLockedTableName().hashCode() );
         result = 37 * result + ( getLockedTablePartition() == null ? 0 : this.getLockedTablePartition().hashCode() );
         result = 37 * result + ( getLockedTableSubpartition() == null ? 0 : this.getLockedTableSubpartition().hashCode() );
         result = 37 * result + ( getLockedIndex() == null ? 0 : this.getLockedIndex().hashCode() );
         result = 37 * result + ( getLockedType() == null ? 0 : this.getLockedType().hashCode() );
         result = 37 * result + (int) this.getWaitingTrxId();
         result = 37 * result + ( getWaitingTrxStarted() == null ? 0 : this.getWaitingTrxStarted().hashCode() );
         result = 37 * result + ( getWaitingTrxAge() == null ? 0 : this.getWaitingTrxAge().hashCode() );
         result = 37 * result + (int) this.getWaitingTrxRowsLocked();
         result = 37 * result + (int) this.getWaitingTrxRowsModified();
         result = 37 * result + (int) this.getWaitingPid();
         result = 37 * result + ( getWaitingQuery() == null ? 0 : this.getWaitingQuery().hashCode() );
         result = 37 * result + ( getWaitingLockId() == null ? 0 : this.getWaitingLockId().hashCode() );
         result = 37 * result + ( getWaitingLockMode() == null ? 0 : this.getWaitingLockMode().hashCode() );
         result = 37 * result + (int) this.getBlockingTrxId();
         result = 37 * result + (int) this.getBlockingPid();
         result = 37 * result + ( getBlockingQuery() == null ? 0 : this.getBlockingQuery().hashCode() );
         result = 37 * result + ( getBlockingLockId() == null ? 0 : this.getBlockingLockId().hashCode() );
         result = 37 * result + ( getBlockingLockMode() == null ? 0 : this.getBlockingLockMode().hashCode() );
         result = 37 * result + ( getBlockingTrxStarted() == null ? 0 : this.getBlockingTrxStarted().hashCode() );
         result = 37 * result + ( getBlockingTrxAge() == null ? 0 : this.getBlockingTrxAge().hashCode() );
         result = 37 * result + (int) this.getBlockingTrxRowsLocked();
         result = 37 * result + (int) this.getBlockingTrxRowsModified();
         result = 37 * result + ( getSqlKillBlockingQuery() == null ? 0 : this.getSqlKillBlockingQuery().hashCode() );
         result = 37 * result + ( getSqlKillBlockingConnection() == null ? 0 : this.getSqlKillBlockingConnection().hashCode() );
         return result;
   }   


}


