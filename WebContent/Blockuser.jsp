<%-- 
    Document   : Blockuser
    Created on : Nov 6, 2014, 9:50:19 AM
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

	<div id="temmplatmeo_header">
    
   		<div id="site_title">
                     
                    <center style="margin-left: 29px;margin-right: -640px ;color: red"> <h1>REAL CLOUD   </h1>   </center>  

            </a>
        </div>
    
    	<div id="templatemo_menu">
        
            <ul>
                <li><a href="index.jsp" class="current">Log Out</a></li>
            
               
          		
            </ul>    	
        
        </div> <!-- end of templatemo_menu -->
    
    </div> <!-- end of templatemo_header -->
    
    <div id="templatemo_content_wrapper_top"></div>
    <div id="templatemo_content_wrapper">
    
    	
    
        <div id="templatemo_banner"><span class="frame"></span>
        
			<script type="text/javascript">
    
            featuredcontentglider.init({
                gliderid: "canadaprovinces", //ID of main glider container
                contentclass: "glidecontent", //Shared CSS class name of each glider content
                togglerid: "p-select", //ID of toggler container
                remotecontent: "", //Get gliding contents from external file on server? "filename" or "" to disable
                selected: 0, //Default selected content index (0=1st)
                persiststate: false, //Remember last content shown within browser session (true/false)?
                speed: 500, //Glide animation duration (in milliseconds)
                direction: "rightleft", //set direction of glide: "updown", "downup", "leftright", or "rightleft"
                autorotate: true, //Auto rotate contents (true/false)?
                autorotateconfig: [3000, 2] //if auto rotate enabled, set [milliseconds_btw_rotations, cycles_before_stopping]
            }
                    );
            
            </script>
            
            <div id="canadaprovinces" class="glidecontentwrapper">
            
            <div class="glidecontent">
                <!--<img src="images/templatemo_image_01.jpg" alt="bird" />-->
                 <img src="images/header-bg.jpg" alt="image" />
            </div>
            
            <div class="glidecontent">
            <img src="images/templatemo_image_02.jpg" alt="image" />
            </div>
            
            <div class="glidecontent">
            <img src="images/templatemo_image_03.jpg" alt="image" />
            </div>
            
            </div>
            
            <div id="p-select" class="cssbuttonstoggler">
            <a href="#" class="toc"><span>1</span></a> <a href="#" class="toc"><span>2</span></a> <a href="#" class="toc"><span>3</span></a>
            
            </div>
        
        
        </div> <!-- end of templatemo_banner -->
    	<div >     
        <tr>
            <td><table   style="width: 930px;" border="0" bgcolor="#999999" >
      <tr>
          <td width="149"><div align="center" class="style1" > <a href="Accessfile.jsp"></a><strong style="font-size: 17px; ;color: greenyellow">File Access View</strong></a></div></td>
     
          <td width="149"><div align="center" class="style1" > <a href="Blockuser.jsp"><strong style="font-size: 17px; ;color: greenyellow"> User List</strong></a></div></td>
        <td width="166"><div align="center" class="style1"><a href="Filestransaction.jsp"><strong style="font-size: 17px;color: greenyellow ">Filestransaction</strong></a></div></td>
        <!--<td width="168"><div align="center" class="style1"><a href="Download.jsp"><strong style="font-size: 17px;color: greenyellow">File Download</strong></a></div></td>-->
       
      </tr>
    </table></td>
  </tr></div>
        <div align="right" style="margin-right: 100px;"> <li><a href="unblock.jsp">Requested Users</a></li></div>
<div align="center">
    <h2> Userlist </h2>
    <table  class="table1" border="2">
    <%
       	try
		{
	  //MODIFICATION 2 )...    		
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/decentralize", "root", "root");
 //MODIFICATION 2 (END)...          
  	//PreparedStatement pr=con.prepareStatement("select * from Reg");
                String sa="select * from register";
                PreparedStatement pr=con.prepareStatement(sa);
                ResultSet rs=pr.executeQuery();
		%>
                <tr style="height: 30px; background-color: mediumaquamarine;">
		<th>User ID</th>
		<th>User Name</th>
		<th>User City</th>
		<th>User Email</th>
                <th>Status</th>
                </tr>
                
		<% 
		while(rs.next())
		{%>
                <form action="blockusr" method="post">
                    <tr style="height: 30px; background-color: lightpink;"><td><%=rs.getString(1)%></td>
                        <td><input type="text" style="background-color: lightpink" name="snme" value="<%=rs.getString(2)%>"></input></td>
			<td ><%=rs.getString(4)%></td>
			<td><%=rs.getString(5)%></td>
                        <td><select name="access">
                                <option name="all">Access</option>>
                                <option name="den">Denied</option>>
                            </select></td>
                        <td> <input type="submit" style="background-color: yellowgreen;" value="Continue"></input></td>
                        </tr>
                       
                </form>	
			
	<%	}
	con.close();
	pr.close();
	rs.close();
		
		}
		
	
		catch(Exception e)
		{
			System.out.println(e);
		}
		
    %></table>
    <br></br>
</div></div>>
    

        
<div id="templatemo_content_wrapper_bottom"></div> <!-- end of templatemo_wrapper -->

        <div id="templatemo_footer">
   	    Copyright © 2048 <a href="#">Your Company Name</a> | <a href="http://www.iwebsitetemplate.com" target="_parent">Website Templates</a> by <a href="http://www.templatemo.com" target="_parent">Free CSS Templates</a></div>
</div>
</div>
<div align=center>This template  downloaded form <a href='http://all-free-download.com/free-website-templates/'>free website templates</a></div></body>
</html>