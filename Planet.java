public class Planet extends CelestialBody
{
    private double angle;
    private double distance;

    private double r;
    private double a;
    private double e;

    public Planet(double distance, double diameter, String colour, String name)
    {
        super(diameter, colour, name);
        this.distance = distance;
        angle = 0;
        //a = 149.60;
        //e = 0.0167086;
        a = 5;
        e = 0.6;
        System.out.println("Planet " + getName() + " created");
    }

    public void drawPlanet(SystemSimulation mySystem)
    {
        this.angle++;
        mySystem.drawSolarObjectAbout(this.distance, this.angle, this.getDiameter(), this.getColour(), 0, 0);
    }

    public void drawEllipticalPlanet(SystemSimulation mySystem)
    {
        double radians = Math.toRadians(angle);
        this.angle++;
        this.r = (a * (1 - e * e)) / (1 + (e * Math.cos(radians)));
        this.r *= 50;
        System.out.println("Distance: " + r);
        mySystem.drawSolarObjectAbout(this.r, this.angle, 20, "#0000FF", 0, 0);
    }

    public void setAngle(double input)
    {
        this.angle = input;
    }
}