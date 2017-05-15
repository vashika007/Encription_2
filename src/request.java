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
public class request extends HttpServlet {

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
        try {
            HttpSession session=request.getSession();
         int a=5;
//Cloud Download =>start   
            //session.setAttribute("uname", s);
            String name=(String) session.getAttribute("uname1");
            String userid=(String) session.getAttribute("uid1");
            String fileKey = (String) session.getAttribute("fileKey");
            
            String assignee = (String) session.getAttribute("assignee");
            
  //error here....          
            //String FName=(String) request.getAttribute("FName");
  //end..
           
            Date now=new Date();
            String radio1= (String)session.getAttribute("fileName");
            
//Request status updation...
  //MODIFICATION 1 )...    		
//                Class.forName("com.mysql.jdbc.Driver").newInstance();
//                Connection con1 = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/decentralize", "root", "root");
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con1 = (Connection) DriverManager.getConnection("jdbc:mysql://172.30.214.173:3306/decentralize", "admin", "admin");
 //MODIFICATION 1 (END)...               

            //PreparedStatement ps=con.prepareStatement("update File1 set Upload='Uploaded' where userid='"+userid+"' and FileName='"+radio1+"'");
            //String sa2="update userkey set Request='Sent',DRequest='"+now+"' where userid='"+userid.trim()+"' and FileName='"+radio1+"'";//+radio1.trim()+"'";
            //
            
            String sa="insert into requestst values('"+userid+"','"+name+"','"+radio1+"','"+fileKey+"','Sent','"+now+"','Done','"+assignee+"','Empty')";
            PreparedStatement ps = con1.prepareStatement(sa);
            int noOfRows = ps.executeUpdate();
           
        if(noOfRows!=0)
        {
             
//Download status end...             
            
            RequestDispatcher rd=request.getRequestDispatcher("Viewprofile.jsp");
            session.setAttribute("success", "success");
		rd.forward(request, response);
             //Date d=(Date) request.getAttribute("TDate");
             
              con1.close();
            ps.close();
          
        }
        else 
        {
           RequestDispatcher rd=request.getRequestDispatcher("Fileview.jsp");
		rd.forward(request, response); 
        }
        }
        catch(Exception e)
        {
            System.out.println(e);
                    
        }
             
         finally {            
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
