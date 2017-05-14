
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
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
public class Login2 extends HttpServlet {

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
	// static String a1,a2;
	// static String b1,b2;
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String s1 = request.getParameter("uid").trim();
		String s2;
		String p = request.getParameter("pwd").trim();
		String c = request.getParameter("type");
		boolean result = false;
		HttpSession session = request.getSession();

		try {
			
			Connection con = ConnectToDB.getConnection();
			// MODIFICATION 1 (END)...
			String sa = "select * from register where id='" + s1 + "' and password='" + p + "' and type='" + c + "'";
			PreparedStatement pr = con.prepareStatement(sa);
			ResultSet rs = pr.executeQuery();
			if (rs.next()) {
				// if(s.equals(rs.getString(2))&&p.equals(rs.getString(3)))
				{
					String name1 = rs.getString(1);
					String name2 = rs.getString(2);

					s1 = name1;
					s2 = name2;
					session.setAttribute("uname1", s2);
					session.setAttribute("uid1", s1);
					session.setAttribute("pwd", p);
					session.setAttribute("userType", c);
					result = true;
					// break;
				}
				/*
				 * if(c.equals("admin")) { RequestDispatcher
				 * rd=request.getRequestDispatcher("Admins.jsp");
				 * rd.forward(request, response); } else if(c.equals("user")) {
				 * RequestDispatcher
				 * rd=request.getRequestDispatcher("Admin.jsp");
				 * rd.forward(request, response); }
				 */

			}
			if (result)

			{
				if (c.equals("admin")) {
					// RequestDispatcher
					// rd=request.getRequestDispatcher("Admins.jsp");
					// rd.forward(request, response);
				} else if (c.equals("user") || c.equals("doctor") || c.equals("lab")) {
					String query = "select * from register where id='" + s1 + "' and password='" + p + "'";
					PreparedStatement preStm = con.prepareStatement(query);
					ResultSet resultSet = preStm.executeQuery();
					if (resultSet.next()) {
						RequestDispatcher rd = request.getRequestDispatcher("Viewprofile.jsp");
						request.setAttribute("msg1", "Login Successfully..!");
						rd.forward(request, response);
					} else {
						RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
						request.setAttribute("msg", "Access denied for the user,Contact ADMINISTRATOR");
						rd.forward(request, response);
					}

				}

			} else {
				RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
				request.setAttribute("msg", "please enter valid user name and password");
				rd.forward(request, response);
			}

		}

		catch (Exception e) {
			e.printStackTrace();
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
