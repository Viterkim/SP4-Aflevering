
package acronym;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import exception.NoAcronymFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class AcronymFetcher
{
    public static final String URL = "http://nactem.ac.uk/software/acromine/dictionary.py";
    
    public static String getAcronym(String query) throws NoAcronymFoundException, MalformedURLException, IOException
    {
        InputStream response = new URL(URL + "?sf=" + query).openStream();
        try(Scanner scanner = new Scanner(response))
        {
            String responseBody = scanner.nextLine();
            return getAcronymFromJsonString(responseBody);
        }
    }
        
    private static String getAcronymFromJsonString(String str) throws NoAcronymFoundException
    {
        JsonArray ja = new JsonParser().parse(str).getAsJsonArray();
        if(ja.size() == 0)
        {
            throw new NoAcronymFoundException();
        }
        JsonObject je = (JsonObject) ja.get(0);
        JsonObject je2 = (JsonObject) je.getAsJsonArray("lfs").get(0);
        return je2.get("lf").getAsString();
    }
    
    public static void main(String[] args) throws Exception
    {
        System.out.println(AcronymFetcher.getAcronym("asdfadf"));
        System.out.println(AcronymFetcher.getAcronym("EU"));
        System.out.println(AcronymFetcher.getAcronym("ok")); //wtf
    }
}
