public class SystemSimulation extends SolarSystem
{
    private Star sun;
    private Planet[] planets;
    //private Planet[] path;
    
    public SystemSimulation(int width, int height)
    {
        super(width, height);

        initialiseSystem();

        while(true)
        {
            finishedDrawing();
            sun.drawStar(this);

            for (int i = 0; i < 8; i++)
            {
                planets[i].drawPlanet(this);
            }

            //drawPath();
        }
    }

    public void initialiseSystem()
    {
        sun = new Star(100, "#FFFF00", "Sun");
        planets = new Planet[8];

        planets[0] = new Planet(100, 20, "#AAAAAA", "Mercury");
        planets[1] = new Planet(200, 35, "#FF0000", "Venus");
        planets[2] = new Planet(300, 50, "#0088CC", "Earth");
        planets[3] = new Planet(400, 20, "#FFAA00", "Mars");
        planets[4] = new Planet(500, 35, "#FFDDCC", "Jupiter");
        planets[5] = new Planet(600, 50, "#BBBB88", "Saturn");
        planets[6] = new Planet(700, 20, "#00CCCC", "Uranus");
        planets[7] = new Planet(800, 35, "#0000FF", "Neptune");

        // path = new Planet[360];

        // for (int i = 0; i < 360; i++)
        // {
        //     path[i] = new Planet(20, "#FFFFFF", "path");
        //     path[i].setAngle(i);
        // }
    }

    public void drawStar()
    {
        drawSolarObject(0, 0, 100, "#FFFF00");
    }

    public void drawPlanet()
    {
        drawSolarObjectAbout(200, 0, 20, "#0000FF", 0, 0);
    }

    public void drawPath()
    {
        for (int i = 0; i < 360; i++)
        {
            //path[i].drawEllipticalPlanet(this);
        }
    }
}