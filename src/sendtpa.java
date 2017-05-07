/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class sendtpa extends HttpServlet {

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
        
        String name= request.getParameter("uname");
        String pwd = request.getParameter("password");
        String cts=request.getParameter("cmds");
   //session.setAttribute("uname", name);
        
        try {
            //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            //Connection con = DriverManager.getConnection("jdbc:odbc:PSE");
          
            
  //MODIFICATION 1...          
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/decentralize", "root", "root");
  //MODIFICATION 1 (END)...          
            PreparedStatement ps=con.prepareStatement("insert into blockreq(name,password,message)values(?,?,?)");
            //PreparedStatement ps = con.prepareStatement("insert into Reg values ('a','a','a','a','a','a','a')");
            ps.setString(1,name);
            ps.setString(2,pwd);
            ps.setString(3,cts);
            int k = ps.executeUpdate();
            if (k != 0) {
                RequestDispatcher rd = request.getRequestDispatcher("Home.jsp");
                request.setAttribute("msg1", "Your requesr send Successfully..");
                rd.forward(request, response);

            } else {
                RequestDispatcher rd = request.getRequestDispatcher("contacttpa.jsp");
                request.setAttribute("msg2", "try again");
                rd.forward(request, response);

            }
            con.close();
ps.close();
        }
        
        catch (Exception e) {
           // e.printStackTrace();
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
