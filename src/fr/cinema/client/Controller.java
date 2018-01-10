package fr.cinema.client;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.websocket.Session;

@WebServlet("/Controller")
public class Controller extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    public Controller() 
    {
        super();
        // TODO Auto-generated constructor stub
    }
    
    private void entry(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException
    {
    		request.getRequestDispatcher("/WEB-INF/index.html");
    }
    
    private void indexAction(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException
    {
    		request.getRequestDispatcher("/WEB-INF/movies.jsp");
    }
    
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		String url = request.getRequestURI();
		
		switch (url)
		{
			case "/WebServicesProjectCinema/project/":
			entry(request, response, session);
			break;
			
			case "":
			break;
			
			default:
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void loginAction(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException 
	{
		if (request.getParameter("login") != null)
		{
			if (request.getParameter("email").equals("email") && request.getParameter("password").equals("password"))
			{
				session.setAttribute("logged", true);
				response.sendRedirect("/WebServices/project/login");
				
			}
			else
			{
				request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
			}
		}
		else
		{
			request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
		}
	}
	
	private void movieAction(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException 
	{
		request.getRequestDispatcher("/WEB-INF/movie.jsp").forward(request, response);
	}
	
	private void n(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException
	{
		
	}
}
