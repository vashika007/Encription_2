
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jemi java
 */
public class allow extends HttpServlet {

	/**
	 * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
	 * methods.
	 * 
	 * @param request
	 *            servlet request
	 * @param response
	 *            servlet response
	 * @throws ServletException
	 *             if a servlet-specific error occurs
	 * @throws IOException
	 *             if an I/O error occurs
	 */
	public static String key;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		try {
			HttpSession session = request.getSession();
			int a = 5;
			// Cloud Download =>start
			// session.setAttribute("uname", s);
			String name = (String) session.getAttribute("uname");
			String userid = (String) session.getAttribute("uid");

			// error here....
			// String FName=(String) request.getAttribute("FName");
			// end..

			Date now = new Date();
			String FileName = request.getParameter("s1");

			FileName = (String) session.getAttribute("fname");
			System.out.println("FileName" + FileName);
			// String user= request.getParameter("UseID");

			// MODIFICATION 1 )...
			// Class.forName("com.mysql.jdbc.Driver").newInstance();
			// Connection con1 = (Connection)
			// DriverManager.getConnection("jdbc:mysql://localhost:3306/decentralize",
			// "root", "root");
			// //MODIFICATION 1 (END)...
			//
			// String sa1="select * from files where
			// Filename='"+FileName.trim()+"'";
			// PreparedStatement pr1=con1.prepareStatement(sa1);
			// ResultSet rs1=pr1.executeQuery();
			// if (rs1.next())
			// {
			// key=rs1.getString(10);
			//
			// }
			// con1.close();
			// pr1.close();
			//// MODIFICATION 1 )...
			// Class.forName("com.mysql.jdbc.Driver").newInstance();
			// Connection con = (Connection)
			// DriverManager.getConnection("jdbc:mysql://localhost:3306/decentralize",
			// "root", "root");
			// MODIFICATION 1 (END)...
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://mysqlhost:3306/decentralize", "admin", "admin");
			String sa2 = "Update files set auditor='verified' where filename='" + FileName + "'";
			// String sa2="update request set Key='"+key+"' where
			// userID='"+user.trim()+"'";
			Statement st2 = (Statement) con.createStatement();
			int i = st2.executeUpdate(sa2);
			// PreparedStatement pr=con.prepareStatement(sa);
			// ResultSet rs=pr.executeQuery();

			// String[] radio1=(String[]) request.getAttribute("upload");

			// Download status end...
			if (i != 0) {
				RequestDispatcher rd = request.getRequestDispatcher("Accessfile.jsp");
				rd.forward(request, response);
				con.close();
				// Date d=(Date) request.getAttribute("TDate");
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("Accessfile.jsp");
				rd.forward(request, response);
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			out.close();
		}
	}

	// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on
	// the + sign on the left to edit the code.">
	/**
	 * Handles the HTTP <code>GET</code> method.
	 * 
	 * @param request
	 *            servlet request
	 * @param response
	 *            servlet response
	 * @throws ServletException
	 *             if a servlet-specific error occurs
	 * @throws IOException
	 *             if an I/O error occurs
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * Handles the HTTP <code>POST</code> method.
	 * 
	 * @param request
	 *            servlet request
	 * @param response
	 *            servlet response
	 * @throws ServletException
	 *             if a servlet-specific error occurs
	 * @throws IOException
	 *             if an I/O error occurs
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * Returns a short description of the servlet.
	 * 
	 * @return a String containing servlet description
	 */
	@Override
	public String getServletInfo() {
		return "Short description";
	}// </editor-fold>
}
