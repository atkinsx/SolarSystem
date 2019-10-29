public class Moon extends CelestialBody
{
    public Moon(CelestialBody[] system, DBReader database, int id)
    {
        super(system, database, id);
    }

    public Moon(double diameter, double distance, double velocity, String colour, String name, CelestialBody orbiting)
    {
        super(diameter, distance, velocity, colour, name, orbiting);
    }
}