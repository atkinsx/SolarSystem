/**
 * This class represents a Asteroid, a subclass of CelestialBody.
 * 
 * @see CelestialBody
 * 
 * @author Xaq Atkins
 */
public class Asteroid extends CelestialBody
{
    /**
     * Constructor method for creating a new Asteroid using a database.
     * 
     * @param system The solar system that the Asteroid belongs to
     * @param database The database that hold information about the Asteroid
     * @param id The unique ID of the Asteroid
     */
    public Asteroid(CelestialBody[] system, DBReader database, int id)
    {
        super(system, database, id);
    }

    /**
     * Constructor mthod for making a new Asteroid.
     * 
     * @param diameter The diameter of the Asteroid
     * @param distance The distance between the Asteroid and whatever it is orbiting
     * @param velocity The speed the Asteroid is travelling at
     * @param colour The colour of the Asteroid
     * @param name The unique name of the Asteroid
     * @param orbiting The Point the Asteroid is orbiting
     */
    public Asteroid(double diameter, double distance, double velocity, String colour, String name, Point orbiting)
    {
        super(diameter, distance, velocity, colour, name, orbiting);
    }
}