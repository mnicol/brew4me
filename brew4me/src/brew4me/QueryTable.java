/* * * * * * * * * *
 * Status : Used
 * * * * * * * * * */

package brew4me;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLXML;
import java.sql.Statement;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;


public class QueryTable 
{

    public static void query(HttpServletResponse resp, String queryType) throws NamingException {
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
	            
            	String query = "SELECT * FROM " + queryType;

                // Execute the query and get the result set.
                ResultSet resultSet = statement.executeQuery(query);
                
                //SQLXML data = resultSet.getSQLXML(1);
                
                out.println("<table class='table striped bordered hovered' style='width:100%'>"
    			+ "<tr>"
        		+ 	"<th width='13%' class='text-center'>beer_name</th>"
        		+	"<th width='13%' class='text-center'>brewery_name</th>"
        		+	"<th width='13%' class='text-center'>style</th>"
        		+	"<th width='13%' class='text-center'>abv</th>"
        		+	"<th width='13%' class='text-center'>color</th>"
        		+	"<th width='13%' class='text-center'>mouthfeel</th>"
        		+	"<th width='13%' class='text-center'>price</th>"
        		+ "</tr>");
                
                while (resultSet.next()) 
                {
                    Float abv = resultSet.getFloat("abv");
                    String beer_name = resultSet.getString("beer_name");
                    String brewery_name = resultSet.getString("brewery_name");
                    String style = resultSet.getString("style");
                    int color = resultSet.getInt("color");
                    String mouthfeel = resultSet.getString("mouthfeel");
                    Float price = resultSet.getFloat("price");

                    out.println( "<tr class='tableClick'>"
	                    		+ 	"<td width='13%' class='text-center tableClick'>" + beer_name +"</td>"
	                    		+ 	"<td width='13%' class='text-center tableClick'>" + brewery_name +"</td>"
	                    		+ 	"<td width='13%' class='text-center tableClick'>" + style +"</td>"
	                    		+ 	"<td width='13%' class='text-center tableClick'>" + abv +"</td>"
	                    		+ 	"<td width='13%' class='text-center tableClick'>" + color +"</td>"
	                    		+ 	"<td width='13%' class='text-center tableClick'>" + mouthfeel +"</td>"
	                    		+ 	"<td width='13%' class='text-center tableClick'>" + price +"</td>"
                				+ "</tr>");
                    
                }
                
                out.println("</table><br/><hr>");
	            
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

