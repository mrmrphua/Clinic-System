package last;

import javax.swing.JOptionPane;
import ui.*;

public class StaffValidate {
    private String msg = "";
    private int c=0, d=0, e=0;
    
    public StaffValidate(String name1, String ic1,String address1,String phone1,String age1,String email1) throws InvalidException{
  
        //check name
        if(name1 == null || name1.equals("")){
            msg += "Please enter your NAME, cannot be empty.\n";
        }
        else{
            c=0;
            d=0;
            for(int a=0; a<name1.length();a++){
                if(Character.isDigit(name1.charAt(a))){
                    c++;
                }
                if(!Character.isLetterOrDigit(name1.charAt(a))){
                    d++;
                }
                if(Character.isWhitespace(name1.charAt(a))){
                    e++;
                }
            }
            
            if(c>0){
                msg += "Name cannot contain number.\n";
            }
            if((d-e)>0){
                msg += "Name cannot contain symbol.\n";
            }
            if(name1.length()>30){
                msg += "Name too long.\n";
            }
        }
        
         
        //Check ic
        if(ic1 == null || ic1.equals("")){
            msg += "Please enter ic.\n";
        }
        else{
            c=0;
            d=0;
            for(int a=0; a<ic1.length(); a++){
                if(Character.isLetter(ic1.charAt(a))){
                    c++;
                }
                if(!Character.isLetterOrDigit(ic1.charAt(a))){
                    d++;
                }
            }
            
            if(c>0){
                msg += "ic cannot accept alphabet data. Please enter a numeric data.\n";
            }
            if(d>0){
                msg += "ic cannot accept symbolic data. Please enter a numeric data.\n";
            }
            if(ic1.length()>13){
                msg += "IC too long.\n";
            }
           
        }
        
        
        //check address
        if(address1 == null || address1.equals("")){
            msg += "Please enter your ADDRESS, cannot be empty.\n";
        }
        else{
            c=0;
            d=0;
            for(int a=0; a<address1.length();a++){
                if(Character.isDigit(address1.charAt(a))){
                    c++;
                }
                if(!Character.isLetterOrDigit(address1.charAt(a))){
                    d++;
                }
                if(Character.isWhitespace(address1.charAt(a))){
                    e++;
                }
            }

            if(address1.length()>50){
                msg += "Address too long.\n";
            }
        }
        
         //Check phone
        if(phone1 == null || phone1.equals("")){
            msg += "Please enter phone number.\n";
        }
        else{
            c=0;
            d=0;
            for(int a=0; a<phone1.length(); a++){
                if(Character.isLetter(phone1.charAt(a))){
                    c++;
                }
                if(!Character.isLetterOrDigit(phone1.charAt(a))){
                    d++;
                }
            }
            
            if(c>0){
                msg += "Phone number cannot accept alphabet data. Please enter a numeric data.\n";
            }
            if(d>0){
                msg += "Phone number cannot accept symbolic data. Please enter a numeric data.\n";
            }
            if(phone1.length()>13){
                msg += "Phone number too long.\n";
            }
           
        }
        
          //Check age
        if(age1 == null || age1.equals("")){
            msg += "Please enter age.\n";
        }
        else{
            c=0;
            d=0;
            for(int a=0; a<age1.length(); a++){
                if(Character.isLetter(age1.charAt(a))){
                    c++;
                }
                if(!Character.isLetterOrDigit(age1.charAt(a))){
                    d++;
                }
            }
            
            if(c>0){
                msg += "Age cannot accept alphabet data. Please enter a numeric data.\n";
            }
            if(d>0){
                msg += "Age cannot accept symbolic data. Please enter a numeric data.\n";
            }
            if(age1.length()>4){
                msg += "Age too long.\n";
            }
           
        }
        
        //check email
        if(email1 == null || email1.equals("")){
            msg += "Please enter your Email, cannot be empty.\n";
        }
        else{
            c=0;
            d=0;
            for(int a=0; a<email1.length();a++){
                if(Character.isDigit(email1.charAt(a))){
                    c++;
                }
                if(!Character.isLetterOrDigit(email1.charAt(a))){
                    d++;
                }
                if(Character.isWhitespace(email1.charAt(a))){
                    e++;
                }
            }

            if(email1.length()>30){
                msg += "Email too long.\n";
            }
        }

             if(!msg.equals("")){
            throw new InvalidException(msg);
        }
        
    }    
        
}
