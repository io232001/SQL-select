package it.develhope.sql;
import java.sql.*;
import java.util.ArrayList;
public class Start {
    public static void main(String[] args)
    {
        Connection collection=null;
        try {
            String url       = "jdbc:mysql://localhost:3306/newdb";
            String user      = "developer";
            String password  = "passwordhere";
            collection = DriverManager.getConnection(url, user, password);
            Statement statement = collection.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS student " +
                    "(student_id INTEGER(10) NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
                    " last_name VARCHAR(30), " +
                    " first_name VARCHAR(30))";
            ArrayList<String> surnames = new ArrayList<>();
            statement.executeUpdate(sql);
            statement.execute("INSERT INTO newdb.student (last_name, first_name)VALUES('Rossi', 'Marco');");
            statement.execute("INSERT INTO newdb.student (last_name, first_name)VALUES('Verdi', 'Davide');");
            statement.execute("INSERT INTO newdb.student (last_name, first_name)VALUES('DeLuca', 'Giuseppe');");
            statement.execute("INSERT INTO newdb.student (last_name, first_name)VALUES('Costanzo', 'Mirco');");
            ResultSet resultSet = statement.executeQuery("SELECT first_name, last_name FROM newdb.student");
            while (resultSet.next())
            {
                surnames.add(resultSet.getString("last_name"));
                System.out.println(resultSet.getString("first_name"));
            }
            System.out.println(surnames);
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        finally
        {
            try
            {
                if(collection != null)
                    collection.close();
            }
            catch(SQLException ex)
            {
                System.out.println(ex.getMessage());
            }
        }
    }
}
