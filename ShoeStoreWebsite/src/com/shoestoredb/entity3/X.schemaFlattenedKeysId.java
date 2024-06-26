package com.shoestoredb.entity3;
// Generated Apr 20, 2024, 2:20:15 PM by Hibernate Tools 4.3.6.Final


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * X.schemaFlattenedKeysId generated by hbm2java
 */
@Embeddable
public class X.schemaFlattenedKeysId  implements java.io.Serializable {


     private String tableSchema;
     private String tableName;
     private String indexName;
     private Integer nonUnique;
     private Long subpartExists;
     private String indexColumns;

    public X.schemaFlattenedKeysId() {
    }

    public X.schemaFlattenedKeysId(String tableSchema, String tableName, String indexName, Integer nonUnique, Long subpartExists, String indexColumns) {
       this.tableSchema = tableSchema;
       this.tableName = tableName;
       this.indexName = indexName;
       this.nonUnique = nonUnique;
       this.subpartExists = subpartExists;
       this.indexColumns = indexColumns;
    }
   


    @Column(name="table_schema", length=64)
    public String getTableSchema() {
        return this.tableSchema;
    }
    
    public void setTableSchema(String tableSchema) {
        this.tableSchema = tableSchema;
    }


    @Column(name="table_name", length=64)
    public String getTableName() {
        return this.tableName;
    }
    
    public void setTableName(String tableName) {
        this.tableName = tableName;
    }


    @Column(name="index_name", length=64)
    public String getIndexName() {
        return this.indexName;
    }
    
    public void setIndexName(String indexName) {
        this.indexName = indexName;
    }


    @Column(name="non_unique")
    public Integer getNonUnique() {
        return this.nonUnique;
    }
    
    public void setNonUnique(Integer nonUnique) {
        this.nonUnique = nonUnique;
    }


    @Column(name="subpart_exists")
    public Long getSubpartExists() {
        return this.subpartExists;
    }
    
    public void setSubpartExists(Long subpartExists) {
        this.subpartExists = subpartExists;
    }


    @Column(name="index_columns", length=65535)
    public String getIndexColumns() {
        return this.indexColumns;
    }
    
    public void setIndexColumns(String indexColumns) {
        this.indexColumns = indexColumns;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof X.schemaFlattenedKeysId) ) return false;
		 X.schemaFlattenedKeysId castOther = ( X.schemaFlattenedKeysId ) other; 
         
		 return ( (this.getTableSchema()==castOther.getTableSchema()) || ( this.getTableSchema()!=null && castOther.getTableSchema()!=null && this.getTableSchema().equals(castOther.getTableSchema()) ) )
 && ( (this.getTableName()==castOther.getTableName()) || ( this.getTableName()!=null && castOther.getTableName()!=null && this.getTableName().equals(castOther.getTableName()) ) )
 && ( (this.getIndexName()==castOther.getIndexName()) || ( this.getIndexName()!=null && castOther.getIndexName()!=null && this.getIndexName().equals(castOther.getIndexName()) ) )
 && ( (this.getNonUnique()==castOther.getNonUnique()) || ( this.getNonUnique()!=null && castOther.getNonUnique()!=null && this.getNonUnique().equals(castOther.getNonUnique()) ) )
 && ( (this.getSubpartExists()==castOther.getSubpartExists()) || ( this.getSubpartExists()!=null && castOther.getSubpartExists()!=null && this.getSubpartExists().equals(castOther.getSubpartExists()) ) )
 && ( (this.getIndexColumns()==castOther.getIndexColumns()) || ( this.getIndexColumns()!=null && castOther.getIndexColumns()!=null && this.getIndexColumns().equals(castOther.getIndexColumns()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getTableSchema() == null ? 0 : this.getTableSchema().hashCode() );
         result = 37 * result + ( getTableName() == null ? 0 : this.getTableName().hashCode() );
         result = 37 * result + ( getIndexName() == null ? 0 : this.getIndexName().hashCode() );
         result = 37 * result + ( getNonUnique() == null ? 0 : this.getNonUnique().hashCode() );
         result = 37 * result + ( getSubpartExists() == null ? 0 : this.getSubpartExists().hashCode() );
         result = 37 * result + ( getIndexColumns() == null ? 0 : this.getIndexColumns().hashCode() );
         return result;
   }   


}


