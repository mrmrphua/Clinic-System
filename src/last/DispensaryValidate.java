package last;


public class DispensaryValidate {
    private String disname_msg = "";
    private String unitprice_msg = "";
    private String quantity_msg = "";
    private int c=0, d=0, e=0;
    private String disName, unitprice, quantity;
    
    public DispensaryValidate(String disName,String unitprice,String quantity) throws InvalidException{
        this.disName = disName;
        this.unitprice = unitprice;
        this.quantity =quantity;
        
        CheckName();
        CheckUnitPrice();
        CheckQuantity();
        
    }    

    public final String CheckQuantity() throws InvalidException {
        //check quantity
        if (quantity == null || quantity.equals("")) {
            quantity_msg += "Please enter quantity.\n";
        } else {
            c=0;
            d=0;
            for (int a = 0; a < quantity.length(); a++) {
                if (Character.isLetter(quantity.charAt(a))) {
                    c++;
                }
                if (!Character.isLetterOrDigit(quantity.charAt(a))) {
                    d++;
                }
            }
            if(c>0){
                quantity_msg += "Sorry, quantity cannot accept alphabet data. Please enter a numeric data.\n";
            }
            if(d>0){
                quantity_msg += "Sorry, quantity cannot accept symbolic data. Please enter a numeric data.\n";
            }
        }
        
        if(!quantity_msg.equals("")){
            throw new InvalidException(quantity_msg);
        }
        else
            return "Correct";
    }    

    public final String CheckUnitPrice() throws InvalidException {
        //Check unit price
        if (unitprice == null || unitprice.equals("")) {
            unitprice_msg += "Please enter unit price.\n";
            
        } else {
            c=0;
            d=0;
            for (int a = 0; a < unitprice.length(); a++) {
                if (Character.isLetter(unitprice.charAt(a))) {
                    c++;
                }
                if (!Character.isLetterOrDigit(unitprice.charAt(a))) {
                    d++;
                }
            }
            if(c>0){
                unitprice_msg += "Unit price, cannot accept alphabet data. Please enter a numeric data.\n";
            }
            if(d>0){
                unitprice_msg += "Unit price, cannot accept symbolic data. Please enter a numeric data.\n";
            }
        }
        
        if(!unitprice_msg.equals("")){
            throw new InvalidException(unitprice_msg);
        }
        else
            return "Correct";
    }

    public final String CheckName() throws InvalidException {
        //check name
        if (disName == null || disName.equals("")) {
            disname_msg += "Please enter your NAME, cannot be empty.\n";
        } else {
            c=0;
            d=0;
            for (int a = 0; a < disName.length(); a++) {
                if (Character.isDigit(disName.charAt(a))) {
                    c++;
                }
                if (!Character.isLetterOrDigit(disName.charAt(a))) {
                    d++;
                }
                if (Character.isWhitespace(disName.charAt(a))) {
                    e++;
                }
            }
            if(c>0){
                disname_msg += "Name cannot contain number.\n";
            }
            if((d-e)>0){
                disname_msg += "Name cannot contain symbol.\n";
            }
            if (disName.length() > 30) {
                disname_msg += "Name too long.\n";
            }
        }
        
        if(!disname_msg.equals("")){
            throw new InvalidException(disname_msg);
        }
        else
            return "Correct";
    }
        
}
