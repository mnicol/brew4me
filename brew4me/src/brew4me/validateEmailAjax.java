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

@WebServlet("/validateEmail")
public class validateEmailAjax extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		 
		response.setContentType("json");//setContentType("text/html");
        
		String email = request.getParameter("email");
        
        try 
        {
        	//Creates the query
        	validateQuery.query(response, email);
        } 
        catch (NamingException e) 
        {
            e.printStackTrace();
        }
    }
}