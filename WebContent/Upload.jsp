<%-- 
    Document   : Upload
    Created on : Nov 4, 2014, 11:11:46 AM
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
    	    
      <div >     
        <tr>
            <td><table   style="width: 930px;" border="0" bgcolor="#999999" >
      <tr>
<!--          <td width="149"><div align="center" class="style1" > <a href="Deduplication.jsp"><strong style="font-size: 17px; ;color: greenyellow">Deduplication</strong></a></li></div></td>
        <td width="166"><div align="center" class="style1"><li class ="selected"><a href="encryption.jsp"><strong style="font-size: 17px;color: greenyellow ">Encryption</strong></a></div></td>-->
        <td width="168"><div align="center" class="style1"><a href="Upload.jsp"><strong style="font-size: 17px;color: greenyellow">Upload Details</strong></a></div></td>
       <td width="168"><div align="center" class="style1"><a href="Userrequest.jsp"><strong style="font-size: 17px;color: greenyellow">User Request</strong></a></div></td>
       <td width="168"><div align="center" class="style1"><a href="Downloadhistory.jsp"><strong style="font-size: 17px;color: greenyellow">Download History</strong></a></div></td>
       
      </tr>
    </table></td>
  </tr></div>
        <br>
            </br>
    <div align="center"> <img width="400" height="200" src="images1/uploading.jpg" alt="" style="border-radius:20px;margin-left: 30px;" ></img></div>
    <% 
String f=(String)request.getAttribute("fname");
String sk=(String)session.getAttribute("skey");
%>
    <br></br><form action="upload" method="post">
    <div class="login" align="center">
     <%
       	try
        {
            int i=1;
            String uid1=(String)session.getAttribute("uid");       
//MODIFICATION 1 )...   
            //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            //Connection con = DriverManager.getConnection("jdbc:odbc:PSE"); 		
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                Connection con = (Connection)  DriverManager.getConnection("jdbc:mysql://mysqlhost:3306/decentralize", "admin", "admin");
 //MODIFICATION 1 (END)...               
   
            //PreparedStatement pr=con.prepareStatement("select * from Reg");
            String sa="select * from files"; 
            PreparedStatement pr=con.prepareStatement(sa);
            ResultSet rs=pr.executeQuery();
		%>
                <font color="red"> <h3 align="center"> Upload Details </h3></font>
                <table border="3" style="border: 2px; border-color:red; border-style: double;">
                    <tr bgcolor="white">
                        <font color="orange " style="font: bold ;size: 10px">  <td>S.No</td><td>File Name</td><td>Status</td><td>Date of Upload</td></font>
                        
            </tr>
             <%
            while(rs.next())
            {
            String FName=rs.getString(2);
          //  String UName=(String)session.getAttribute("uname");
            //Date now=new Date();
            String status=rs.getString(7);
            String da=rs.getString(5);
           %>
           <tr bgcolor="lightblue">
                <%--    <td><%=(i++)%></td><td><%=%>now</td><td><%=UName%></td><%=%>   --%>
                <td><%=(i++)%></td><td><%=FName%></td><td><%=status%></td><td><%=da%></td>
            </tr>
            <%
               }
             %>
        </table>
        	
	<%	}
        catch(Exception e)
		{
			System.out.println(e);
		}
	   %>  
    </div>
    </form>
 </div>   
 <div id="templatemo_content_wrapper_bottom"></div> <!-- end of templatemo_wrapper -->    
</body>
</html>