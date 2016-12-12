package last;


public class InvalidException extends Exception{
    
    public InvalidException(){
        
    }
    
    public InvalidException(String error){
        super(error);
    }
}
