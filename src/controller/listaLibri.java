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


@WebServlet("/listaLibri")
public class listaLibri extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public listaLibri() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	  LibroBeanDao libriDao= new LibroBeanDao();
	  ArrayList<LibroBean> libri= libriDao.getAllBooks();
	  
	  request.setAttribute("libri",libri);
	  request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
