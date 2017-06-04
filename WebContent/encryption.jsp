<%-- 
    Document   : encryption
    Created on : Nov 4, 2014, 10:22:18 AM
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
    
        
        
        <br>
         <br>
                <% 
String f=(String)request.getAttribute("fname");
String sk=(String)session.getAttribute("skey");
%>
    <br></br><br></br><form action="upload" method="post">
         <div align="center"> <img width="400" height="200" src="images1/cloud.jpg" alt="" style="border-radius:20px" /></div>
    <div class="login" align="center">
        <h3><font color="orange"> File Key</font> </h3>
        <input class="login-input" type="text" value="<%= sk %>" name="key" placeholder="Set File Key"/>
<h3><font color="orange"> File Name</font> </h3>
<input class="login-input" type="text" name="fn" value="<%= f %>"></input>
<h3><font color="orange">Assign to</font></h3>
<select class="" name="assignee">
<%
Class.forName("com.mysql.jdbc.Driver").newInstance();
Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://172.30.96.167:3306/decentralize", "admin", "admin");
 //MODIFICATION 1 (END)...               
   
            //PreparedStatement pr=con.prepareStatement("select * from Reg");
            String sa="select id,name from register where type != 'user'"; 
            PreparedStatement pr=con.prepareStatement(sa);
            ResultSet rs=pr.executeQuery();
            while(rs.next()){
                
            String uid = rs.getString(1);
            String name = rs.getString(2);
%>
<option value=<%=uid%>><%=name%></option>
<%}%>
</select>
        <input class="login-submit" type="submit" value="upload" style="width: 200px; color: red;"></input>
    </div>
        
        
        
    </form>>
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
<!--    	<div id="content">
        
        	<div class="full_width">
            
            	<h2>Welcome to Cloudy Template</h2>
                <p>	This template is provided by <a href="http://www.templatemo.com" target="_parent">Free CSS Templates</a> for free of charge. Validate <a href="http://validator.w3.org/check?uri=referer">XHTML</a> &amp; <a href="http://jigsaw.w3.org/css-validator/check/referer">CSS</a>. Feel free to download, edit and apply this template for your websites. Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Nunc quis sem nec tellus blandit tincidunt. Duis vitae velit sed dui malesuada dignissim. Donec mollis aliquet ligula. Maecenas adipiscing elementum ipsum. Pellentesque vitae magna. Sed nec est. Suspendisse a nibh tristique justo rhoncus volutpat. </p>
              <p>Suspendisse vitae neque eget ante tristique vestibulum. Pellentesque dolor nulla, congue vitae, fringilla in, varius a, orci. Mauris convallis. Proin vel libero id erat venenatis accumsan. Nunc blandit orci sit amet risus. Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Ut iaculis lacinia purus. Duis pulvinar scelerisque ante. </p>
              <div class="button_01 float_r"><a href="#">Read more</a></div>
                
                <div class="cleaner"></div>
            </div>
            
            <div class="full_width">
            
            	<div class="section_w280 margin_r_30 w280_bg">
                
                	<h2 class="services">Our Services</h2>
                    
                    <p>Mauris quis nulla sed ipsum pretium sagittis. Suspendisse feugiat. Ut sodales libero odio. Maecenas venenatis metus eu est.</p>
                    
                    <ul class="service_list">
                   		<li><a href="#">Suspendisse vitae neque</a></li>
                      <li><a href="#">Eget ante tristique</a></li>
                      <li><a href="#">Vestibulum ellentesque</a></li>
                      <li><a href="#">Dolor nulla, congue vitae</a></li>
                      <li><a href="#">Fringilla in, varius a, orci</a></li>
                      <li><a href="#">Mauris convallis</a></li>
                  </ul>
                
                </div>
                
                <div class="section_w280 margin_r_30 w280_bg">
                
                	<h2 class="portfolio">Our Portfolio</h2>
                    
                    <a href="#"><img src="images/templatemo_image_08.png" alt="image" /></a>
                    
                  <p>Vivamus a massa. Donec iaculis felis id neque. Morbi nunc. Praesent varius egestas velit. Donec a massa ut pede pulvinar vulputate.</p>
                  <p>Curabitur quis velit quis tortor tincidunt aliquet. Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Ut iaculis lacinia purus.</p>
              </div>
                
                <div class="section_w280 w280_bg">
                
                	<h2 class="project">Our Projects</h2>
                    
                    <ul class="project_gallery">
                    	
                        <li><a href="#"><img src="images/templatemo_image_04.jpg" alt="image" /></a></li>
                        <li><a href="#"><img src="images/templatemo_image_05.jpg" alt="image" /></a></li>
                        <li><a href="#"><img src="images/templatemo_image_06.jpg" alt="image" /></a></li>
                        <li><a href="#"><img src="images/templatemo_image_07.jpg" alt="image" /></a></li>
                        
                    </ul>
					
                    <div class="cleaner"></div>                
                	<div class="button_01 float_r"><a href="#">View All</a></div>
                </div>
                
                <div class="cleaner"></div>
            
            </div>
            
            <div class="full_width">
            
            	<div class="section_w590 margin_r_30">
                	
                    <h2 class="current_activities">New Activities</h2>
                    <p>	Quisque in diam a justo condimentum molestie. Vivamus a velit. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Suspendisse feugiat.  <a href="#">read more</a></p>
                    <p>Curabitur quis velit quis tortor tincidunt aliquet. Vivamus leo velit, convallis id, ultrices sit amet, tempor a, libero. Quisque rhoncus nulla quis sem. Mauris quis nulla sed ipsum pretium sagittis. <a href="#">read more</a></p>
           	  </div>
                
                <div class="section_w280">
                
                	<h2 class="newsletter">Newsletter</h2>
                    
                    <form action="#" method="get" class="search_box">
                        <input type="text" value="Enter your email" name="q" size="10" id="searchfield" title="searchfield" onfocus="clearText(this)" onblur="clearText(this)" />
                        <input type="submit" name="Search" value="Subscribe" alt="Search" id="searchbutton" title="Search" />
                    </form>
                    
                    <strong>Tel:</strong> 010-010-0100  &nbsp;&nbsp;<strong>Fax:</strong> 020-020-0200 <br />
				<strong>Email:</strong> <a href="#">info@yourcompany.com</a>                </div>
                
                <div class="cleaner"></div>
            
            </div>
        
		</div>  end of content -->
        
</div><div id="templatemo_content_wrapper_bottom"></div> <!-- end of templatemo_wrapper -->

        <div id="templatemo_footer">
   	    Copyright © 2048 <a href="#">Your Company Name</a> | <a href="http://www.iwebsitetemplate.com" target="_parent">Website Templates</a> by <a href="http://www.templatemo.com" target="_parent">Free CSS Templates</a></div>
</div>
</div>
<div align=center>This template  downloaded form <a href='http://all-free-download.com/free-website-templates/'>free website templates</a></div></body>
</html>