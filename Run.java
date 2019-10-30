/**
 * Driver that creates a solar system from a database
 * and relevant classes.
 * 
 * @see DBReader
 * @see SystemSimulation
 * 
 * @author Xaq Atkins
 */

public class Run
{
    /**
    * Main method that creates a new instance of the SystemSimulation class
    * and states which database to read and the screen size
    */
public static void main (String[] args)
    {
        SystemSimulation newSystem = new SystemSimulation(1500, 1500, "system");
    }
}