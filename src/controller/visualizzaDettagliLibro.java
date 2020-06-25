package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.LibroBean;
import model.LibroBeanDao;

@WebServlet("/visualizzaDettagliLibro")
public class visualizzaDettagliLibro extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public visualizzaDettagliLibro() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  Object bookID = request.getParameter("bookID");
	  
      LibroBeanDao libriDao = new LibroBeanDao();
	  LibroBean libro = libriDao.getLibro(bookID);
	  
	  request.setAttribute("libro",libro);
	  request.getRequestDispatcher("visualizzaDettagliLibro.jsp").forward(request, response);  
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
