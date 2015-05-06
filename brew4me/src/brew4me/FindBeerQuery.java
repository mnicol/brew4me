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
import java.util.ArrayList;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;


public class FindBeerQuery 
{

    public static void query(HttpServletRequest request, HttpServletResponse response, ArrayList<String> submitInfo) throws NamingException 
    {
        MysqlDataSource ds = null;
        Connection connect = null;
        Statement statement = null;
        int insertSuccess = -1;
        int privlegeSuccess = -1;
        
        // Create a new DataSource (MySQL specifically)
        // and provide the relevant information to be used by Tomcat.
        ds = new MysqlDataSource();
        ds.setUrl("jdbc:mysql://localhost:3306/brew4me");
        ds.setUser("root");
        ds.setPassword("#cs564brew4me");
        
        //Set up the query values
        String tableValues = null;
        
        
        
		try 
		{
			connect = ds.getConnection();
		
	        // Create the statement to be used to get the results.
	        statement = connect.createStatement();
	        
	        //0:email,1:password,2:city,3:state,4:country
	        String findBeerQuery = "SELECT beer.beer_name,beer.brewery_name, style, abv, color, mouthfeel, price, beer_rating "
        						 + "FROM beer,beerrates"
	        					 + " WHERE color BETWEEN min AND max, abv BETWEEN min AND max, price BETWEEN min AND max";
	        
	        // Execute the query and get the result set.
	        ResultSet resultSet = statement.executeQuery(findBeerQuery);
	        
	        while (resultSet.next()) 
	        {
	        	//String count = resultSet.getString("count(1)");
	        	String count = resultSet.getString("count(1)");
	        	/*request.setAttribute("name", name);
	    		request.setAttribute("brewery", brewery);
	    		request.setAttribute("style", style);
	    		request.setAttribute("abv", abv);
	    		request.setAttribute("color", color);
	    		request.setAttribute("mouthfeel", mouthfeel);
	    		request.setAttribute("price", price);
	    		request.setAttribute("rating", rating);*/
	        }
        
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	        
    }
}

