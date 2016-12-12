package domain;

import java.io.Serializable;
import java.util.Objects;

public class DatabaseDispensary implements Serializable {
    private String DisID;
    private String DisName;
    private String DisUsage;
    private String UnitPrice;
    private String Quantity;
   

    public DatabaseDispensary() {
    }
    public DatabaseDispensary(String disID,String disName,String unitprice,String quantity,String disUsage){
        this.DisID=disID;
        this.DisName=disName;
        this.DisUsage=disUsage;
        this.UnitPrice=unitprice;
        this.Quantity = quantity;
        
    }

   public void setDisID(String disID){
       this.DisID=disID;
   }
    public String getDisID() {
        return DisID;
    }
      public void setDisName(String disName){
       this.DisName=disName;
   }
      
    public String getDisName() {
        return DisName;
    }
    
    
    public void setDisUsage(String disUsage){
       this.DisUsage=disUsage;
   }
    
    public String getDisUsage() {
        return DisUsage;
    }
    
      public void setUnitPrice(String unitprice){
       this.UnitPrice=unitprice;
   }
    public String getUnitPrice() {
        return UnitPrice;
    }

    public void setQuantity(String quantity){
        this.Quantity=quantity;
    }
    public String getQuantity(){
        return Quantity;
    }
   

     @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DatabaseDispensary other = (DatabaseDispensary) obj;
        if (!Objects.equals(this.DisID, other.DisID)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.format("%-10s %-30s %-7s %-7s", DisID, DisName, UnitPrice, Quantity);
    }
    
    
    
}
