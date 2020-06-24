package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.LibroBean;
import model.LibroBeanDao;

@WebServlet("/modificaLibro")
public class modificaLibro extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public modificaLibro() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	  LibroBean libro = new LibroBean(request.getParameter("bookID"),request.getParameter("titolo"),
	      request.getParameter("autore"),Double.parseDouble(request.getParameter("valutazioneMedia")),
	      request.getParameter("isbn"),request.getParameter("isbn13"),request.getParameter("lingua"),
	      Integer.parseInt(request.getParameter("numeropagine")),Integer.parseInt(request.getParameter("numerovalutazioni")),
	      Integer.parseInt(request.getParameter("numerorevisioni")),request.getParameter("dataPublicazione"),
	      request.getParameter("casaEditrice")); 
	  
	  LibroBeanDao libroDao= new LibroBeanDao();
	  libroDao.modificaLibro(libro);
	  
	  request.getRequestDispatcher("index.jsp").forward(request, response);   
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
