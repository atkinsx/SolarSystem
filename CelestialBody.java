/**
 * This class represents a CelestialBody, a subclass of Point.
 * 
 * This can be subclassed to represent any object in space.
 * 
 * @see Point
 * 
 * @author Xaq Atkins
 */
public abstract class CelestialBody extends Point
{
    private CelestialBody[] system;
    private DBReader database;
    private double velocity;
    private int tableID;
    private String colour;
    private String name;

    /**
     * Constructor method for creating a new CelestialBody using a database.
     * 
     * @param system The solar system that the CelestialBody belongs to
     * @param database The database that hold information about the CelestialBody
     * @param id The unique ID of the CelestialBody
     */
    public CelestialBody(CelestialBody[] system, DBReader database, int id)
    {
        super();
        this.database = database;
        this.system = system;
        this.tableID = id;
        this.readName();
        this.readColour();
        this.readDiameter();
        this.readDistance();
        this.readVelocity();
        this.readOrbiting();
        this.sharedConstructor();
    }

    /**
     * Constructor method for making a new CelestialBody.
     * 
     * @param diameter The diameter of the CelestialBody
     * @param distance The distance between the CelestialBody and whatever it is orbiting
     * @param velocity The speed the CelestialBody is travelling at
     * @param colour The colour of the CelestialBody
     * @param name The unique name of the CelestialBody
     * @param orbiting The Point the CelestialBody is orbiting
     */
    public CelestialBody(double diameter, double distance, double velocity, String colour, String name, Point orbiting)
    {
        super(distance, orbiting);
        this.setDiameter(diameter);
        this.setVelocity(velocity);
        this.setColour(colour);
        this.setName(name);
        this.sharedConstructor();
    }

    /**
     * A method that contains code shared by both constructors.
     * 
     * The purpose of this is to:
     *  - Adjust the distance of the orbiting object to outside the radius of the object it is orbiting
     *  - Set the angle to a random point in space
     *  - Confirm in the console that the object has been made
     */
    public void sharedConstructor()
    {
        if (this.getOrbiting() != null)
        {
            this.setDistance(this.getDistance() + (this.getOrbiting().getDiameter() / 2));
            this.setAngle(Math.random() * 360);
        }

        System.out.println(this.getClass().getSimpleName() + " " + this.name + " created");
    }

    /**
     * Method that moves the CelestialBody through space.
     * 
     * The method varies depending on whether the object moves or not.
     * 
     * @param mySystem The solar system that the object belongs to
     */
    public void move(SystemSimulation mySystem)
    {
        if (this.getVelocity() == 0)
        {
            mySystem.drawSolarObject(this.getDistance(), this.getAngle(), this.getDiameter(), this.getColour());
        }
        else
        {
            mySystem.drawSolarObjectAbout(this.getDistance(), this.getAngle(), this.getDiameter(), this.getColour(), this.getOrbiting().getDistance(), this.getOrbiting().getAngle());
            this.setAngle(this.getAngle() + this.getVelocity());
        }
    }

    /**
     * Returns the velocity of the object
     * @return The velocity of the object
     */
    public double getVelocity()
    {
        return this.velocity;
    }

    /**
     * Returns the colour of the object
     * @return The colour of the object
     */
    public String getColour()
    {
        return this.colour;
    }

    /**
     * Returns the name of the object
     * @return The name of the object
     */
    public String getName()
    {
        return this.name;
    }

    /**
     * Allows the user to mututate the velocity of the object
     * @param input The new velocity
     */
    public void setVelocity(double input)
    {
        this.velocity = input;
    }

    /**
     * Allows the user to mututate the colour of the object
     * @param input The new colour
     */
    public void setColour(String input)
    {
        this.colour = input;
    }

    /**
     * Allows the user to mututate the name of the object
     * @param input The new name
     */
    public void setName(String input)
    {
        this.name = input;
    }

    /**
     * Finds which object the current object is orbiting and stores
     * the value in orbiting
     */
    public void readOrbiting()
    {
        String type = this.getClass().getSimpleName();
        int orbitingID = database.returnInteger("orbiting", type, this.tableID);
        String orbitingType = database.returnString("orbitingType", type, this.tableID);
        int count = 0;
        boolean found = false;

        while (system[count] != null && !found)
        {
            if (system[count].tableID == orbitingID && system[count].getClass().getSimpleName().equals(orbitingType))
            {
                this.setOrbiting(system[count]);
                found = true;
            }

            count++;
        }
    }

    /**
     * Finds the diameter of the object in the appropriate table
     */
    public void readDiameter()
    {
        String type = this.getClass().getSimpleName();
        double newDiameter = database.returnDouble("diameter", type, this.tableID);
        this.setDiameter(newDiameter);
    }

    /**
     * Finds the distance between the object and the object it is orbiting
     *  using the appropriate table
     */
    public void readDistance()
    {
        String type = this.getClass().getSimpleName();
        double newDistance = database.returnDouble("distance", type, this.tableID);
        this.setDistance(newDistance);
    }

    /**
     * Finds the velocity of the object in the appropriate table
     */
    public void readVelocity()
    {
        String type = this.getClass().getSimpleName();
        double newVelocity = database.returnDouble("velocity", type, this.tableID);
        this.setVelocity(newVelocity);
    }

    /**
     * Finds the colour of the object in the appropriate table
     */
    public void readColour()
    {
        String type = this.getClass().getSimpleName();
        String newColour = database.returnString("colour", type, this.tableID);
        this.setColour(newColour);
    }

    /**
     * Finds the name of the object in the appropriate table
     */
    public void readName()
    {
        String type = this.getClass().getSimpleName();
        String newName = database.returnString("name", type, this.tableID);
        this.setName(newName);
    }
}