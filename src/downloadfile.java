import Encryption.Java_Decryption;
import PropertyLoaders.PropertyLoader;
import java.sql.*;
import com.mysql.jdbc.Connection;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Properties;
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
public class downloadfile extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public static int process=0;
    private static void copyFileUsingFileStreams(String source, String dest) throws IOException 
    {
    FileInputStream input = null;
    FileOutputStream output = null;
    try {
        input = new FileInputStream(source);
        output = new FileOutputStream(dest);
        byte[] buf = new byte[1024];
        int bytesRead;
        while ((bytesRead = input.read(buf)) > 0) {
            output.write(buf, 0, bytesRead);
        }
    } finally {
        input.close();
        output.close();
    }
}
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse httpResponse)
            throws ServletException, IOException {
        HttpServletResponse response = httpResponse;
        //response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session=request.getSession();
        try { 
         int a=5;
         process=0;
//Cloud Download =>start   
            //session.setAttribute("uname", s);
            String name=(String) session.getAttribute("uname1");
            String userid=(String) session.getAttribute("uid1");
            
  //error here....          
            //String FName=(String) request.getAttribute("FName");
  //end..
            
            Date now=new Date();
            String File= request.getParameter("File");
            String POwner= request.getParameter("POwner");
            String PUser= request.getParameter("PUser");
            
 //File Folder 3 and 4 %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%  
                Properties properties = PropertyLoader.getProperties();
                            String uploadPaaht = properties.getProperty("uploadpathOriginal");
            String path1=uploadPaaht+File;
            //String path2="C:/Users/jemi java/Documents/NetBeansProjects/Security and Privacy-Enhancing/CLOUD/Decrypt/"+radio1;
           // String downloadPath = properties.getProperty("downloadpath");
           // String path2=downloadPath+File;
 //File Folder 3 and 4 %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
         
             //copyFileUsingFileStreams(path1, path2);
    //Download status updation...
    //MODIFICATION 2 )...    		
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                Connection con2 = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/decentralize", "root", "root");
 //MODIFICATION 2 (END)...          
                
                
                String sa1="select * from register where id='"+userid+"' and name='"+name+"' and pkey='"+PUser+"'";
                PreparedStatement pr=con2.prepareStatement(sa1);
		ResultSet rs=pr.executeQuery();
                
		if (rs.next()) 
                {
                    
                     sa1="select * from files where filename='"+File+"' and key1='"+POwner+"'";
                PreparedStatement pr1=con2.prepareStatement(sa1);
		ResultSet rs1=pr1.executeQuery();
                        if(rs1.next()){
                            process = 1;
                        }else{
                            process = 2;
                        }
                    
                   
                    
                }else{
                     process= 3;
                }
                con2.close();
                pr.close();
         if(process==1)
          {
              
               Class.forName("com.mysql.jdbc.Driver").newInstance();
                Connection con1 = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/decentralize", "root", "root");
 //MODIFICATION 1 (END)...  
            //PreparedStatement ps=con.prepareStatement("update File1 set Upload='Uploaded' where userid='"+userid+"' and FileName='"+radio1+"'");
            String sa2="update requestst set status='Downloaded' where userid='"+userid.trim()+"' and filename='"+File+"'";//+radio1.trim()+"'";
            //
            
            
            Statement st2=(Statement) con1.createStatement();
            
            st2.executeUpdate(sa2);
            //PreparedStatement pr=con.prepareStatement(sa);
            //ResultSet rs=pr.executeQuery(); 
             
           // String[] radio1=(String[]) request.getAttribute("upload");
            con1.close();
            Java_Decryption d=new Java_Decryption(); 
            
            response.setContentType("APPLICATION/OCTET-STREAM");
            response.setHeader("Content-Disposition", "attachment;filename=\""+File+"\"");
            FileInputStream inputStream = new FileInputStream(path1);
            int i;
            out.flush();
            while((i=inputStream.read())!= -1){
                out.write(i);
            }
            inputStream.close();
            //d.fun2(path1, response,POwner);                       
          }else if(process == 2){
              RequestDispatcher rd=request.getRequestDispatcher("Download.jsp");	
			request.setAttribute("msg","Incorrect public key , please enter valid public key" );
			rd.forward(request, response);
          }else{
              RequestDispatcher rd=request.getRequestDispatcher("Download.jsp");	
			request.setAttribute("msg","Please enter valid primary key" );
			rd.forward(request, response);
          }
         //MODIFICATION 1 )...    		
               
            
//Download status end...             
            //session.setAttribute("", "Download Completed...");
//            RequestDispatcher rd=request.getRequestDispatcher("User.jsp");
//            
//            if(process==0)
//            {
//               request.setAttribute("status", "Download Error...");
//            }
//            else
//            {
//               request.setAttribute("status", "Download Successfully..."); 
//            }
//		rd.forward(request, response);
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
