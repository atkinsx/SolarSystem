import java.sql.*;
import java.io.*;

/**
 * This class is used to connect to and read from a database.
 * 
 * It currently has no functionality to write to a database.
 * 
 * @author Xaq Atkins
 */
public class DBReader
{
    private String filename;
    private Connection connection;

    /**
     * Construtor method for a DBReader
     * @param filename The name of the database to be read
     */
    public DBReader(String filename)
    {
        this.filename = filename;
    }

    /**
     * Attempts to connect to the relevant database, and returns whether
     * the program successfully connected to the database
     * 
     * @return Whether the attempt was successful or not
     */
    public boolean connect()
    {
        if (doesFileExist(this.filename))
        {
            try
            {
                String url = "jdbc:sqlite:systems/" + this.filename + ".db";
                connection = DriverManager.getConnection(url);
                System.out.println("Database connection successful.");
                return true;
            }
            catch (SQLException e)
            {
                System.out.println("ERROR 1: " + e.getMessage());
                return false;
            }
        }
        else
        {
            System.out.println("Cannot connect to database: file does not exist.");
            return false;
        }
    }

    /**
     * Closes the connection to the database
     */
    public void closeConnection()
    {
        try
        {
            if (connection != null)
            {
                connection.close();
            }
        }
        catch (SQLException e)
        {
            System.out.println("ERROR 2: " + e.getMessage());
        }
    }

    /**
     * Checks to see if a given file exists and returns the result
     * @param input The name of the file to be checked
     * @return Whether the file exists or not
     */
    public boolean doesFileExist(String input)
    {
        File test = new File("systems/" + input + ".db");

        if (test.exists())
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Gets a table from the database
     * @param tableName The name of the table to fetch
     * @return The named table
     */
    public ResultSet getTable(String tableName)
    {
        try
        {
            ResultSet resultSet = connection.getMetaData().getTables(null, null, tableName, null);

            return resultSet;
        }
        catch (SQLException e)
        {
            System.out.println("ERROR 3: " + e.getMessage());
            return null;
        }
    }

    /**
     * Checks to see if a table exists, and returns the result
     * @param tableName The name of the table to check
     * @return Whether the table is a valid existing table
     */
    public boolean doesTableExist(String tableName)
    {
        try
        {
            ResultSet resultSet = this.getTable("%");

            while (resultSet.next())
            {
                if (resultSet.getString("TABLE_NAME").equals(tableName))
                {
                    return true;
                }
            }
        }
        catch (SQLException e)
        {
            System.out.println("ERROR 4: " + e.getMessage());
            return false;
        }

        return false;
    }

    /**
     * Returns the number of records (rows) in a given table
     * @param input The table to check
     * @return The number or records in the table
     */
    public int getNoOfRecords(String input)
    {
        if (this.doesTableExist(input))
        {
            try
            {
                String recordName = "count(id)";
                ResultSet resultSet = connection.createStatement().executeQuery("SELECT " + recordName + " FROM " + input);
                int count = resultSet.getInt(recordName);

                return count;
            }
            catch (SQLException e)
            {
                System.out.println("ERROR 5: " + e.getMessage());
                return 0;
            }
        }
        else
        {
            return 0;
        }
    }

    /**
     * Returns a double from a record in the database
     * @param attribute The attribute (column) from the table
     * @param table The table the data is stored in
     * @param id The unique ID of the object
     * @return The required data returned from the SQL query
     */
    public double returnDouble(String attribute, String table, int id)
    {
        try
        {
            String query = "SELECT " + attribute + " FROM " + table + " WHERE id = " + id + ";";
            ResultSet resultSet = connection.createStatement().executeQuery(query);

            return resultSet.getDouble(attribute);
        }
        catch (SQLException e)
        {
            System.out.println("ERROR 6: " + e.getMessage());
            return -1;
        }
    }
    
    /**
     * Returns an integer from a record in the database
     * @param attribute The attribute (column) from the table
     * @param table The table the data is stored in
     * @param id The unique ID of the object
     * @return The required data returned from the SQL query
     */
    public int returnInteger(String attribute, String table, int id)
    {
        try
        {
            String query = "SELECT " + attribute + " FROM " + table + " WHERE id = " + id + ";";
            ResultSet resultSet = connection.createStatement().executeQuery(query);

            return resultSet.getInt(attribute);
        }
        catch (SQLException e)
        {
            System.out.println("ERROR 7: " + e.getMessage());
            return -1;
        }
    }

    /**
     * Returns a String from a record in the database
     * @param attribute The attribute (column) from the table
     * @param table The table the data is stored in
     * @param id The unique ID of the object
     * @return The required data returned from the SQL query
     */
    public String returnString(String attribute, String table, int id)
    {
        try
        {
            String query = "SELECT " + attribute + " FROM " + table + " WHERE id = " + id + ";";
            ResultSet resultSet = connection.createStatement().executeQuery(query);

            return resultSet.getString(attribute);
        }
        catch (SQLException e)
        {
            System.out.println("ERROR 8: " + e.getMessage());
            return "failed";
        }
    }
}