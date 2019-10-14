public class SystemSimulation extends SolarSystem
{
    private Star sun;
    private Planet earth;
    
    public SystemSimulation(int width, int height)
    {
        super(width, height);

        sun = new Star(100, "#FFFF00", "Sun");
        earth = new Planet(20, "#0000FF", "Earth");

        //drawStar();
        //drawPlanet();

        sun.drawStar(this);
        earth.drawPlanet(this);
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