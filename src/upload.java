/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import Encryption.AuthenticateUser;
import Encryption.ChunkingFile;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class upload extends HttpServlet {

    public static String full_path;
    private String fileName;
    String flname="";

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            HttpSession session = request.getSession();
               String name = (String) session.getAttribute("uname");
            String userid = (String) session.getAttribute("uid");
            String FName = (String) request.getAttribute("FName");
            Date now = new Date();
            
             String ky = (String) request.getParameter("key");
             String fnm = (String) request.getParameter("fn");
             String assignee = (String) request.getParameter("assignee");
             
//            Class.forName("com.mysql.jdbc.Driver").newInstance();
//            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/decentralize", "root", "root");
             Class.forName("com.mysql.jdbc.Driver").newInstance();
             Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://172.30.96.167:3306/decentralize", "admin", "admin");
            String sa = "update files set key1='"+ky+"' where filename='"+fnm+"'";
            PreparedStatement pr = con.prepareStatement(sa);
           int i = pr.executeUpdate();
           if (i!=0) {
                //Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/decentralize", "root", "root");
            String sa1 = "select * from files where filename='"+fnm+"'";
            PreparedStatement pr1 = con.prepareStatement(sa1);
           ResultSet rs = pr1.executeQuery(sa1);
           if (rs.next()) 
           {
               full_path = rs.getString(1);
               flname = rs.getString(2);
            }
           }
            File file = new File(full_path);
            //file=full_path;
            fileName = (String) full_path;
          //  AuthenticateUser.main();
            FileOutputStream fos1 = null;
//             FileOutputStream fos2 = null;
//              FileOutputStream fos3 = null;
//              FileOutputStream fos4 = null;
            try {
                //Getting the chunked contents
                String[] getContents = ChunkingFile.main(file);
                System.out.println("File Contents");
                System.out.println(getContents[0]);
                //Uploading file and Create temp file
                File f1 = new File(file.getAbsolutePath());
                /*
                File f2 = new File("c:\\part2\\" + fileName.getText());
                File f3 = new File("c:\\part3\\" + fileName.getText());
                File f4 = new File("c:\\part4\\" + fileName.getText());
                 */
                fos1 = new FileOutputStream(f1);
                    //fos2 = new FileOutputStream(f1);
                    //fos3 = new FileOutputStream(f1);
                   //fos4 = new FileOutputStream(f1);
                try {
                    fos1.write(getContents[0].getBytes());
                  //  AuthenticateUser.upload(f1, "Decentralize");
                    fos1.close();
                    //         f1.delete();
                    // fos.write("".getBytes());
//                    fos2.write(getContents[1].getBytes());
//                    AuthenticateUser.upload(f1, "Cloud Server 2");
//                   fos2.close();
//                    //          f1.delete();
//                    //f2.delete();
//                    //  fos3.write("".getBytes());
//                    fos3.write(getContents[2].getBytes());
//                    AuthenticateUser.upload(f1, "Cloud Server 3");
//                   fos3.close();
//                    //          f1.delete();
//                    // f3.delete();
//                    //   fos.write("".getBytes());
//                    fos4.write(getContents[3].getBytes());
//                    AuthenticateUser.upload(f1, "Cloud Server 4");
//                    fos4.close();
                    //          f1.delete();
                    //f4.delete();
                    //MODIFICATION 3 )...    	            
//                    String owner = null, FileName = null, key1 = null;
//                    try {
//                        //select  
//                        Class.forName("com.mysql.jdbc.Driver").newInstance();
//                        Connection con1 = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/cloud", "root", "root");
//                        String sa1 = "select * from files where Userid='" + userid.trim() + "' and Filename='" + r + "'";
//                        PreparedStatement pr1 = con1.prepareStatement(sa1);
//                        ResultSet rs1 = pr1.executeQuery();
//                        if (rs1.next()) {
//                            owner = rs1.getString(1);
//                            FileName = rs1.getString(3);
//                            key1 = rs1.getString(10);
//                        }
//                        con1.close();
//                        pr1.close();
//                        //inser 
//                        Class.forName("com.mysql.jdbc.Driver").newInstance();
//                        Connection con2 = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/cloud", "root", "root");
//                        String sql = "insert into userkey values('" + FileName + "','" + owner + "','" + key1 + "','null','null','null','null','null')";
//                        PreparedStatement ps = con2.prepareStatement(sql);
//                        int noOfRows = ps.executeUpdate();
//                        con2.close();
//                        ps.close();
//
//
//                    } catch (Exception ee) {
//                        System.out.println(ee);
//                    }
                    //MODIFICATION 3 (END)...         
fos1.close();

                } catch (IOException ex) {
                    System.out.println(ex);
                    ex.printStackTrace();

                }
            } 
                catch (Exception ex1) {
                    ex1.printStackTrace();
                     System.out.println(ex1);
                }
                
            /************CLOUD ENDING*/
//MODIFICATION 1 )...    		            
            // Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            // Connection con1 = DriverManager.getConnection("jdbc:odbc:PSE");
//            Class.forName("com.mysql.jdbc.Driver").newInstance();
//            Connection con1 = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/decentralize", "root", "root");
//            //MODIFICATION 1 (END)...               
            //PreparedStatement ps=con.prepareStatement("update File1 set Upload='Uploaded' where userid='"+userid+"' and FileName='"+radio1+"'");
            String sa2 = "update files set status='Uploaded' where filename ='" + flname + "' and filepath='" + full_path + "'";//+radio1.trim()+"'";
           PreparedStatement pr2=con.prepareStatement(sa2);
            int k=pr2.executeUpdate(sa2);
            if(k!=0)
            {
                session.setAttribute("fileName",flname);
                session.setAttribute("fileKey", ky);
                session.setAttribute("assignee",assignee);
           RequestDispatcher rd = request.getRequestDispatcher("request");
            rd.forward(request, response);
        } 
             con.close();
        }
        
        catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(upload.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(upload.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);





        } catch (ClassNotFoundException ex) {
            Logger.getLogger(upload.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(upload.class.getName()).log(Level.SEVERE, null, ex);
        }
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
