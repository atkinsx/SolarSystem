public class Star extends CelestialBody
{
    public Star(double angle, double diameter, double distance, double velocity, String colour, String name)
    {
        super(angle, diameter, distance, velocity, colour, name);
    }

    public void drawStar(SystemSimulation mySystem)
    {
        mySystem.drawSolarObject(0, 0, 100, "#FFFF00");
    }
}