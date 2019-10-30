/**
 * This class represents a point in space.
 * 
 * Used to subclass into other classes.
 * 
 * @author Xaq Atkins
 */
public abstract class Point
{
    private double angle;
    private double diameter;
    private double distance;
    private Point orbiting;

    /**
     * Empty construtor to make a Point from a database
     */
    public Point()
    {
        /*
        Using the empty constructor implies that you are going to be using a database
        to populate any subclasses. It is recommended this constructor is not used
        otherwise.
        */
    }

    /**
     * Constructor method for making a new Point
     * 
     * @param distance The distance between this point and another
     * @param orbiting The point that this point is orbiting (if any)
     */
    public Point(double distance, Point orbiting)
    {
        this.setDistance(distance);
        this.setOrbiting(orbiting);
    }

    /**
     * Method that returns the angle the object is at
     * @return The angle of the object
     */
    public double getAngle()
    {
        return this.angle;
    }

    /**
     * Returns the diameter of the object
     * @return The diameter of the object
     */
    public double getDiameter()
    {
        return this.diameter;
    }

    /**
     * Returns the distance between the object and whatever it is orbiting
     * @return The distance
     */
    public double getDistance()
    {
        return this.distance;
    }

    /**
     * Returns the point this object is orbiting
     * @return The point this object is orbiting
     */
    public Point getOrbiting()
    {
        return this.orbiting;
    }

    /**
     * Allows the user to mututate the angle the object is at
     * @param input The new angle
     */
    public void setAngle(double input)
    {
        this.angle = input;
    }

    /**
     * Allows the user to mututate the diameter of the object
     * @param input The new diameter
     */
    public void setDiameter(double input)
    {
        this.diameter = input;
    }

    /**
     * Allows the user to mututate the distance between the object and the Point it is orbiting
     * @param input The new distance between objects
     */
    public void setDistance(double input)
    {
        this.distance = input;
    }

    /**
     * Allows the user to change which point this object orbits
     * @param input The new point being orbited
     */
    public void setOrbiting(Point input)
    {
        this.orbiting = input;
    }
}