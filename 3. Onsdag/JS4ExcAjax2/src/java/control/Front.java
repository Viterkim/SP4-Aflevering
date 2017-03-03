
package control;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.Person;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;


@WebServlet(name = "Front", urlPatterns =
{
    "/Front"
})
public class Front extends HttpServlet
{
    private static Gson gson;
    private static Person[] startPeople = {new Person("Viktor", "Bingo"), new Person("Håndbold", "Fuglen"), new Person("Cirkus", "Jøden"), new Person("Computer", "Katten")};
    private static ArrayList<Person> people;

    public Front()
    {
        if(people == null)
        {
            people = new ArrayList<>(Arrays.asList(startPeople));
        }
        if(gson == null)
        {
            this.gson = new GsonBuilder().create();
        }
    }
    
    private void addPerson(String perStr)
    {
        Person p = gson.fromJson(perStr, Person.class);
        people.add(p);
    }
    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter())
        {
            int index = new Random().nextInt(people.size());
            String str = gson.toJson(people.get(index));
            out.println(str);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        try (PrintWriter out = response.getWriter()) 
        {
            BufferedReader reader = request.getReader();
            Person p = gson.fromJson(reader.readLine(), Person.class);
            people.add(p);
            out.println("Added " + p.getFirstName() + " to the list!");
        }   
    }

}
