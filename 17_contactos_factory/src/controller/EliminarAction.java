package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.DaoContactos;
import factories.FactoryDao;
import model.Contacto;

@WebServlet("/EliminarAction")
public class EliminarAction extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		int id= Integer.parseInt(request.getParameter("id"));
		
		DaoContactos dao=FactoryDao.getDaoContactos();
		
		dao.eliminarContacto(id);
		
	}

}
