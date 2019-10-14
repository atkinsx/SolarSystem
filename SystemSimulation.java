public class SystemSimulation extends SolarSystem
{
    public SystemSimulation(int width, int height)
    {
        super(width, height);
        drawStar();
        drawPlanet();
    }

    public void drawStar()
    {
        drawSolarObject(0, 0, 100, "#FFFF00");
    }

    public void drawPlanet()
    {
        drawSolarObjectAbout(200, 0, 20, "#0000FF", 0, 0);
    }
}