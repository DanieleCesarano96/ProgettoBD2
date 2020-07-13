package controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.LibroBeanDao;

@WebServlet("/caricamentoGroup")
public class caricamentoGroup extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public caricamentoGroup() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      LibroBeanDao libroDao= new LibroBeanDao();
      ArrayList<String> autori=libroDao.groupByAuthors();
      ArrayList<String> case_editrici=libroDao.groupByCasaEditrice();
      
      request.setAttribute("autori",autori);
      request.setAttribute("case_editrici",case_editrici);
      
      request.getRequestDispatcher("queryAnalitiche.jsp").forward(request, response);  
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
