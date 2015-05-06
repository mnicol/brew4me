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


@WebServlet("/QueryBeer")
public class AjaxTestQuery extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		response.setContentType("text/html");
		
	        String QueryType = request.getParameter("userName").trim();
	        
	        try 
	        {
	        	//Creates the query
	        	DatabaseQuery.query(response, QueryType);
            } 
	        catch (NamingException e) 
	        {
                e.printStackTrace();
            }
	      
	        /*response.getWriter()
	         
	        String greetings = "Hello, " + QueryType + "!";
	         
	        response.setContentType("text/plain");
	        response.getWriter().write(greetings);*/
	    }
}