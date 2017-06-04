<%-- 
    Document   : Viewprofile
    Created on : Nov 4, 2014, 12:22:31 PM
    Author     : Raja
--%>

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

     <jsp:include page="header1.jsp" />
     
     <%
         String msg = (String)session.getAttribute("success");
         session.setAttribute("success", "");
         if(msg != null && msg.equals("success")){
     %>
     <script>
         alert("Successfuly uploaded");
     </script>
     <%}%>
	 <!-- end of templatemo_banner -->
    	
        <br>
        </br>
        
           <div class ="login-card"  style="float:left; color: #cccccc ;margin-left:30px; ">
<br>
        </br><br>
        </br>        </br>
 <img width="400" height="200" src="images1/profile.jpg" alt="" style="border-radius:20px" >
        <!--<img src="images1/profile.jpg" alt="image" width="250"  ></img>-->
  
    </div>
         <tr>
   
        
<!--        <td><table align="center" style="margin-top: 60px;border: 1px">-->
                <caption>
                   <h1 > <p style="text-align: center; margin-top: 50px;color:red;">
                    
                    Your Profile</p> </h1></caption>
                 <tr>
                     </tr>
                 <div>
        <% String a=(String) session.getAttribute("uname1");
    %>
        <h4 align="right" style="margin-top:-20px;margin-right: 36px;"> Name : <font color="red"><%=a%></font></h4>
   </div>
<div align="center">
          
<%
String name=null;
String userid=null;
String city=null;
String mailid=null;

String s=session.getAttribute("uname1")!=null?session.getAttribute("uname1").toString():"";


String s1=session.getAttribute("uid1" )!=null?session.getAttribute("uid1" ).toString():"";
try{
    Class.forName("com.mysql.jdbc.Driver").newInstance();
             Connection con = (Connection)  DriverManager.getConnection("jdbc:mysql://172.30.96.167:3306/decentralize", "admin", "admin");
           // PreparedStatement ps1=con.prepareStatement("select * from reg where userid='"+s+"' and password='"+s1+"'");
            PreparedStatement ps1=con.prepareStatement("select * from register where name='"+s+"' and id='"+s1+"'");
           // select * from register where id='e' and password='e';
            ResultSet rs1=ps1.executeQuery();
            while(rs1.next()){
                %>
              
                
                <table width="300" border="1" style="margin-top: 60px;">
           
                <tr>
                    <th>  Name:</th> <td><input type="text" value="<%=rs1.getString(2)%>" name="name" required="" style="border-radius:20px"></input></td></tr>
                    <tr> <th>   Password:</th><td> <input type="text" value="<%=rs1.getString(3)%>" name="name" required="" style="border-radius:20px"></input></td></tr>
                    <tr>   <th>   UserId:</th> <td><input type="text" value="<%=rs1.getString(1)%>" name="name" required="" style="border-radius:20px">  </input></td></tr>
                    <tr>    <th>      City:</th> <td> <input type="text" value="<%=rs1.getString(4)%>" name="name" required="" style="border-radius:20px"></input></td></tr>
                    <tr>    <th>      Mail-Id:</th> <td> <input type="text" value="<%=rs1.getString(5)%>" name="name" required="" style="border-radius:20px"></input></td></tr>
                                   
                      <tr>    <th>  Private Key:   </th> <td> <input type="text" value="<%=rs1.getString(8)%>" name="name" required="" style="border-radius:20px"></input></td></tr>
                    
             
               
  
                   </table>
                   
              
            <%
            }
                       }
            catch(Exception wq){
                System.out.print(wq);
            }
            

            %> </table>  </td>
  </tr>
  
 
              </div>
    

        
</body>
</html>