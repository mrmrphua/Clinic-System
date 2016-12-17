package last;

import javax.swing.JOptionPane;
import ui.*;

public class PaymentValidate {
    private String msg = "";
    private int c=0, d=0, e=0;
    
    public PaymentValidate(String q) throws InvalidException{
   
        //Check unit price
        if(q == null || q.equals("")){
            msg += "Please enter Quantity.\n";
        }
        else{
              int value=Integer.parseInt(q);
         if(value<=0){
            msg += "Quantity must more than 0.\n";
        }
         
        }
       
       
          
  
             if(!msg.equals("")){
            throw new InvalidException(msg);
        }
        
    }    
        
}
