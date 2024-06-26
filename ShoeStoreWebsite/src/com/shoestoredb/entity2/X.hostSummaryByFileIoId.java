package com.shoestoredb.entity2;
// Generated Apr 19, 2024, 5:25:59 PM by Hibernate Tools 5.6.15.Final


import java.math.BigInteger;

/**
 * X.hostSummaryByFileIoId generated by hbm2java
 */
public class X.hostSummaryByFileIoId  implements java.io.Serializable {


     private String host;
     private BigInteger ios;
     private BigInteger ioLatency;

    public X.hostSummaryByFileIoId() {
    }

    public X.hostSummaryByFileIoId(String host, BigInteger ios, BigInteger ioLatency) {
       this.host = host;
       this.ios = ios;
       this.ioLatency = ioLatency;
    }
   
    public String getHost() {
        return this.host;
    }
    
    public void setHost(String host) {
        this.host = host;
    }
    public BigInteger getIos() {
        return this.ios;
    }
    
    public void setIos(BigInteger ios) {
        this.ios = ios;
    }
    public BigInteger getIoLatency() {
        return this.ioLatency;
    }
    
    public void setIoLatency(BigInteger ioLatency) {
        this.ioLatency = ioLatency;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof X.hostSummaryByFileIoId) ) return false;
		 X.hostSummaryByFileIoId castOther = ( X.hostSummaryByFileIoId ) other; 
         
		 return ( (this.getHost()==castOther.getHost()) || ( this.getHost()!=null && castOther.getHost()!=null && this.getHost().equals(castOther.getHost()) ) )
 && ( (this.getIos()==castOther.getIos()) || ( this.getIos()!=null && castOther.getIos()!=null && this.getIos().equals(castOther.getIos()) ) )
 && ( (this.getIoLatency()==castOther.getIoLatency()) || ( this.getIoLatency()!=null && castOther.getIoLatency()!=null && this.getIoLatency().equals(castOther.getIoLatency()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getHost() == null ? 0 : this.getHost().hashCode() );
         result = 37 * result + ( getIos() == null ? 0 : this.getIos().hashCode() );
         result = 37 * result + ( getIoLatency() == null ? 0 : this.getIoLatency().hashCode() );
         return result;
   }   


}


