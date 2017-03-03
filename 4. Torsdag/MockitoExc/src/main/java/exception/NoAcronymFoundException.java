
package exception;


public class NoAcronymFoundException extends Exception
{

    public NoAcronymFoundException()
    {
        super("No Acronym was found!");
    }

    public NoAcronymFoundException(String message)
    {
        super(message);
    }
    
}
