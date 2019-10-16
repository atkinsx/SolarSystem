public abstract class CelestialBody
{
    private CelestialBody orbiting;
    private double angle;
    private double diameter;
    private double distance;
    private double velocity;
    private String colour;
    private String name;

    public CelestialBody(double diameter, double distance, double velocity, String colour, String name, CelestialBody orbiting)
    {
        this.orbiting = orbiting;
        this.angle = Math.random() * 360;
        this.diameter = diameter;
        this.distance = distance;
        this.velocity = velocity;
        this.colour = colour;
        this.name = name;
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
}