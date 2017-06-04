<%-- 
    Document   : Adminresponse
    Created on : Nov 4, 2014, 12:53:29 PM
    Author     : Raja
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<
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
        <br></br>
      <%
   
    	try
        {
            int i=1;
            String uid=(String)session.getAttribute("uid1");
            
//MODIFICATION 1 )...    		
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                Connection con1 = (Connection)  DriverManager.getConnection("jdbc:mysql://172.30.96.167:3306/decentralize", "admin", "admin");
 //MODIFICATION 1 (END)...                   

            
            
            
            
            //PreparedStatement pr=con.prepareStatement("select * from Reg");
            String sa="select * from requestst where userid='"+uid+"'"; // and Upload='u'";
            PreparedStatement pr=con1.prepareStatement(sa);
            ResultSet rs=pr.executeQuery();
		%>
        
                <table bgcolor="lightblue" border="2" style="margin-left: 10px;">
            <tr >
                <th>S.No</th><th>File Name</th><th>User Name</th><th>Key</th><th>Request</th><th>Date of Request</th><th>Response</th>
            </tr>
             <%
            while(rs.next())
            {
            String FName=rs.getString(3);
            String UName=(String)session.getAttribute("uname1");
            String key1=rs.getString(4);
            String request1=rs.getString(5);
            String drequest=rs.getString(6);
            String response1=rs.getString(7);
            String dresponse=rs.getString(8);
            String ds=rs.getString(9);
                        %>
            <tr>
                <%--    <td><%=(i++)%></td><td><%=%>now</td><td><%=UName%></td><%=%>   --%>
                <td><%=(i++)%></td><td><%=FName%></td><td><%=UName%></td><td><%=key1%></td><td><%=request1%></td><td><%=drequest%></td><td><%=response1%></td>
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
</body>
</html>