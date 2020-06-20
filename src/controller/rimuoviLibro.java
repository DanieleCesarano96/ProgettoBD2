package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.LibroBean;
import model.LibroBeanDao;

@WebServlet("/modificaLibro")
public class rimuoviLibro extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public rimuoviLibro() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	  Object bookID = request.getAttribute("bookID");
	  
	  LibroBeanDao libriDao = new LibroBeanDao();
	  libriDao.eliminaLibro(bookID);
	  
	  ArrayList<LibroBean> libri= libriDao.getAllBooks();    
      request.setAttribute("libri",libri);
      request.getRequestDispatcher("HomePage.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
