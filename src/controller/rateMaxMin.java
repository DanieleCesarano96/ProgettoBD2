package controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.LibroBeanDao;

@WebServlet("/rateMaxMin")
public class rateMaxMin extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public rateMaxMin() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      LibroBeanDao libroDao= new LibroBeanDao();
      ArrayList<String> autori=libroDao.groupByAuthors();
      ArrayList<String> case_editrici=libroDao.groupByCasaEditrice();
      
      String autore= request.getParameter("autori4");
      String casa_editrice= request.getParameter("case_editrici4");
      
      ArrayList<Double> rate=libroDao.MaxMinAvg(autore, casa_editrice);
      if(rate!=null)
      {
        String rate_max =rate.get(0)+"";
        String rate_min =rate.get(1)+"";
        request.setAttribute("rate_max",rate_max);
        request.setAttribute("rate_min",rate_min);
        request.setAttribute("autore",autore);
        request.setAttribute("casa_editrice",casa_editrice);
      }
      
      request.setAttribute("autori",autori);
      request.setAttribute("case_editrici",case_editrici);     
  
      request.getRequestDispatcher("queryAnalitiche.jsp").forward(request, response);  
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
