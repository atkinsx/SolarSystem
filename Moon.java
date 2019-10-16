public class Moon extends CelestialBody
{
    public Moon(double angle, double diameter, double distance, double velocity, String colour, String name, CelestialBody orbiting)
    {
        super(angle, diameter, distance, velocity, colour, name, orbiting);
    }

    public void move(SystemSimulation mySystem)
    {
        mySystem.drawSolarObjectAbout(this.getDistance(), this.getAngle(), this.getDiameter(), this.getColour(), this.getOrbiting().getDistance(), this.getOrbiting().getAngle());
        this.setAngle(this.getAngle() + this.getVelocity());
    }
}