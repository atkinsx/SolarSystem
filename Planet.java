public class Planet extends CelestialBody
{
    public Planet(DBReader database, int id)
    {
        super(database, id);
    }

    public Planet(double diameter, double distance, double velocity, String colour, String name, CelestialBody orbiting)
    {
        super(diameter, distance, velocity, colour, name, orbiting);
        //System.out.println("Planet " + getName() + " created");
    }

    // public void drawEllipticalOrbit(SystemSimulation mySystem)
    // {
    //     double radians = Math.toRadians(this.getAngle());
    //     this.setAngle(this.getAngle() + this.getVelocity());
    //     this.r = (a * (1 - e * e)) / (1 + (e * Math.cos(radians)));
    //     this.r *= 50;
    //     System.out.println("Distance: " + r);
    //     mySystem.drawSolarObjectAbout(this.r, this.getAngle(), 20, "#0000FF", 0, 0);
    // }
}