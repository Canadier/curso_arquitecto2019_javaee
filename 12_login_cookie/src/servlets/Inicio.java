package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Persona;

@WebServlet("/Inicio")
public class Inicio extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd;
		
		String user=recuperarCookie(request);
		
		if(user!=null) {
			Persona persona = new Persona(user, "prueba@pepe.com",44);
			
			HttpSession sesion = request.getSession();
			sesion.setAttribute("persona", persona);
			
			rd = request.getRequestDispatcher("preferencias.html");
		}else {
			rd = request.getRequestDispatcher("formulario.html");
		}		
		
		rd.forward(request, response);
	}

	private String recuperarCookie(HttpServletRequest request){
		String res=null;
		Cookie[] allCookies=request.getCookies();
		if(allCookies!=null){
			for(Cookie c:allCookies){
				if(c.getName().equals("usuario")){
					res=c.getValue();
				}
			}
		}
		return res;
	}
}
