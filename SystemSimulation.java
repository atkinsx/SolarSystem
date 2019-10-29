import java.awt.event.*;
import javax.swing.*;

public class SystemSimulation extends SolarSystem
{
    private CelestialBody[] entities;
    private DBReader reader;
    private int MAX_NO_OF_ENTITIES;
    private int noOfEntities;
    private int noOfMoons;
    private int noOfPlanets;
    private int noOfStars;
    private Moon[] moons;
    private Planet[] planets;
    private Star sun;
    private String systemName;
    
    public SystemSimulation(int width, int height, String systemName)
    {
        super(width, height);
        this.systemName = systemName;

        MAX_NO_OF_ENTITIES = 1000;

        connectToDatabase();
        //reader.getAllTableNames();
        //System.out.println(reader.returnString("Star", 1));

        //

        initialiseSystem();
        drawSystem();

        reader.closeConnection();
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
        noOfPlanets = reader.getNoOfRecords("Planet");//8;
        noOfMoons = 3;//193;
        entities = new CelestialBody[MAX_NO_OF_ENTITIES];

        createEntities();

        //System.out.println(sun.getClass().getSimpleName());
        sun = new Star(100, 0, 0, reader.returnString("Star", 1), "Sol", null);
        addObjectToEntities(sun);

        planets = new Planet[noOfPlanets];
        moons = new Moon[noOfMoons];

        planets[0] = new Planet(20, 100, 0.2, "#AAAAAA", "Mercury", sun);
        planets[1] = new Planet(35, 200, 0.3, "#FF0000", "Venus", sun);
        planets[2] = new Planet(50, 300, 0.7, "#0088CC", "Earth", sun);
        planets[3] = new Planet(20, 400, 0.5, "#FFAA00", "Mars", sun);
        planets[4] = new Planet(35, 500, 0.2, "#FFDDCC", "Jupiter", sun);
        planets[5] = new Planet(50, 600, 1, "#BBBB88", "Saturn", sun);
        planets[6] = new Planet(20, 700, 0.9, "#00CCCC", "Uranus", sun);
        planets[7] = new Planet(35, 800, 1, "#0000FF", "Neptune", sun);

        for (int i = 0; i < noOfPlanets; i++)
        {
            addObjectToEntities(planets[i]);
        }

        moons[0] = new Moon(5, 50, 2, "#DDDDDD", "Luna", planets[2]);
        moons[1] = new Moon(5, 75, 0.7, "#DDDDDD", "Phobos", planets[3]);
        moons[2] = new Moon(5, 50, 2, "#DDDDDD", "Deimos", planets[3]);
        //79 moons around Jupiter
        //62 moons around Saturn
        //27 moons around Uranus
        //14 moons around Neptune

        for (int i = 0; i < noOfMoons; i++)
        {
            addObjectToEntities(moons[i]);
        }

        // for (int i = 0; i < noOfEntities; i++)
        // {
        //     System.out.println(entities[i].getName());
        // }
    }

    public void createEntities()
    {
        if (reader.doesTableExist("Star"))
        {
            for (int i = 0; i < noOfStars; i++)
            {
                //createNewStar();
                //System.out.println(i);
            }
        }

        if (reader.doesTableExist("Planet"))
        {
            for (int i = 0; i < reader.getNoOfRecords("Planet"); i++)
            {
                //createNewStar();
                //System.out.println(i);
            }
        }

        if (reader.doesTableExist("Moon"))
        {
            //System.out.println("MOON");
        }
    }

    public void createNewStar()
    {
        //entities[noOfEntities] = new Star();
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

    public void addObjectToEntities(CelestialBody input)
    {
        entities[noOfEntities] = input;
        noOfEntities++;
    }

    public void forceQuit(String error)
    {
        WindowEvent end = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);

        int errorBox = JOptionPane.showConfirmDialog(null, error, "ERROR", JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE);
        
        this.dispatchEvent(end);
    }
}