
package acronym;

import exception.NoAcronymFoundException;
import java.io.IOException;
import java.net.MalformedURLException;


public interface AcronymInterface
{
    String getInitialPhrase(String Acronym) throws NoAcronymFoundException;
}
