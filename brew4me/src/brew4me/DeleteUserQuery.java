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


public class DeleteUserQuery 
{

    public static void query(HttpServletResponse response, String email) throws NamingException 
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
        
		try 
		{
			connect = ds.getConnection();
		
	        // Create the statement to be used to get the results.
	        statement = connect.createStatement();
	        
	        //0:email,1:password,2:city,3:state,4:country
	        String deleteUser = "DELETE FROM person WHERE email='" + email + "'";
	        
	        // Execute the query and get the result set.
	        int queryResponse = statement.executeUpdate(deleteUser);
	        
	        deleteUser = "DELETE FROM user_roles WHERE email='" + email + "'";
	        
	        queryResponse = statement.executeUpdate(deleteUser);
	        
        
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	        
    }
}

