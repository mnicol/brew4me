/* * * * * * * * * *
 * Status : No Used (only for an example)
 * * * * * * * * * */

package brew4me;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class javaForm extends HttpServlet 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
	{
		resp.getWriter().println("You Used GET!\n");
		
		String uname = req.getParameter("username");
		String email = req.getParameter("useremail");
		
		resp.getWriter().println("<br/>Username: " + uname + "<br/>Email: " + email);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		resp.getWriter().println("You Used POST!\n");
		
		String uname = req.getParameter("username");
		String email = req.getParameter("useremail");
		
		resp.getWriter().println("<br/>Username: " + uname + "<br/>Email: " + email);
	}
}
