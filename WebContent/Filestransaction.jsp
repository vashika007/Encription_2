<%-- 
    Document   : Filestransaction
    Created on : Nov 6, 2014, 10:24:53 AM
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
          <!--<td width="149"><div align="center" class="style1" > <a href="Accessfile.jsp"></a><strong style="font-size: 17px; ;color: greenyellow">File Access View</strong></a></div></td>-->
      <td width="149"><div align="center" class="style1" > <a href="Accessfile.jsp"><strong style="font-size: 17px; ;color: greenyellow"> File Access View</strong></a></div></td>
       
          <td width="149"><div align="center" class="style1" > <a href="Blockuser.jsp"><strong style="font-size: 17px; ;color: greenyellow"> User List</strong></a></div></td>
        <td width="166"><div align="center" class="style1"><a href="Filestransaction.jsp"><strong style="font-size: 17px;color: greenyellow ">Filestransaction</strong></a></div></td>
        <!--<td width="168"><div align="center" class="style1"><a href="Download.jsp"><strong style="font-size: 17px;color: greenyellow">File Download</strong></a></div></td>-->
       
      </tr>
    </table></td>
        </tr></div>
      <div align="center" >
          <h2 style="color: red;"> Transaction Details </h2>
 
         <%
    //String userid1,path1,FileName1;    
    int i=1;
        try
        {          
            //String name=(String)session.getAttribute("uname");
            
            String uid=(String)session.getAttribute("uid");
              //MODIFICATION 2 )...    		
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                Connection con = (Connection)  DriverManager.getConnection("jdbc:mysql://mysqlhost:3306/decentralize", "admin", "admin");
 //MODIFICATION 2 (END)...          
  	//PreparedStatement pr=con.prepareStatement("select * from Reg");
            String sa="select * from requestst where request='Sent' and response='Done'";
            PreparedStatement pr=con.prepareStatement(sa);
            ResultSet rs=pr.executeQuery();
            %>
            <div align="center" style="border-color: #0033ff;">
                <table bgcolor="lightpink" border="2" style="padding: 5px;" >
                    <tr style="color: blue;">
                     <th>S.No</th>
                     <th>File Name</th>
                     <th>User ID</th>
                     
                     <th>Request</th>
                     
                     <th>Date</th>
                     <th>Response</th>
                     <th>Date</th>
                         
                </tr>
          
                <%
                while(rs.next())
                {
                %>
                <tr>
                    <%
                    String Fname1=rs.getString(3);
                    String user1=rs.getString(1);
                    String d1=rs.getString(5);
                    String d2=rs.getString(6);
                    String d3=rs.getString(7);
                    String d4=rs.getString(8);
                    //String status=rs.getString(7);
                    //String date=rs.getString(8);
                    //request.setAttribute("FName","Fname1");
                 
                    
                    //int d=now;
                    request.setAttribute("TDate","Date");
                    %>
                        <td><%=(i++)%></td> 
                        <td><%=Fname1%></td>
                        <td><%=user1%></td>  
                        <td><%=d1%></td>
                        <td><%=d2%></td>
                        <td><%=d3%></td>
                        <td><%=d4%></td>
                  <!--      <td><%//=status%></td>  
                        <td><%//=date%></td>  -->
                
                </tr>    
                     <%
                        }    
                     %>           
           </table>
           
           
            </div>
           <%            
            //
                       }
        catch(Exception e)
        {
            System.out.println("Exception"+e);
        }
            
     %> 
    </div>
              </div>
              <div id="templatemo_content_wrapper_bottom"></div> <!-- end of templatemo_wrapper -->
   </body>
</html>