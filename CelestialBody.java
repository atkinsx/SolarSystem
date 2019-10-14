public class CelestialBody
{
    private double diameter;
    private String colour;
    private String name;

    public CelestialBody(double diameter, String colour, String name)
    {
        this.diameter = diameter;
        this.colour = colour;
        this.name = name;
    }

    public double getDiameter()
    {
        return this.diameter;
    }

    public String getColour()
    {
        return this.colour;
    }

    public String getName()
    {
        return this.name;
    }

    public void setDiameter(double input)
    {
        this.diameter = input;
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