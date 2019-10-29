public class Star extends CelestialBody
{
    public Star(double diameter, double distance, double velocity, String colour, String name, CelestialBody orbiting)
    {
        super(diameter, distance, velocity, colour, name, orbiting);

        //System.out.println("Star " + getName() + " created");
    }
}