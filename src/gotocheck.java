/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import Encryption.Java_Encryption1;
import Encryption.KeyGenerator;
import PropertyLoaders.PropertyLoader;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.*;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author jemi java
 */
public class gotocheck extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public static String path;
    public static String fname;
    public static String full_path;
//    public static String key_value;
    String username=null;
    String f="";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session=request.getSession();
         username=(String)session.getAttribute("uname");
         

        try {
            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Log</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Log at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
             */
        } finally {
            out.close();
        }
    }
    
    
    //Folder changes 1%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%   
    // private final String UPLOAD_DIRECTORY = "C:/Users/jemi java/Desktop/upload";
    
    
    private String UPLOAD_DIRECTORY = "";
//Folder changes 1%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%    

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
        String name = null;
        String con = null;
      //  char c;
     //Modification 1       
        
        Properties properties = PropertyLoader.getProperties();
                            String uploadPaaht = properties.getProperty("uploadpathOriginal");
                            System.out.println("uploadPaaht" +uploadPaaht);
                            UPLOAD_DIRECTORY = uploadPaaht;
        HttpSession session = request.getSession();
//        key_value = (String) session.getAttribute("UKey");
        //Modification 1  END     
        char content = 0;
        //process only if its multipart content
        if (ServletFileUpload.isMultipartContent(request)) {
            try {
                List<FileItem> multiparts = new ServletFileUpload(
                        new DiskFileItemFactory()).parseRequest( request);

                for (FileItem item : multiparts) {
                    if (!item.isFormField()) {
                        name = new File(item.getName()).getName();
                        
                        item.write(new File(UPLOAD_DIRECTORY + File.separator + name));
                        //Passing value for encryption and upload
                        String path_name = UPLOAD_DIRECTORY + File.separator + name;
                        ServletContext s = getServletContext();
                        String FSepa = (String) File.separator;
                        s.setAttribute("FPath", "UPLOAD_DIRECTORY");
                        //s.setAttribute("FSepa, "FSepa");
                        s.setAttribute("FName", "name");
                        s.setAttribute("Owner", "Government");
                        Java_Encryption1 j = new Java_Encryption1();
                        path = UPLOAD_DIRECTORY;
                        fname = name;
                        full_path = UPLOAD_DIRECTORY + File.separator + name;
                        // FileReader ob=new FileReader("D:/file/file1/Req");
//                         ob.toString();
                        //System.out.println(ob.toString());
                        // BufferedReader b= new BufferedReader();
                        File ob = new File(full_path.trim());
                       //                         ob.toString();
                        //System.out.println(ob.toString());
                        // BufferedReader b= new BufferedReader();
//                        File ob = new File(full_path.trim());
//                        System.out.print(ob.toString());
//                        //System.out.println("hllo sir");
//                        FileInputStream fis = null;
//                        fis = new FileInputStream(ob);
//                        String onn=fis.toString();
//                        String on=onn;
//                        int i;
//                        StringBuilder sb=new StringBuilder();
//                         System.out.println(fis.toString());
//                        while ((i = fis.read()) != -1) {
//
//                            System.out.print((char) i);
//                         sb.append((char)i);
//                             
//                            System.out.print(sb.toString());
//                        }
//                        fis.close();
//                         System.out.println(ob.toString());
//                         String b=sb.toString();// file content store
                        // System.out.println(ob.toString());

                        check c = new check();
                        // c.check(fname);
                        boolean p = c.check(fname);
                        if (p == true) {
                           
                                   request.setAttribute("id1",  "File Name Already Exists...");
                            request.getRequestDispatcher("Deduplication.jsp").forward(request, response);
                          break;
                        }
                        boolean n = c.check1(full_path.trim());
                        
                        if (n == true) {
                            request.setAttribute("id1", "File Name is Different But File Contents are Same...");
                            request.getRequestDispatcher("Deduplication.jsp").forward(request, response);
                            break;
                        }else{
                           con=c.fun(full_path.trim()); 
                        }


                        //HttpSession session=request.getSession();
                        String userName = (String) session.getAttribute("uname1");
                        f = KeyGenerator.generateRandomString(16);
//Random rd=new Random();
//        int f2=rd.nextInt(100000000);
//         f=Integer.toString(f2);
                        j.fun(path, fname, full_path,con,f,userName);
                    }
                }

                //File uploaded successfully
                request.setAttribute("message", "File Uploaded Successfully");
            } catch (Exception ex) {
                request.setAttribute("message", "File Upload Failed due to " + ex);
                ex.printStackTrace();
            }

        } else {
            request.setAttribute("message", "Sorry this Servlet only handles file upload request");
        }

        //     request.getRequestDispatcher("UploadList.jsp").forward(request, response);
        request.setAttribute("fname", fname);
        
        session.setAttribute("skey", f);
         request.getRequestDispatcher("encryption.jsp").forward(request, response);
        ///Insert commands:
 /*        try {
        
        
        
        String s="hai";
        DbConnection d=new DbConnection();
        PreparedStatement ps=(PreparedStatement) d.con.prepareStatement("insert into File(userid,FileName)values('"+s+"','"+name+"')");
        int k = ps.executeUpdate();        
        /*                
        PreparedStatement ps=con.prepareStatement("insert into Reg(userid,name,password,city,mail,time,date)values(?,?,?,?,?,?,?)");
        //PreparedStatement ps = con.prepareStatement("insert into Reg values ('a','a','a','a','a','a','a')");
        ps.setString(1, id);
        ps.setString(2,names);
        ps.setString(3,pwds);
        ps.setString(4, city);
        ps.setString(5,mids);
        ps.setString(6, dates);
        ps.setString(7, times);
        int k = ps.executeUpdate();         
         */


        /*       } catch (ClassNotFoundException ex) {
        Logger.getLogger(Log.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
        Logger.getLogger(Log.class.getName()).log(Level.SEVERE, null, ex);
        }
         */





        ///Inser (End)    


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
