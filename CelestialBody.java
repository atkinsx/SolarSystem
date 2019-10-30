public abstract class CelestialBody
{
    private CelestialBody orbiting;
    private CelestialBody[] system;
    private DBReader database;
    private double angle;
    private double diameter;
    private double distance;
    private double velocity;
    private int tableID;
    private String colour;
    private String name;

    public CelestialBody(CelestialBody[] system, DBReader database, int id)
    {
        this.database = database;
        this.system = system;
        this.tableID = id;
        this.readName();
        this.readColour();
        this.readOrbiting();
        this.readDiameter();
        this.readDistance();
        this.readVelocity();
        this.sharedConstructor();
    }

    public CelestialBody(double diameter, double distance, double velocity, String colour, String name, CelestialBody orbiting)
    {
        this.diameter = diameter;
        this.distance = distance;
        this.velocity = velocity;
        this.colour = colour;
        this.name = name;
        this.orbiting = orbiting;
        this.sharedConstructor();
    }

    public void sharedConstructor()
    {
        if (orbiting != null)
        {
            this.distance += (orbiting.diameter / 2);
        }

        this.angle = Math.random() * 360;
        System.out.println(this.getClass().getSimpleName() + " " + this.name + " created");
    }

    public void move(SystemSimulation mySystem)
    {
        if (this.getVelocity() == 0)
        {
            mySystem.drawSolarObject(this.getDistance(), this.getAngle(), this.getDiameter(), this.getColour());
        }
        else
        {
            mySystem.drawSolarObjectAbout(this.getDistance(), this.getAngle(), this.getDiameter(), this.getColour(), this.getOrbiting().getDistance(), this.getOrbiting().getAngle());
            this.setAngle(this.getAngle() + this.getVelocity());
        }
    }

    public CelestialBody getOrbiting()
    {
        return this.orbiting;
    }

    public double getAngle()
    {
        return this.angle;
    }

    public double getDiameter()
    {
        return this.diameter;
    }

    public double getDistance()
    {
        return this.distance;
    }

    public double getVelocity()
    {
        return this.velocity;
    }

    public String getColour()
    {
        return this.colour;
    }

    public String getName()
    {
        return this.name;
    }

    public void setOrbiting(CelestialBody input)
    {
        this.orbiting = input;
    }

    public void setAngle(double input)
    {
        this.angle = input;
    }

    public void setDiameter(double input)
    {
        this.diameter = input;
    }

    public void setDistance(double input)
    {
        this.distance = input;
    }

    public void setVelocity(double input)
    {
        this.velocity = input;
    }

    public void setColour(String input)
    {
        this.colour = input;
    }

    public void setName(String input)
    {
        this.name = input;
    }

    public void readOrbiting()
    {
        String type = this.getClass().getSimpleName();
        int orbitingID = database.returnInteger("orbiting", type, this.tableID);
        String orbitingType = database.returnString("orbitingType", type, this.tableID);
        int count = 0;
        boolean found = false;

        while (system[count] != null && !found)
        {
            if (system[count].tableID == orbitingID && system[count].getClass().getSimpleName().equals(orbitingType))
            {
                this.orbiting = system[count];
                found = true;
            }

            count++;
        }
    }

    public void readDiameter()
    {
        String type = this.getClass().getSimpleName();
        this.diameter = database.returnDouble("diameter", type, this.tableID);
    }

    public void readDistance()
    {
        String type = this.getClass().getSimpleName();
        this.distance = database.returnDouble("distance", type, this.tableID);
    }

    public void readVelocity()
    {
        String type = this.getClass().getSimpleName();
        this.velocity = database.returnDouble("velocity", type, this.tableID);
    }

    public void readColour()
    {
        String type = this.getClass().getSimpleName();
        this.colour = database.returnString("colour", type, this.tableID);
    }

    public void readName()
    {
        String type = this.getClass().getSimpleName();
        this.name = database.returnString("name", type, this.tableID);
    }
}