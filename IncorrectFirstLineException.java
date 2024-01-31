/**
 * The IncorrectFirstLineException class is thrown when the first line of the file is not formatted properly
 * (There are too many integers, the object is not an integer, there are not enough integers)
 */
public class IncorrectFirstLineException extends Exception{
   
    public IncorrectFirstLineException(String errorstring){
        super(errorstring);
    }
}
