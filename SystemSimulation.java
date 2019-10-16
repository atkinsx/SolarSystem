public class SystemSimulation extends SolarSystem
{
    private CelestialBody[] entities;
    private int MAX_NO_OF_ENTITIES;
    private int noOfEntities;
    private int noOfMoons;
    private int noOfPlanets;
    //private int noOfStars;
    private Moon[] moons;
    private Planet[] planets;
    private Star sun;
    //private Planet[] path;
    
    public SystemSimulation(int width, int height)
    {
        super(width, height);
        MAX_NO_OF_ENTITIES = 1000;
        noOfMoons = 3;//193;
        noOfPlanets = 8;

        initialiseSystem();
        drawSystem();
    }

    public void initialiseSystem()
    {
        entities = new CelestialBody[MAX_NO_OF_ENTITIES];

        sun = new Star(100, 0, 0, "#FFFF00", "Sun", null);
        addObjectToEntities(sun);

        planets = new Planet[noOfPlanets];
        moons = new Moon[noOfMoons];

        planets[0] = new Planet(20, 100, 0.2, "#AAAAAA", "Mercury", sun);
        planets[1] = new Planet(35, 200, 0.3, "#FF0000", "Venus", sun);
        planets[2] = new Planet(50, 300, 0.7, "#0088CC", "Earth", sun);
        planets[3] = new Planet(20, 400, 0.5, "#FFAA00", "Mars", sun);
        planets[4] = new Planet(35, 500, 0.2, "#FFDDCC", "Jupiter", sun);
        planets[5] = new Planet(50, 600, 1, "#BBBB88", "Saturn", sun);
        planets[6] = new Planet(20, 700, 0.9, "#00CCCC", "Uranus", sun);
        planets[7] = new Planet(35, 800, 1, "#0000FF", "Neptune", sun);

        for (int i = 0; i < noOfPlanets; i++)
        {
            addObjectToEntities(planets[i]);
        }

        moons[0] = new Moon(5, 50, 2, "#DDDDDD", "Luna", planets[2]);
        moons[1] = new Moon(5, 75, 0.7, "#DDDDDD", "Phobos", planets[3]);
        moons[2] = new Moon(5, 50, 2, "#DDDDDD", "Deimos", planets[3]);
        //79 moons around Jupiter
        //62 moons around Saturn
        //27 moons around Uranus
        //14 moons around Neptune

        for (int i = 0; i < noOfMoons; i++)
        {
            addObjectToEntities(moons[i]);
        }

        for (int i = 0; i < noOfEntities; i++)
        {
            System.out.println(entities[i].getName());
        }

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

            for (int i = 0; i < noOfEntities; i++)
            {
                entities[i].move(this);
            }

            // sun.move(this);

            // for (int i = 0; i < noOfPlanets; i++)
            // {
            //     planets[i].move(this);
            // }

            // for (int i = 0; i < noOfMoons; i++)
            // {
            //     moons[i].move(this);
            // }

            //drawPath();
        }
    }

    public void addObjectToEntities(CelestialBody input)
    {
        entities[noOfEntities] = input;
        noOfEntities++;
    }

    // public void drawPath()
    // {
    //     for (int i = 0; i < 360; i++)
    //     {
    //         path[i].drawEllipticalOrbit(this);
    //     }
    // }
}