package com.shoestoredb.entity2;
// Generated Apr 19, 2024, 5:25:59 PM by Hibernate Tools 5.6.15.Final



/**
 * X.schemaIndexStatisticsId generated by hbm2java
 */
public class X.schemaIndexStatisticsId  implements java.io.Serializable {


     private String tableSchema;
     private String tableName;
     private String indexName;
     private long rowsSelected;
     private long selectLatency;
     private long rowsInserted;
     private long insertLatency;
     private long rowsUpdated;
     private long updateLatency;
     private long rowsDeleted;
     private long deleteLatency;

    public X.schemaIndexStatisticsId() {
    }

	
    public X.schemaIndexStatisticsId(long rowsSelected, long selectLatency, long rowsInserted, long insertLatency, long rowsUpdated, long updateLatency, long rowsDeleted, long deleteLatency) {
        this.rowsSelected = rowsSelected;
        this.selectLatency = selectLatency;
        this.rowsInserted = rowsInserted;
        this.insertLatency = insertLatency;
        this.rowsUpdated = rowsUpdated;
        this.updateLatency = updateLatency;
        this.rowsDeleted = rowsDeleted;
        this.deleteLatency = deleteLatency;
    }
    public X.schemaIndexStatisticsId(String tableSchema, String tableName, String indexName, long rowsSelected, long selectLatency, long rowsInserted, long insertLatency, long rowsUpdated, long updateLatency, long rowsDeleted, long deleteLatency) {
       this.tableSchema = tableSchema;
       this.tableName = tableName;
       this.indexName = indexName;
       this.rowsSelected = rowsSelected;
       this.selectLatency = selectLatency;
       this.rowsInserted = rowsInserted;
       this.insertLatency = insertLatency;
       this.rowsUpdated = rowsUpdated;
       this.updateLatency = updateLatency;
       this.rowsDeleted = rowsDeleted;
       this.deleteLatency = deleteLatency;
    }
   
    public String getTableSchema() {
        return this.tableSchema;
    }
    
    public void setTableSchema(String tableSchema) {
        this.tableSchema = tableSchema;
    }
    public String getTableName() {
        return this.tableName;
    }
    
    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
    public String getIndexName() {
        return this.indexName;
    }
    
    public void setIndexName(String indexName) {
        this.indexName = indexName;
    }
    public long getRowsSelected() {
        return this.rowsSelected;
    }
    
    public void setRowsSelected(long rowsSelected) {
        this.rowsSelected = rowsSelected;
    }
    public long getSelectLatency() {
        return this.selectLatency;
    }
    
    public void setSelectLatency(long selectLatency) {
        this.selectLatency = selectLatency;
    }
    public long getRowsInserted() {
        return this.rowsInserted;
    }
    
    public void setRowsInserted(long rowsInserted) {
        this.rowsInserted = rowsInserted;
    }
    public long getInsertLatency() {
        return this.insertLatency;
    }
    
    public void setInsertLatency(long insertLatency) {
        this.insertLatency = insertLatency;
    }
    public long getRowsUpdated() {
        return this.rowsUpdated;
    }
    
    public void setRowsUpdated(long rowsUpdated) {
        this.rowsUpdated = rowsUpdated;
    }
    public long getUpdateLatency() {
        return this.updateLatency;
    }
    
    public void setUpdateLatency(long updateLatency) {
        this.updateLatency = updateLatency;
    }
    public long getRowsDeleted() {
        return this.rowsDeleted;
    }
    
    public void setRowsDeleted(long rowsDeleted) {
        this.rowsDeleted = rowsDeleted;
    }
    public long getDeleteLatency() {
        return this.deleteLatency;
    }
    
    public void setDeleteLatency(long deleteLatency) {
        this.deleteLatency = deleteLatency;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof X.schemaIndexStatisticsId) ) return false;
		 X.schemaIndexStatisticsId castOther = ( X.schemaIndexStatisticsId ) other; 
         
		 return ( (this.getTableSchema()==castOther.getTableSchema()) || ( this.getTableSchema()!=null && castOther.getTableSchema()!=null && this.getTableSchema().equals(castOther.getTableSchema()) ) )
 && ( (this.getTableName()==castOther.getTableName()) || ( this.getTableName()!=null && castOther.getTableName()!=null && this.getTableName().equals(castOther.getTableName()) ) )
 && ( (this.getIndexName()==castOther.getIndexName()) || ( this.getIndexName()!=null && castOther.getIndexName()!=null && this.getIndexName().equals(castOther.getIndexName()) ) )
 && (this.getRowsSelected()==castOther.getRowsSelected())
 && (this.getSelectLatency()==castOther.getSelectLatency())
 && (this.getRowsInserted()==castOther.getRowsInserted())
 && (this.getInsertLatency()==castOther.getInsertLatency())
 && (this.getRowsUpdated()==castOther.getRowsUpdated())
 && (this.getUpdateLatency()==castOther.getUpdateLatency())
 && (this.getRowsDeleted()==castOther.getRowsDeleted())
 && (this.getDeleteLatency()==castOther.getDeleteLatency());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getTableSchema() == null ? 0 : this.getTableSchema().hashCode() );
         result = 37 * result + ( getTableName() == null ? 0 : this.getTableName().hashCode() );
         result = 37 * result + ( getIndexName() == null ? 0 : this.getIndexName().hashCode() );
         result = 37 * result + (int) this.getRowsSelected();
         result = 37 * result + (int) this.getSelectLatency();
         result = 37 * result + (int) this.getRowsInserted();
         result = 37 * result + (int) this.getInsertLatency();
         result = 37 * result + (int) this.getRowsUpdated();
         result = 37 * result + (int) this.getUpdateLatency();
         result = 37 * result + (int) this.getRowsDeleted();
         result = 37 * result + (int) this.getDeleteLatency();
         return result;
   }   


}

