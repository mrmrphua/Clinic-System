package domain;

import java.io.Serializable;
import java.util.Objects;

public class DatabasePayment implements Serializable {
    private String code;
    private String id;
    private String sID;
    private String amount;
   

    public DatabasePayment() {
    }
    public DatabasePayment(String code,String id,String sID,String amount){
        this.code=code;
        this.id=id;
        this.sID=sID;
        this.amount = amount;
        
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setsID(String sID) {
        this.sID = sID;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCode() {
        return code;
    }

    public String getId() {
        return id;
    }

    public String getsID() {
        return sID;
    }

    public String getAmount() {
        return amount;
    }

 

   
   

     @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DatabasePayment other = (DatabasePayment) obj;
        if (!Objects.equals(this.code, other.code)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.format("%-10s %-10s %-10s %-7s", code, id,sID, amount);
    }
    
    
    
}
