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

@WebServlet("/insert-movie")
@MultipartConfig
public class Insert extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("insert.html").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String movieName=req.getParameter("M_Name");
		String movieLanguage=req.getParameter("L_Name");
		Part picture = req.getPart("image");
		String genre= req.getParameter("Genre");
		try {
			double rating=Double.parseDouble(req.getParameter("Rating"));
			Movie movie = new Movie();
			movie.setGenre(genre);
			movie.setName(movieName);
			movie.setLanguage(movieLanguage);
			movie.setRating(rating);
			
			byte[] image= new byte[picture.getInputStream().available()];
			picture.getInputStream().read(image);
			
			movie.setImage(image);
			
			MovieDao dao = new MovieDao();
			dao.saveMovie(movie);
			
			resp.getWriter().print("<h1 align='center'> Hey Boss Movie Saved Successfully!! </h1>");
			req.getRequestDispatcher("home.html").include(req, resp);
			if (movieLanguage == null || genre == null) {
				resp.getWriter().print("<h1 align='center'> Please select Language and Genre </h1>");
				req.getRequestDispatcher("insert.html").include(req, resp);
			}
			else {
				resp.getWriter().print("Hii Your Movie is: "+ movieName +"with Language: "+movieLanguage+" which have IMDB rating: "+rating+" "+ picture + " "+ genre);
			}
		} catch (NumberFormatException e) {
			resp.getWriter().print("<h1 align='center'> Please Entre Correct Rating in numbers </h1>");
			req.getRequestDispatcher("insert.html").include(req, resp);
		}
		
		
		
		
	}
}
