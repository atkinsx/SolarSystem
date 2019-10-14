public class Star extends CelestialBody
{
    public Star(double diameter, String colour, String name)
    {
        super(diameter, colour, name);
    }

    public void drawStar(SystemSimulation mySystem)
    {
        mySystem.drawSolarObject(0, 0, 100, "#FFFF00");
    }
}