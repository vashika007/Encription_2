<%-- 
    Document   : Fileview
    Created on : Nov 4, 2014, 12:05:47 PM
    Author     : Raja
--%>

<%@page import="java.util.Date"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Cloud</title>
<meta name="keywords" content="free css, web template, cloudy" />
<meta name="description" content="Cloudy - free website template provided by templatemo.com" />
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="css/featuredcontentglider.css" />
 <link href="css/style_2.css" rel="stylesheet" type="text/css" />
 <link href="style.css" rel="stylesheet" type="text/css" />
 
<script language="javascript" type="text/javascript">

</script>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"></script>
<script type="text/javascript" src="css/featuredcontentglider.js">
     
/***********************************************
* Featured Content Glider script- (c) Dynamic Drive DHTML code library (www.dynamicdrive.com)
* Visit http://www.dynamicDrive.com for hundreds of DHTML scripts
* This notice must stay intact for legal use
***********************************************/
</script>
</head>
<body>

<div id="templatemo_wrapper_outer">
<div id="templatemo_wrapper">

 <!-- end of templatemo_banner -->
  <jsp:include page="header1.jsp" />
    	
         
        <br>
            </br>
    <div>     <img width="400" height="200" src="images1/file.jpg" alt="" style="border-radius:20px;margin-left: 250px" ></div>
        <br>
            <div style="text-align: center; margin-top: 50px;color:red;"><h2> FILE LIST</h2></div></br>
  <!--Table creation mahesh STARTING PROCESS   -->      
    <div>
    <%
    //String userid1,path1,FileName1;    
    int i=1;
        try
        {          
                    String uid=(String)session.getAttribute("uid");
//MODIFICATION 1 )...    		
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                Connection con = (Connection)  DriverManager.getConnection("jdbc:mysql://172.30.96.167:3306/decentralize", "admin", "admin");
 //MODIFICATION 1 (END)...               
		//PreparedStatement pr=con.prepareStatement("select * from Reg");
            String sa="select * from files where auditor='verified'";
            PreparedStatement pr=con.prepareStatement(sa);
            ResultSet rs=pr.executeQuery();
            
            ArrayList Fname=new ArrayList();
            
            
                
            %>
            <form action="request" method="post">
           <div align="center">
            <table bgcolor="lightblue" border="2">
                <tr style="color: blue;background: bottom;">
                    <th>S.No</th><td></td>
                     <th>File Name</th><td></td>
                     <th>Owner</th><td></td>
                     <th>Send File Request</th><td></td>
                </tr>
                <%
                while(rs.next())
                {
                %>
                <tr>
                    <%
                    String Fname1=rs.getString(2);
                    //request.setAttribute("FName","Fname1");
                    Fname.add(Fname1);
                    Fname.indexOf(i);
                    Date now=new Date();
                    //int d=now;
                    request.setAttribute("TDate","Date");
                    //String uid=(String)session.getAttribute("");
                    %>
                        <td><%=(i++)%></td> <td></td>
                        <td><%=Fname1%></td><td></td>
                        <td> Admin </td><td></td>
                        <td>
                            <!--<font color="white"><input type="radio" name="s1" value=<%=Fname1%>>Select for Decryption<br></font>-->
                            <font color="black"><input type="radio" name="s1" value="<%=Fname1%>"/> Select for Download </font> 
                        </td>    <td></td>                                  
                
                </tr>    
                     <%
                        }    
                     %>           
           </table>
              <br>
                  <input type="submit" value="SEND" style="color: green;font-size: medium;"/>
              </br>
            </div>
           <%            
            //
                       }
        catch(Exception e)
        {
            System.out.println("Exception"+e);
        }
            
     %>  
            </form>
    </div>
              </div>
    

        
<div id="templatemo_content_wrapper_bottom"></div> <!-- end of templatemo_wrapper -->

        <div id="templatemo_footer">
   	    Copyright © 2048 <a href="#">Your Company Name</a> | <a href="http://www.iwebsitetemplate.com" target="_parent">Website Templates</a> by <a href="http://www.templatemo.com" target="_parent">Free CSS Templates</a></div>
</div>
</div>
<div align=center>This template  downloaded form <a href='http://all-free-download.com/free-website-templates/'>free website templates</a></div></body>
</html>