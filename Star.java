public class Star extends CelestialBody
{

    public Star(CelestialBody[] system, DBReader database, int id)
    {
        super(system, database, id);
    }

    public Star(double diameter, double distance, double velocity, String colour, String name, CelestialBody orbiting)
    {
        super(diameter, distance, velocity, colour, name, orbiting);
    }
}