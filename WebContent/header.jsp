<%-- 
    Document   : header
    Created on : Apr 30, 2017, 11:10:47 AM
    Author     : Lucky
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <title>Connect</title>
    <body>
        	<div id="temmplatmeo_header">
    
   		<div id="site_title">
                     
                    <center style="margin-left: 29px;margin-right: -640px ;color: red"><div class='bannercontent'> <h1>Doctor Connect </h1>  </div> </center>  
           
            </a>
        </div>
    
    	<div id="templatemo_menu">
        
            <ul>
                <li><a href="index.jsp" class="current">Home</a></li>
                <li><a href=Login.jsp target="_parent">Login</a></li>
                <li><a href=Newuser.jsp target="_parent"> Registration</a></li>
          		
            </ul>    	
        
        </div>  
    
    </div>  
    
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
            
            <div class="glidecontent" style="width: 100%">
               
                 <img src="images/Doctor1.jpg" alt="image" style="width: 100%" />
            </div>
            
            <div class="glidecontent" style="width: 100%">
            <img src="images/Doctor2.jpg" alt="image" style="width: 100%" />
            </div>
            
            <div class="glidecontent" style="width: 100%">
            <img src="images/Doctor3.jpg" alt="image" style="width: 100%"/>
            </div>
            
            </div>
            
            <div id="p-select" class="cssbuttonstoggler">
            <a href="#" class="toc"><span>1</span></a> <a href="#" class="toc"><span>2</span></a> <a href="#" class="toc"><span>3</span></a>
            
            </div>
        
        
        </div>
    </body>
</html>
