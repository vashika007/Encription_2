/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mysql.jdbc.Connection;
import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
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
public class blockusr extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public static String key;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            HttpSession session=request.getSession();
         int a=5;
//Cloud Download =>start   
            //session.setAttribute("uname", s);
//            String name=(String) session.getAttribute("uname");
//            String userid=(String) session.getAttribute("uid");
//            
  //error here....          
            //String FName=(String) request.getAttribute("FName");
  //end..
            
            Date now=new Date();
            String na = request.getParameter("snme");
            String acc= request.getParameter("access");
            
//MODIFICATION 1 )...    		
                     
//MODIFICATION 1 )...    		
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/decentralize", "root", "root");
 //MODIFICATION 1 (END)...    
                if(acc.equals("Access"))
                {
              String sa2="Update register set status='normal' where name='"+na+"'";
           // String sa2="update request set Key='"+key+"' where userID='"+user.trim()+"'";
           Statement st2=(Statement) con.createStatement();
            st2.executeUpdate(sa2);
                }
                else
                {
            String sa="Update register set status='block' where name='"+na+"'";
           // String sa2="update request set Key='"+key+"' where userID='"+user.trim()+"'";
           Statement st=(Statement) con.createStatement();
            st.executeUpdate(sa);
                }
            //PreparedStatement pr=con.prepareStatement(sa);
            //ResultSet rs=pr.executeQuery(); 
             
           // String[] radio1=(String[]) request.getAttribute("upload");
            con.close();
//Download status end...             
            
            RequestDispatcher rd=request.getRequestDispatcher("Blockuser.jsp");
		rd.forward(request, response);
             //Date d=(Date) request.getAttribute("TDate");       
          }
        catch(Exception e)
        {
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
