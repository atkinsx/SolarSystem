public class Moon extends CelestialBody
{
    public Moon(double diameter, double distance, double velocity, String colour, String name, CelestialBody orbiting)
    {
        super(diameter, distance, velocity, colour, name, orbiting);

        //System.out.println("Moon " + getName() + " created");
    }
}