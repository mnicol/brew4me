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

@WebServlet("/QueryUser")
public class addUserPost extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		 
		response.setContentType("json");//setContentType("text/html");
		response.sendRedirect("/brew4me/login.html");
        
		String[] submitValues = new String[6];
		submitValues[0] = request.getParameter("email");
		submitValues[1] = request.getParameter("name");
		submitValues[2] = request.getParameter("password");
		submitValues[3] = request.getParameter("city");
		submitValues[4] = request.getParameter("state_providence");
		submitValues[5] = request.getParameter("country");
        
        try 
        {
        	//Creates the query
        	userQueries.query(response, submitValues);
        	
        } 
        catch (NamingException e) 
        {
            e.printStackTrace();
        }
    }
}