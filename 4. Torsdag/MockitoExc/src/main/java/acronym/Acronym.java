
package acronym;

import exception.NoAcronymFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Acronym implements AcronymInterface
{
    @Override
    public String getInitialPhrase(String acronym) throws NoAcronymFoundException
    {
        try
        {
            return AcronymFetcher.getAcronym(acronym);
        }
        catch (Exception ex)
        {
            throw new NoAcronymFoundException();
        }
    }
}

