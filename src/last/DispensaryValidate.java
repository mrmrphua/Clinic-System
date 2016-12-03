package last;

import javax.swing.JOptionPane;
import ui.*;

public class DispensaryValidate {
    private String msg = "";
    private int c=0, d=0, e=0;
    
    public DispensaryValidate(String disName,String unitprice,String quantity) throws InvalidException{
  
        //check name
        if(disName == null || disName.equals("")){
            msg += "Please enter your NAME, cannot be empty.\n";
        }
        else{
            c=0;
            d=0;
            for(int a=0; a<disName.length();a++){
                if(Character.isDigit(disName.charAt(a))){
                    c++;
                }
                if(!Character.isLetterOrDigit(disName.charAt(a))){
                    d++;
                }
                if(Character.isWhitespace(disName.charAt(a))){
                    e++;
                }
            }
            
            if(c>0){
                msg += "Name cannot contain number.\n";
            }
            if((d-e)>0){
                msg += "Name cannot contain symbol.\n";
            }
            if(disName.length()>30){
                msg += "Name too long.\n";
            }
        }
        
         
        //Check unit price
        if(unitprice == null || unitprice.equals("")){
            msg += "Please enter unit price.\n";
        }
        else{
            c=0;
            d=0;
            for(int a=0; a<unitprice.length(); a++){
                if(Character.isLetter(unitprice.charAt(a))){
                    c++;
                }
                if(!Character.isLetterOrDigit(unitprice.charAt(a))){
                    d++;
                }
            }
            
            if(c>0){
                msg += "Unit price, cannot accept alphabet data. Please enter a numeric data.\n";
            }
            if(d>0){
                msg += "Unit price, cannot accept symbolic data. Please enter a numeric data.\n";
            }
           
        }
        
        
        //check quantity
         if(quantity == null || quantity.equals("")){
            msg += "Please enter quantity.\n";
        }
        else{
            c=0;
            d=0;
            for(int a=0; a<quantity.length(); a++){
                if(Character.isLetter(quantity.charAt(a))){
                    c++;
                }
                if(!Character.isLetterOrDigit(quantity.charAt(a))){
                    d++;
                }
            }
            
            if(c>0){
                msg += "Sorry, quantity cannot accept alphabet data. Please enter a numeric data.\n";
            }
            if(d>0){
                msg += "Sorry, quantity cannot accept symbolic data. Please enter a numeric data.\n";
            }
           
        }

             if(!msg.equals("")){
            throw new InvalidException(msg);
        }
        
    }    
        
}
