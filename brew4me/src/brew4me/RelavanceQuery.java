/* * * * * * * * * *
 * Status : Used
 * * * * * * * * * */

package brew4me;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;


public class RelavanceQuery 
{

    public static void query(HttpServletResponse resp, String style, String mouthfeel, int colorMin, int colorMax, float abvMin, float abvMax, float priceMin, float priceMax) throws NamingException {
        MysqlDataSource ds = null;
        Connection connect = null;
        Statement statement = null;
        
        PrintWriter out;
		try 
		{
			out = resp.getWriter();
	        try 
	        {
	            // Create a new DataSource (MySQL specifically)
	            // and provide the relevant information to be used by Tomcat.
	            ds = new MysqlDataSource();
	            ds.setUrl("jdbc:mysql://localhost:3306/brew4me");
	            ds.setUser("root");
	            ds.setPassword("#cs564brew4me");
	            
	            connect = ds.getConnection();
	            
	            // Create the statement to be used to get the results.
	            statement = connect.createStatement();
	            
            	String query = (
            			"SELECT * " +
            			"FROM " +
            			"(" +
            				/* == Complete Match == */
            				"SELECT b.beer_name, b.brewery_name, b.style, b.mouthfeel, b.color, b.abv, b.price, 5 AS Relevance " +
            				"FROM Beer AS b " +
            				"WHERE b.style = '" + style + "' AND b.mouthfeel = '" + mouthfeel + "' AND b.color >= " + colorMin + " AND b.color <= " + colorMax + " AND b.abv >= " + abvMin + " AND b.abv <= " + abvMax + " AND b.price >= " + priceMin + " AND b.price <= " + priceMax +
            			" UNION ALL " +
            				/* == Count Matches */
            				"SELECT b2.beer_name, b2.brewery_name, b2.style, b2.mouthfeel, b.color, b.abv, b.price, COUNT(*) AS Relevance " +
            				"FROM Beer AS b2 " +
            				"INNER JOIN " +
            				"(" +
            					/* == By Style == */
            					"SELECT byStyle.beer_name, byStyle.brewery_name " +
            			        "FROM Beer AS b3" +
            					"INNER JOIN  Beer AS byStyle " +
            					"ON b3.style = byStyle.style " +
            					"WHERE b3.style = '" + style + "' AND b3.mouthfeel = '" + mouthfeel + "' AND b3.color >= " + colorMin + " AND b3.color <= " + colorMax + " AND b3.abv >= " + abvMin + " AND b3.abv <= " + abvMax + " AND b3.price >= " + priceMin + " AND b3.price <= " + priceMax + " AND (byStyle.beer_name <> b3.beer_name OR byStyle.brewery_name <> b3.brewery_name) " +
            				" UNION ALL " +
            					/* == By Mouthfeel == */
            					"SELECT byMouthfeel.beer_name, byMouthfeel.brewery_name " +
            					"FROM Beer AS b3 " +
            					"INNER JOIN Beer AS byMouthfeel " +
            					"ON b3.mouthfeel = byMouthfeel.mouthfeel " +
            					"WHERE b3.style = '" + style + "' AND b3.mouthfeel = '" + mouthfeel + "' AND b3.color >= " + colorMin + " AND b3.color <= " + colorMax + " AND b3.abv >= " + abvMin + " AND b3.abv <= " + abvMax + " AND b3.price >= " + priceMin + " AND b3.price <= " + priceMax + " AND (byMouthfeel.beer_name <> b3.beer_name OR byMouthfeel.brewery_name <> b3.brewery_name) " +
            				" UNION ALL " +
            					/* == By Color == */
            					"SELECT byColor.beer_name, byColor.brewery_name " +
            					"FROM Beer AS b3 " +
            					"INNER JOIN Beer AS byColor " +
            					"ON b3.color = byColor.color " +
            					"WHERE b3.style = '" + style + "' AND b3.mouthfeel = '" + mouthfeel + "' AND b3.color >= " + colorMin + " AND b3.color <= " + colorMax + " AND b3.abv >= " + abvMin + " AND b3.abv <= " + abvMax + " AND b3.price >= " + priceMin + " AND b3.price <= " + priceMax + " AND (byColor.beer_name <> b3.beer_name OR byColor.brewery_name <> b3.brewery_name) " +
            				" UNION ALL " +
            					/* == By ABV == */
            					"SELECT byABV.beer_name, byABV.brewery_name " +
            					"FROM Beer AS b3 " +
            					"INNER JOIN Beer AS byABV " +
            					"ON b3.abv = byABV.abv " +
            					"WHERE b3.style = '" + style + "' AND b3.mouthfeel = '" + mouthfeel + "' AND b3.color >= " + colorMin + " AND b3.color <= " + colorMax + " AND b3.abv >= " + abvMin + " AND b3.abv <= " + abvMax + " AND b3.price >= " + priceMin + " AND b3.price <= " + priceMax + " AND (byABV.beer_name <> b3.beer_name OR byABV.brewery_name <> b3.brewery_name) " +
            				" UNION ALL " +
            					/* == By Price == */
            					"SELECT byPrice.beer_name, byPrice.brewery_name " +
            					"FROM Beer AS b3 " +
            					"INNER JOIN Beer AS byPrice " +
            					"ON b3.price = byPrice.price " +
            					"WHERE b3.style = '" + style + "' AND b3.mouthfeel = '" + mouthfeel + "' AND b3.color >= " + colorMin + " AND b3.color <= " + colorMax + " AND b3.abv >= " + abvMin + " AND b3.abv <= " + abvMax + " AND b3.price >= " + priceMin + " AND b3.price <= " + priceMax + " AND (byPrice.beer_name <> b3.beer_name OR byPrice.brewery_name <> b3.brewery_name) " +
            				") AS matches " +
            				"ON (b2.beer_name = matches.beer_name AND b2.brewery_name = matches.brewery_name) " +
            				"GROUP BY b2.beer_name, b2.brewery_name, b2.style, b2.mouthfeel, b2.color " +
            			") AS results " +
            			"ORDER BY Relevance desc");

                // Execute the query and get the result set.
                ResultSet resultSet = statement.executeQuery(query);
                
                // Results are all columns of Beer sorted by additional Relevance column
                out.println("<tr><td>beer_name</td><td>brewery_name</td><td>style</td><td>mouthfeel</td><td>color</td><td>Relevance</td></tr>");
                while (resultSet.next()) 
                {
                    String beer_name = resultSet.getString("beer_name");
                    String brewery_name = resultSet.getString("brewery_name");
                    String style1 = resultSet.getString("style");
                    String mouthfeel1 = resultSet.getString("mouthfeel");
                    String color = resultSet.getString("color");
                    String relevance = resultSet.getString("Relevance");

                    out.println("<tr><td>" + 
                    beer_name +"</td><td>" + 
                    brewery_name + "</td><td>" + 
                    style1 + "</td><td>" + 
                    mouthfeel1 + "</td><td>" + 
                    color + "</td><td>" + 
                    relevance + "</td></tr>");
                }
	        } 
	        catch (SQLException e) 
	        { 
	        	e.printStackTrace(out);
	        } 
	        finally 
	        {
	            // Close the connection and release the resources used.
	            try { statement.close(); } catch (SQLException e) { e.printStackTrace(out); }
	            try { connect.close(); } catch (SQLException e) { e.printStackTrace(out); }
	            out.close();
	        }
	        
		} 
		catch (IOException e1) 
		{
			e1.printStackTrace();
		}
    }
}

