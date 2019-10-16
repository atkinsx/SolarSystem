public class SystemSimulation extends SolarSystem
{
    private CelestialBody[] entities;
    private int MAX_NO_OF_ENTITIES;
    private Moon moon;
    private Planet[] planets;
    private Star sun;
    //private Planet[] path;
    
    public SystemSimulation(int width, int height)
    {
        super(width, height);
        MAX_NO_OF_ENTITIES = 1000;

        initialiseSystem();
        drawSystem();
    }

    public void initialiseSystem()
    {
        CelestialBody[] entities = new CelestialBody[MAX_NO_OF_ENTITIES];
        sun = new Star(0, 100, 0, 0, "#FFFF00", "Sun", null);
        planets = new Planet[8];

        planets[0] = new Planet(0, 20, 100, 0.2, "#AAAAAA", "Mercury", sun);
        planets[1] = new Planet(0, 35, 200, 0.3, "#FF0000", "Venus", sun);
        planets[2] = new Planet(0, 50, 300, 0.7, "#0088CC", "Earth", sun);
        planets[3] = new Planet(0, 20, 400, 0.5, "#FFAA00", "Mars", sun);
        planets[4] = new Planet(0, 35, 500, 0.2, "#FFDDCC", "Jupiter", sun);
        planets[5] = new Planet(0, 50, 600, 1, "#BBBB88", "Saturn", sun);
        planets[6] = new Planet(0, 20, 700, 0.9, "#00CCCC", "Uranus", sun);
        planets[7] = new Planet(0, 35, 800, 1, "#0000FF", "Neptune", sun);

        moon = new Moon(0, 5, 50, 2, "#DDDDDD", "Luna", planets[2]);

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

            moon.move(this);

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