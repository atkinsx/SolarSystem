/**
 * This class represents a Star, a subclass of CelestialBody.
 * 
 * @see CelestialBody
 * 
 * @author Xaq Atkins
 */
public class Star extends CelestialBody
{

    /**
     * Constructor method for creating a new Star using a database.
     * 
     * @param system The solar system that the Star belongs to
     * @param database The database that hold information about the Star
     * @param id The unique ID of the Star
     */
    public Star(CelestialBody[] system, DBReader database, int id)
    {
        super(system, database, id);
    }

    /**
     * Constructor mthod for making a new Star.
     * 
     * @param diameter The diameter of the Star
     * @param distance The distance between the Star and whatever it is orbiting
     * @param velocity The speed the Star is travelling at
     * @param colour The colour of the Star
     * @param name The unique name of the Star
     * @param orbiting The Point the Star is orbiting
     */
    public Star(double diameter, double distance, double velocity, String colour, String name, Point orbiting)
    {
        super(diameter, distance, velocity, colour, name, orbiting);
    }
}