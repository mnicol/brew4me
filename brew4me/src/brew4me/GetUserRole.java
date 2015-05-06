/* * * * * * * * * *
 * Status : Used
 * * * * * * * * * */

package brew4me;

import java.io.IOException;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;


@WebServlet("/getUserRole")
public class GetUserRole extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		response.setContentType("text/html");
		
	        String userEmail = request.getParameter("email").trim();
	        
	        try 
	        {
	        	//Creates the query
	        	UserRoles.query(response, userEmail);
            } 
	        catch (NamingException e) 
	        {
                e.printStackTrace();
            }
	    }
}