import java.sql.*;
import java.io.*;

public class FailedAltDBReader
{
    private String filename;
    private Connection connection;
    private ResultSet resultSet;

    public FailedAltDBReader(String filename)
    {
        this.filename = filename;
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

    public boolean isNoException(int input)
    {
        try
            {
                switch (input)
                {
                    case 1:
                        continueConnect();
                    break;
                    case 2:
                        continueCloseConnection();
                    break;
                    case 3:
                        continueGetTable();
                    break;
                    default:
                        return false;
                }

                return true;
            }
            catch (SQLException e)
            {
                System.out.println("ERROR: " + e.getMessage());
                return false;
            }
    }

    public boolean connect()
    {
        if (doesFileExist(this.filename))
        {
            if (isNoException(1))
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            System.out.println("Cannot connect to database: file does not exist.");
            return false;
        }
    }

    public void continueConnect() throws SQLException
    {
        String url = "jdbc:sqlite:systems/" + this.filename + ".db";
        connection = DriverManager.getConnection(url);
        System.out.println("Database connection successful.");
    }

    public void closeConnection()
    {
        if (isNoException(2))
        {
            System.out.println("Connection successfully closed.");
        }
        else
        {
            System.out.println("Error closing connection...");
        }
    }

    public void continueCloseConnection() throws SQLException
    {
        if (connection != null)
        {
            connection.close();
        }
    }

    public ResultSet getTable(String tableName)
    {
        if (isNoException(3))
        {
            return resultSet;
        }
        else
        {
            return null;
        }
    }

    public void continueGetTable() throws SQLException
    {
        //resultSet = connection.getMetaData().getTables(null, null, tableName, null);
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
                System.out.println("ERROR 5: " + e.getMessage());
                return 0;
            }
        }
        else
        {
            return 0;
        }
    }

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