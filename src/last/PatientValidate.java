package last;

import javax.swing.JOptionPane;
import ui.*;

public class PatientValidate {
    private String msg = "";
    private int c=0, d=0, e=0;
    
    public PatientValidate(String name, String ic,String address,String phone,String age,String email) throws InvalidException{
  
        //check name
        if(name == null || name.equals("")){
            msg += "Please enter your NAME, cannot be empty.\n";
        }
        else{
            c=0;
            d=0;
            for(int a=0; a<name.length();a++){
                if(Character.isDigit(name.charAt(a))){
                    c++;
                }
                if(!Character.isLetterOrDigit(name.charAt(a))){
                    d++;
                }
                if(Character.isWhitespace(name.charAt(a))){
                    e++;
                }
            }
            
            if(c>0){
                msg += "Name cannot contain number.\n";
            }
            if((d-e)>0){
                msg += "Name cannot contain symbol.\n";
            }
            if(name.length()>30){
                msg += "Name too long.\n";
            }
        }
        
         
        //Check ic
        if(ic == null || ic.equals("")){
            msg += "Please enter ic.\n";
        }
        else{
            c=0;
            d=0;
            for(int a=0; a<ic.length(); a++){
                if(Character.isLetter(ic.charAt(a))){
                    c++;
                }
                if(!Character.isLetterOrDigit(ic.charAt(a))){
                    d++;
                }
            }
            
            if(c>0){
                msg += "ic cannot accept alphabet data. Please enter a numeric data.\n";
            }
            if(d>0){
                msg += "ic cannot accept symbolic data. Please enter a numeric data.\n";
            }
            if(ic.length()>13){
                msg += "IC too long.\n";
            }
           
        }
        
        
        //check address
        if(address == null || address.equals("")){
            msg += "Please enter your ADDRESS, cannot be empty.\n";
        }
        else{
            c=0;
            d=0;
            for(int a=0; a<address.length();a++){
                if(Character.isDigit(address.charAt(a))){
                    c++;
                }
                if(!Character.isLetterOrDigit(address.charAt(a))){
                    d++;
                }
                if(Character.isWhitespace(address.charAt(a))){
                    e++;
                }
            }

            if(address.length()>50){
                msg += "Address too long.\n";
            }
        }
        
         //Check phone
        if(phone == null || phone.equals("")){
            msg += "Please enter phone number.\n";
        }
        else{
            c=0;
            d=0;
            for(int a=0; a<phone.length(); a++){
                if(Character.isLetter(phone.charAt(a))){
                    c++;
                }
                if(!Character.isLetterOrDigit(phone.charAt(a))){
                    d++;
                }
            }
            
            if(c>0){
                msg += "Phone number cannot accept alphabet data. Please enter a numeric data.\n";
            }
            if(d>0){
                msg += "Phone number cannot accept symbolic data. Please enter a numeric data.\n";
            }
            if(phone.length()>13){
                msg += "Phone too long.\n";
            }
           
        }
        
          //Check age
        if(age == null || age.equals("")){
            msg += "Please enter age.\n";
        }
        else{
            c=0;
            d=0;
            for(int a=0; a<age.length(); a++){
                if(Character.isLetter(age.charAt(a))){
                    c++;
                }
                if(!Character.isLetterOrDigit(age.charAt(a))){
                    d++;
                }
            }
            
            if(c>0){
                msg += "Age cannot accept alphabet data. Please enter a numeric data.\n";
            }
            if(d>0){
                msg += "Age cannot accept symbolic data. Please enter a numeric data.\n";
            }
            if(age.length()>4){
                msg += "Age too long.\n";
            }
           
        }
        
        //check email
        if(email == null || email.equals("")){
            msg += "Please enter your Email, cannot be empty.\n";
        }
        else{
            c=0;
            d=0;
            for(int a=0; a<email.length();a++){
                if(Character.isDigit(email.charAt(a))){
                    c++;
                }
                if(!Character.isLetterOrDigit(email.charAt(a))){
                    d++;
                }
                if(Character.isWhitespace(email.charAt(a))){
                    e++;
                }
            }

            if(email.length()>30){
                msg += "Email too long.\n";
            }
        }

             if(!msg.equals("")){
            throw new InvalidException(msg);
        }
        
    }    
        
}
