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

@WebServlet("/findBeer")
public class findBeer extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		ArrayList<String> findBeerInfo = new ArrayList<String>();
		
		findBeerInfo.add(request.getParameter("abvRadio").trim());
		findBeerInfo.add(request.getParameter("mouthRadio").trim());
		findBeerInfo.add(request.getParameter("styleRadio").trim());
		findBeerInfo.add(request.getParameter("colorCode").trim());
		findBeerInfo.add(request.getParameter("minPrice").trim());
		findBeerInfo.add(request.getParameter("maxPrice").trim());
		
		//String[] rating = request.getParameterValues("rateCheck");
		String[] rateCheck = request.getParameterValues("rateCheck");
		
		for(int i = 0; i < rateCheck.length; i++)
		{
			findBeerInfo.add(rateCheck[i]);
		}
		
		
		String name = "Beer name";
		String brewery = "brewry name";
		String color = "color value";
		String price = "$$$";
		
		
        
		/*request.setAttribute("name", name);
		request.setAttribute("brewery", brewery);
		request.setAttribute("style", style);
		request.setAttribute("abv", abv);
		request.setAttribute("color", color);
		request.setAttribute("mouthfeel", mouthfeel);
		request.setAttribute("price", price);
		request.setAttribute("rating", rating);*/
		
		request.getRequestDispatcher("/findBeer.jsp").forward(request, response);
		
		try 
		{
			FindBeerQuery.query(request, response, findBeerInfo);
		} 
		catch (NamingException e) 
		{
			e.printStackTrace();
		}
        
        
        
        
        
    }
}