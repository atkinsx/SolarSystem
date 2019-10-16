public class Moon extends CelestialBody
{
    public Moon(double angle, double diameter, double distance, double velocity, String colour, String name)
    {
        super(angle, diameter, distance, velocity, colour, name);
    }

    public void move(SystemSimulation mySystem)
    {
        mySystem.drawSolarObjectAbout(this.getDistance(), this.getAngle(), this.getDiameter(), this.getColour(), 0, 0);
        this.setAngle(this.getAngle() + this.getVelocity());
    }
}