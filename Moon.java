/**
 * This class represents a Moon, a subclass of CelestialBody.
 * 
 * @see CelestialBody
 * 
 * @author Xaq Atkins
 */
public class Moon extends CelestialBody
{
    /**
     * Constructor method for creating a new Moon using a database.
     * 
     * @param system The solar system that the Moon belongs to
     * @param database The database that hold information about the Moon
     * @param id The unique ID of the Moon
     */
    public Moon(CelestialBody[] system, DBReader database, int id)
    {
        super(system, database, id);
    }

    /**
     * Constructor mthod for making a new Moon.
     * 
     * @param diameter The diameter of the Moon
     * @param distance The distance between the Moon and whatever it is orbiting
     * @param velocity The speed the Moon is travelling at
     * @param colour The colour of the Moon
     * @param name The unique name of the Moon
     * @param orbiting The Point the Moon is orbiting
     */
    public Moon(double diameter, double distance, double velocity, String colour, String name, Point orbiting)
    {
        super(diameter, distance, velocity, colour, name, orbiting);
    }
}