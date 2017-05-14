/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.text.SimpleDateFormat;
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
public class Newuser extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        String id = request.getParameter("id");
        String names = request.getParameter("name");
        String pwds = request.getParameter("pwd");
        String city = request.getParameter("city");
        String mids = request.getParameter("mid");
        String userType = request.getParameter("type");
                
        Date date = new Date(session.getCreationTime());
        SimpleDateFormat ft = new SimpleDateFormat("dd:MM:yyyy");
        String dates = ft.format(date);
        Date time = new Date(session.getCreationTime());
        SimpleDateFormat ftm = new SimpleDateFormat("hh:mm:ss");
        String times = ftm.format(time);
        String pkey=request.getParameter("pkey");




        try {


           
            //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            //Connection con = DriverManager.getConnection("jdbc:odbc:PSE");
          
            
//  //MODIFICATION 1...          
//            Class.forName("com.mysql.jdbc.Driver").newInstance();
//            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/decentralize", "root", "root");
//  //MODIFICATION 1 (END)...    
        	 Connection con = ConnectToDB.getConnection();
            
            PreparedStatement ps=con.prepareStatement("insert into register(id,name,password,city,mail,times,dates,pkey,type)values(?,?,?,?,?,?,?,?,?)");
            //PreparedStatement ps = con.prepareStatement("insert into Reg values ('a','a','a','a','a','a','a')");
            ps.setString(1, id);
            ps.setString(2,names);
            ps.setString(3,pwds);
            ps.setString(4, city);
            ps.setString(5,mids);
            ps.setString(6, times);
            ps.setString(7, dates);
            ps.setString(8, pkey);
            ps.setString(9, userType);
              // ps.setString(9, status);
            int k = ps.executeUpdate();

            if (k != 0) {
                RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
                request.setAttribute("msg1", "Your Account Successfully Registered..");
                rd.forward(request, response);

            } else {
                RequestDispatcher rd = request.getRequestDispatcher("Newuser.jsp");
                request.setAttribute("msg2", "try again");
                rd.forward(request, response);

            }
        }catch(MySQLIntegrityConstraintViolationException ex){
             RequestDispatcher rd=request.getRequestDispatcher("Newuser.jsp");	
			request.setAttribute("msg","Name already exist , please enter different name" );
			rd.forward(request, response);
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
