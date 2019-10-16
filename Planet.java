public class Planet extends CelestialBody
{
    private double r;
    private double a;
    private double e;

    public Planet(double angle, double diameter, double distance, double velocity, String colour, String name)
    {
        super(angle, diameter, distance, velocity, colour, name);
        this.setDistance(distance);
        //angle = 0;
        //a = 149.60;
        //e = 0.0167086;
        a = 5;
        e = 0.6;
        System.out.println("Planet " + getName() + " created");
    }

    public void drawPlanet(SystemSimulation mySystem)
    {
        mySystem.drawSolarObjectAbout(this.getDistance(), this.getAngle(), this.getDiameter(), this.getColour(), 0, 0);
        this.setAngle(this.getAngle() + this.getVelocity());
    }

    public void drawEllipticalPlanet(SystemSimulation mySystem)
    {
        double radians = Math.toRadians(this.getAngle());
        this.setAngle(this.getAngle() + this.getVelocity());
        this.r = (a * (1 - e * e)) / (1 + (e * Math.cos(radians)));
        this.r *= 50;
        System.out.println("Distance: " + r);
        mySystem.drawSolarObjectAbout(this.r, this.getAngle(), 20, "#0000FF", 0, 0);
    }
}