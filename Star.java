public class Star extends CelestialBody
{
    public Star(double angle, double diameter, double distance, double velocity, String colour, String name, CelestialBody orbiting)
    {
        super(angle, diameter, distance, velocity, colour, name, orbiting);
    }

    public void move(SystemSimulation mySystem)
    {
        mySystem.drawSolarObject(0, 0, 100, "#FFFF00");
    }
}