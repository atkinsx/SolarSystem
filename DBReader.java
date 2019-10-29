import java.sql.*;
import java.io.*;

public class DBReader
{
    private String filename;
    private Connection connection;

    public DBReader(String filename)
    {
        this.filename = filename;
    }

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

    //MIGHT BE A BETTER WAY OF DOING THIS USING SQL COMMANDS
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
                System.out.println("ERROR 4: " + e.getMessage());
                return 0;
            }
        }
        else
        {
            return 0;
        }
    }
    
    public int returnInteger(String property, String table, int id)
    {
        try
        {
            String query = "SELECT " + property + " FROM " + table + " WHERE id = " + id + ";";
            ResultSet resultSet = connection.createStatement().executeQuery(query);

            return resultSet.getInt(property);
        }
        catch (SQLException e)
        {
            System.out.println("ERROR 5: " + e.getMessage());
            return -1;
        }
    }

    public String returnString(String property, String table, int id)
    {
        try
        {
            String query = "SELECT " + property + " FROM " + table + " WHERE id = " + id + ";";
            ResultSet resultSet = connection.createStatement().executeQuery(query);

            return resultSet.getString(property);
        }
        catch (SQLException e)
        {
            System.out.println("ERROR 5: " + e.getMessage());
            return "failed";
        }
    }
}