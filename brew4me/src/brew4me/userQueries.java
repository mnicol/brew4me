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


public class userQueries 
{

    public static void query(HttpServletResponse resp, String[] formInfo) throws NamingException {
        MysqlDataSource ds = null;
        Connection connect = null;
        Statement statement = null;
        int insertSuccess = -1;
        int privlegeSuccess = -1;
        
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
	            
	            //0:email,1:password,2:city,3:state,4:country
	            String checkNewUser = "SELECT count(1) FROM person WHERE email='" + formInfo[0] + "'";
                
	            // Execute the query and get the result set.
	            ResultSet resultSet = statement.executeQuery(checkNewUser);
                
                while (resultSet.next()) 
                {
                	//String count = resultSet.getString("count(1)");
                	String count = resultSet.getString("count(1)");
                	
                	if(count.equals("1"))
                	{
                		out.write("{\"emailExists\":true,\"insertSuccess\":" + insertSuccess + ",\"privlegeSuccess\":" + privlegeSuccess + "}");
                		return;
                	}
                	else
                	{
                		String insertUser = "INSERT IGNORE INTO person (email, name, password, city, state_providence, country) VALUES ('" + formInfo[0] + "', '" + formInfo[1] +  "', '" + formInfo[2] +  "', '" + formInfo[3] +  "', '" + formInfo[4] +  "', '" + formInfo[5] +  "')";
                		insertSuccess = statement.executeUpdate(insertUser);
                		
        	            String givePrivlege ="INSERT IGNORE INTO user_roles (email, role_name) VALUES ('"+ formInfo[0] + "', 'user')";
        	            privlegeSuccess = statement.executeUpdate(givePrivlege);
        	            
        	            out.write("{\"emailExists\":false,\"insertSuccess\":" + insertSuccess + ",\"privlegeSuccess\":" + privlegeSuccess + "}");
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
	        
	        out.flush();
	        out.close();
	        
		} 
		catch (IOException e1) 
		{
			e1.printStackTrace();
		}
    }
}

