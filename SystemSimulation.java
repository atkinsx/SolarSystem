import java.awt.event.*;
import javax.swing.*;

public class SystemSimulation extends SolarSystem
{
    private final int MAX_NO_OF_ENTITIES;
    
    private CelestialBody[] entities;
    private DBReader reader;
    private int noOfEntities;
    private int noOfMoons;
    private int noOfPlanets;
    private int noOfStars;
    private String systemName;
    
    public SystemSimulation(int width, int height, String systemName)
    {
        super(width, height);
        this.systemName = systemName;

        MAX_NO_OF_ENTITIES = 1000;

        this.connectToDatabase();
        this.initialiseSystem();
        reader.closeConnection();

        this.drawSystem();
    }

    public void connectToDatabase()
    {
        boolean hasConnected = false;
        
        reader = new DBReader(systemName);
        hasConnected = reader.connect();

        if (!hasConnected)
        {
            String input = "No database found. Closing program.";
            forceQuit(input);
        }
    }

    public void initialiseSystem()
    {
        noOfStars = reader.getNoOfRecords("Star");
        noOfPlanets = reader.getNoOfRecords("Planet");
        noOfMoons = reader.getNoOfRecords("Moon");//193;
        entities = new CelestialBody[MAX_NO_OF_ENTITIES];

        createEntities();

        // //79 moons around Jupiter
        // //62 moons around Saturn
        // //27 moons around Uranus
        // //14 moons around Neptune
    }

    public void createEntities()
    {
        if (reader.doesTableExist("Star"))
        {
            for (int i = 0; i < noOfStars; i++)
            {
                createNewStar(i+1);
            }
        }

        if (reader.doesTableExist("Planet"))
        {
            for (int i = 0; i < noOfPlanets; i++)
            {
                createNewPlanet(i+1);
            }
        }

        if (reader.doesTableExist("Moon"))
        {
            for (int i = 0; i < noOfMoons; i++)
            {
                createNewMoon(i+1);
            }
        }
    }

    public void createNewStar(int id)
    {
        entities[noOfEntities] = new Star(entities, reader, id);
        noOfEntities++;
    }

    public void createNewPlanet(int id)
    {
        entities[noOfEntities] = new Planet(entities, reader, id);
        noOfEntities++;
    }

    public void createNewMoon(int id)
    {
        entities[noOfEntities] = new Moon(entities, reader, id);
        noOfEntities++;
    }

    public void drawSystem()
    {
        while(true)
        {
            finishedDrawing();

            for (int i = 0; i < noOfEntities; i++)
            {
                entities[i].move(this);
            }
        }
    }

    public void forceQuit(String error)
    {
        WindowEvent end = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);

        int errorBox = JOptionPane.showConfirmDialog(null, error, "ERROR", JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE);
        
        this.dispatchEvent(end);
    }
}