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


public class UserRoles 
{

    public static void query(HttpServletResponse resp, String email) throws NamingException {
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
	            
            	String query = "SELECT role_name FROM user_roles WHERE email='" + email +"'" ;

                // Execute the query and get the result set.
                ResultSet resultSet = statement.executeQuery(query);
                
                while (resultSet.next()) 
                {
                    String role_name = resultSet.getString("role_name");
                    
                    if(role_name.equalsIgnoreCase("admin"))
                    {
                    	out.print("admin");
                    	return;
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
}

