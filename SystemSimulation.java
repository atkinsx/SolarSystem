import java.awt.event.*;
import javax.swing.*;

/**
 * This class is used to create a visual representation
 * of a solar system.
 * 
 * This class is a subclass of SolarSystem.
 * 
 * @see SolarSystem
 * 
 * @author Xaq Atkins
 */
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
    
    /**
     * Constructor method for a SystemSimulation.
     * 
     * It does the following:
     *  - Connects to a database
     *  - Creates the system
     *  - Closes the database connection
     *  - Draws the system
     * 
     * @param width The width of the window
     * @param height The height of the window
     * @param systemName The name of the solar system
     */
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

    /**
     * This method attempts to connect the program
     * to the database.
     */
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

    /**
     * This procedure initialises the number of objects
     * using the database and begins creating the objects.
     */
    public void initialiseSystem()
    {
        noOfStars = reader.getNoOfRecords("Star");
        noOfPlanets = reader.getNoOfRecords("Planet");
        noOfMoons = reader.getNoOfRecords("Moon");
        entities = new CelestialBody[MAX_NO_OF_ENTITIES];

        createEntities();
    }

    /**
     * Creates all of the objects in the system based on the number
     * of objects are in the system
     */
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

        for (int i = noOfEntities; i < MAX_NO_OF_ENTITIES; i++)
        {
            double size = Math.random() * 5;
            double velocity = Math.random() * 1;
            double distance =  (Math.random() * 100) + 500;
            entities[i] = new Asteroid(size, distance, velocity, "#AAAAAA", "Asteroid " + i, entities[0]);
            noOfEntities++;
        }
    }

    /**
     * Creates a new Star
     * @param id The unique ID of the object
     * @see Star
     */
    public void createNewStar(int id)
    {
        entities[noOfEntities] = new Star(entities, reader, id);
        noOfEntities++;
    }

    /**
     * Creates a new Planet
     * @param id The unique ID of the object
     * @see Planet
     */
    public void createNewPlanet(int id)
    {
        entities[noOfEntities] = new Planet(entities, reader, id);
        noOfEntities++;
    }

    /**
     * Creates a new Moon
     * @param id The unique ID of the object
     * @see Moon
     */
    public void createNewMoon(int id)
    {
        entities[noOfEntities] = new Moon(entities, reader, id);
        noOfEntities++;
    }

    /**
     * Draws the objects on the GUI and moves them
     * across the screen.
     */
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

    /**
     * Forces the window the close and display an error message
     * @param error The error message
     */
    public void forceQuit(String error)
    {
        WindowEvent end = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);

        int errorBox = JOptionPane.showConfirmDialog(null, error, "ERROR", JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE);
        
        this.dispatchEvent(end);
    }
}