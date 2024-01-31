/**
 * The class IncorrectRowCountException is thrown when there is an incorrect amount of rows in the file
 */
public class IncorrectRowCountException extends Exception{
 
        public IncorrectRowCountException(String errorstring){
            super(errorstring);
        }
    
}
