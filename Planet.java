/**
 * This class represents a Planet, a subclass of CelestialBody.
 * 
 * @see CelestialBody
 * 
 * @author Xaq Atkins
 */
public class Planet extends CelestialBody
{
    /**
     * Constructor method for creating a new Planet using a database.
     * 
     * @param system The solar system that the Planet belongs to
     * @param database The database that hold information about the Planet
     * @param id The unique ID of the Planet
     */
    public Planet(CelestialBody[] system, DBReader database, int id)
    {
        super(system, database, id);
    }

    /**
     * Constructor mthod for making a new Planet.
     * 
     * @param diameter The diameter of the Planet
     * @param distance The distance between the Planet and whatever it is orbiting
     * @param velocity The speed the Planet is travelling at
     * @param colour The colour of the Planet
     * @param name The unique name of the Planet
     * @param orbiting The Point the Planet is orbiting
     */
    public Planet(double diameter, double distance, double velocity, String colour, String name, Point orbiting)
    {
        super(diameter, distance, velocity, colour, name, orbiting);
    }
}