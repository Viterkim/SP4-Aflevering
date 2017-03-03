
package acronym;

import exception.NoAcronymFoundException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;


public class AcronymTest
{

    
    public AcronymTest()
    {
    }
    
    @BeforeClass
    public static void setUpClass()
    {
    }
    
    @AfterClass
    public static void tearDownClass()
    {
    }
    
    @Before
    public void setUp()
    {
    }
    
    @After
    public void tearDown()
    {
    }

    @Test
    public void mockedTestGetInitialPhrase() throws NoAcronymFoundException
    {
        System.out.println("mockedGetInitialPhrase");
        Acronym acro = Mockito.mock(Acronym.class);
        when(acro.getInitialPhrase("NATO")).thenReturn("North Atlantic Treaty Organization");
        String acronym = "NATO";
        String expResult = "North Atlantic Treaty Organization";
        String result = acro.getInitialPhrase(acronym);
        assertEquals(expResult, result);
    }
    
    @Test(expected=NoAcronymFoundException.class)
    public void mockedTestNoAcronymFoundException()  throws NoAcronymFoundException
    {
        System.out.println("mockedNoAcronymFound");
        Acronym acro = Mockito.mock(Acronym.class);
        when(acro.getInitialPhrase("LORT")).thenThrow(new NoAcronymFoundException("From mockito"));
        String acronym = "LORT";
        String result = acro.getInitialPhrase(acronym);
    }
    
    @Test
    public void testGetInitialPhrase() throws NoAcronymFoundException
    {
        System.out.println("getInitialPhrase");
        String acronym = "NATO";
        Acronym instance = new Acronym();
        String expResult = "North Atlantic Treaty Organization";
        String result = instance.getInitialPhrase(acronym);
        assertEquals(expResult, result);
    }
    
    @Test(expected=NoAcronymFoundException.class)
    public void testNoAcronymFoundException() throws NoAcronymFoundException
    {
        System.out.println("noAcronymFound");
        String acronym = "bingo";
        Acronym instance = new Acronym();
        String expResult = "";
        String result = instance.getInitialPhrase(acronym);
    }
}
