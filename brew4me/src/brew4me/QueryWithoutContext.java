package brew4me;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.NamingException;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;


public class QueryWithoutContext {

    public static void query(PrintWriter out) throws NamingException {
        MysqlDataSource ds = null;
        Connection connect = null;
        Statement statement = null;

        try {
            // Create a new DataSource (MySQL specifically)
            // and provide the relevant information to be used by Tomcat.
            ds = new MysqlDataSource();
            ds.setUrl("jdbc:mysql://localhost:3306/brew4me");
            ds.setUser("root");
            ds.setPassword("#cs564brew4me");
            
            connect = ds.getConnection();

            // Create the statement to be used to get the results.
            statement = connect.createStatement();
            String query = "SELECT * FROM beer";

            // Execute the query and get the result set.
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Float abv = resultSet.getFloat("abv");
                String beer_name = resultSet.getString("beer_name");
                String brewery_name = resultSet.getString("brewery_name");
                String style = resultSet.getString("style");
                int color = resultSet.getInt("color");
                String mouthfeel = resultSet.getString("mouthfeel");
                int price = resultSet.getInt("price");

                out.println("Beer Name: " + beer_name +
            			"Brewery Name: " + brewery_name +
            			"Style: " + style +
            			"ABV: " + abv + 
            			"Color: " + color +
            			"Mouthfeel: " + mouthfeel +
            			"Price: " + price +"<br>");
                
                /*"Beer Name: " + beer_name +
    			"Brewery Name: " + brewery_name +
    			"Style: " + style +
    			"ABV: " + abv + 
    			"Color: " + color +
    			"Mouthfeel: " + mouthfeel +
    			"Price: " + price +"<br>"*/
                
                /*"<tr><td>" + beer_name +"</td><td>" + brewery_name + 
        		"</td><td>" + style + "</td><td>" + abv + "</td><td>" + color + 
        		"</td><td>" + mouthfeel + "</td><td>" + price + "</td></tr>"*/
                
                
          
            }
        } catch (SQLException e) { e.printStackTrace(out);
        } finally {
            // Close the connection and release the resources used.
            try { statement.close(); } catch (SQLException e) { e.printStackTrace(out); }
            try { connect.close(); } catch (SQLException e) { e.printStackTrace(out); }
        }
    }
}