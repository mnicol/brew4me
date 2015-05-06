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


public class DatabaseQuery 
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
	            
	            if(queryType.equals("beerTableAll"))
	            {
	            	String query = "SELECT * FROM beer";
	
	                // Execute the query and get the result set.
	                ResultSet resultSet = statement.executeQuery(query);
	                while (resultSet.next()) 
	                {
	                    Float abv = resultSet.getFloat("abv");
	                    String beer_name = resultSet.getString("beer_name");
	                    String brewery_name = resultSet.getString("brewery_name");
	                    String style = resultSet.getString("style");
	                    int color = resultSet.getInt("color");
	                    String mouthfeel = resultSet.getString("mouthfeel");
	                    Float price = resultSet.getFloat("price");
	
	                    out.println("<tr><td class='text-center'>" + beer_name +"</td>"
	                    		+ "<td class='text-center'>" + brewery_name +"</td>"
	                    		+ "<td class='text-center'>" + style +"</td>"
	                    		+ "<td class='text-center'>" + abv +"</td>"
	                    		+ "<td class='text-center' bgcolor=" + convertColorCode(color) + ">" + color +"</td>"
	                    		+ "<td class='text-center'>" + mouthfeel +"</td>"
	                    		+ "<td class='text-center'>" + price +"</td></tr>");
	                    
	                }
	            }
	            else if(queryType.equals("beerTableBeers"))
	            {
	            	String query = "SELECT beer_name FROM beer";
	
	                // Execute the query and get the result set.
	                ResultSet resultSet = statement.executeQuery(query);
	                while (resultSet.next()) 
	                {
	                    //Float abv = resultSet.getFloat("abv");
	                    String beer_name = resultSet.getString("beer_name");
	                    //String brewery_name = resultSet.getString("brewery_name");
	                    //String style = resultSet.getString("style");
	                    //int color = resultSet.getInt("color");
	                    //String mouthfeel = resultSet.getString("mouthfeel");
	                    //int price = resultSet.getInt("price");
	
	                    out.println("<tr><td>" + beer_name +"</td></tr>");
	                    
	                }
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

	private static String convertColorCode(int color)
	{
		switch (color) 
		{
	        case 1:  return "#FEE799";
	        case 2:  return "#FDD978";
	        case 3:  return "#FDCB5A";
	        case 4:  return "#FCC143";
	        case 5:  return "#F7B324";
	        case 6:  return "#F5A800";
	        case 7:  return "#EE9E00";
	        case 8:  return "#E69100";
	        case 9:  return "#E38901";
	        case 10:  return "#DA7E01";
	        case 11:  return "#D37400";
	        case 12:  return "#CB6C00";
	        case 13:  return "#C66401";
	        case 14:  return "#BF5C01";
	        case 15:  return "#B65300";
	        case 16:  return "#B04F00";
	        case 17:  return "#AC4701";
	        case 18:  return "#A24001";
	        case 19:  return "#9C3900";
	        case 20:  return "#963500";
	        case 21:  return "#912F00";
	        case 22:  return "#8C2D01";
	        case 23:  return "#832501";
	        case 24:  return "#7E1F01";
	        case 25:  return "#771C01";
	        case 26:  return "#721B00";
	        case 27:  return "#6C1501";
	        case 28:  return "#670F01";
	        case 29:  return "#620F01";
	        case 30:  return "#5B0D01";
	        case 31:  return "#560C03";
	        case 32:  return "#5D0A02";
	        case 33:  return "#500A08";
	        case 34:  return "#4A0605";
	        case 35:  return "#440706";
	        case 36:  return "#420807";
	        case 37:  return "#3C0908";
	        case 38:  return "#390708";
	        case 39:  return "#39080B";
	        case 40:  return "#35090A";
	        default: return "#FFFFFF";
		}
	}
}

