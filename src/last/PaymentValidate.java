package last;

public final class PaymentValidate {
    private String msg = "";
    private int c=0, d=0, e=0;
    private final String unitprice;
    
    public PaymentValidate(String unitprice) throws InvalidException{
        this.unitprice = unitprice;
        CheckUnitPrice();
        
    }    

    public String CheckUnitPrice() throws NumberFormatException, InvalidException {
        //Check unit price
        msg = "";
        if(unitprice == null || unitprice.equals("")){
            msg += "Please enter Quantity.\n";
        }
        else{
            int value=Integer.parseInt(unitprice);
            if(value<=0){
                msg += "Quantity must more than 0.\n";
            }
            
        }
        
        
        if(!msg.equals("")){
            throw new InvalidException(msg);
        }
        else
            return "Correct";
    }
        
}
