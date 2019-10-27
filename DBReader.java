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

    public void getAllTableNames()
    {
        try
        {
            ResultSet resultSet = connection.getMetaData().getTables(null, null, "%", null);

            while (resultSet.next())
            {
                System.out.println(resultSet.getString("TABLE_NAME"));
            }
        }
        catch (SQLException e)
        {
            System.out.println("ERROR 3: " + e.getMessage());
        }
    }
}