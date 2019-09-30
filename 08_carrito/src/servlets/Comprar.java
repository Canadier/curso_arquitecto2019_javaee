package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Producto;


@WebServlet("/Comprar")
public class Comprar extends HttpServlet {
	

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		HttpSession sesion = request.getSession();

		List<Producto> cesta = (List<Producto>) sesion.getAttribute("cesta");

		if (cesta == null) {
			cesta = new ArrayList<Producto>();

			sesion.setAttribute("cesta", cesta);

		}

		String descripcion = request.getParameter("nombre");
		int unidades = Integer.parseInt(request.getParameter("unidades"));
		double precio = Double.parseDouble(request.getParameter("precio"));

		cesta.add(new Producto(descripcion, unidades, precio));

		request.getRequestDispatcher("opciones.html").forward(request, response);

	}
}
