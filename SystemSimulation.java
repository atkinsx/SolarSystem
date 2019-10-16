public class SystemSimulation extends SolarSystem
{
    private Star sun;
    private Planet[] planets;
    //private Planet[] path;
    
    public SystemSimulation(int width, int height)
    {
        super(width, height);

        initialiseSystem();
        drawSystem();
    }

    public void initialiseSystem()
    {
        sun = new Star(0, 100, 0, 0, "#FFFF00", "Sun");
        planets = new Planet[8];

        planets[0] = new Planet(0, 20, 100, 2, "#AAAAAA", "Mercury");
        planets[1] = new Planet(0, 35, 200, 3, "#FF0000", "Venus");
        planets[2] = new Planet(0, 50, 300, 1, "#0088CC", "Earth");
        planets[3] = new Planet(0, 20, 400, 5, "#FFAA00", "Mars");
        planets[4] = new Planet(0, 35, 500, 2, "#FFDDCC", "Jupiter");
        planets[5] = new Planet(0, 50, 600, 1, "#BBBB88", "Saturn");
        planets[6] = new Planet(0, 20, 700, 13, "#00CCCC", "Uranus");
        planets[7] = new Planet(0, 35, 800, 23, "#0000FF", "Neptune");

        // path = new Planet[360];

        // for (int i = 0; i < 360; i++)
        // {
        //     path[i] = new Planet(i, 50, 300, 1, "#0088CC", "Earth Path");
        // }
    }

    public void drawSystem()
    {
        while(true)
        {
            finishedDrawing();
            sun.move(this);

            for (int i = 0; i < 8; i++)
            {
                planets[i].move(this);
            }

            //drawPath();
        }
    }

    // public void drawPath()
    // {
    //     for (int i = 0; i < 360; i++)
    //     {
    //         path[i].drawEllipticalOrbit(this);
    //     }
    // }
}