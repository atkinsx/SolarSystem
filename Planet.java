public class Planet extends CelestialBody
{
    public Planet(double diameter, String colour, String name)
    {
        super(diameter, colour, name);
    }

    public void drawPlanet(SystemSimulation mySystem)
    {
        mySystem.drawSolarObjectAbout(200, 0, 20, "#0000FF", 0, 0);
    }
}