/* * * * * * * * * *
 * Status : Used
 * * * * * * * * * */

package brew4me;

import java.io.IOException;
import java.util.ArrayList;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/deleteUser")
public class DeleteUser extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String email = request.getParameter("email").trim();
		
		
		try 
		{
			if(!email.equalsIgnoreCase("guest"))
			{
				DeleteUserQuery.query(response, email);
			}
		} 
		catch (NamingException e) 
		{
			e.printStackTrace();
		}
    }
}