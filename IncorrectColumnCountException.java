
/**
 * The IncorrectColumnCountException class is an exception thrown when the column count is incorrect in a file
 */
public class IncorrectColumnCountException extends Exception{
    
    public IncorrectColumnCountException(String errorstring){
        super(errorstring);
    }

}
