package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Producto;

@WebServlet("/Vaciar")
public class Vaciar extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sesion = request.getSession(); 
		if(!sesion.isNew()) {
			((List<Producto>)sesion.getAttribute("cesta")).clear();
		}
		
		request.getRequestDispatcher("opciones.html").forward(request, response);
		
	}

}
