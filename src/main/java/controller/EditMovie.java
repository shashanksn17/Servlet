package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.MovieDao;
import dto.Movie;

@WebServlet("/edit-movie")
@MultipartConfig
public class EditMovie extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		MovieDao dao= new MovieDao();
		Movie movie= dao.fetchObject(id);
		req.setAttribute("Movie", movie);
		req.getRequestDispatcher("edit-movie.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String movieName=req.getParameter("M_Name");
		String movieLanguage=req.getParameter("L_Name");
		Part picture = req.getPart("image");
		String genre= req.getParameter("Genre");
		int id= Integer.parseInt(req.getParameter("id"));
		MovieDao dao = new MovieDao();
		try {
			double rating=Double.parseDouble(req.getParameter("Rating"));
			Movie movie = dao.fetchObject(id);
			movie.setGenre(genre);
			movie.setName(movieName);
			movie.setLanguage(movieLanguage);
			movie.setRating(rating);
			
			byte[] image= new byte[picture.getInputStream().available()];
			picture.getInputStream().read(image);
			
			if(image.length>0)
			movie.setImage(image);
			
			
			dao.updateMovie(movie);
			
			resp.getWriter().print("<h1 align='center'> Hey Boss Movie Updated Successfully!! </h1>");
			req.getRequestDispatcher("home.html").include(req, resp);
		} catch (NumberFormatException e) {
			resp.getWriter().print("<h1 align='center'> Please Entre Correct Rating in numbers </h1>");
			req.getRequestDispatcher("insert.html").include(req, resp);
		}
	}
}
