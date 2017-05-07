<%-- 
    Document   : header1
    Created on : Apr 30, 2017, 11:33:06 AM
    Author     : Lucky
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
        <div id="temmplatmeo_header">
    
   		<div id="site_title">
                     
                    <center style="margin-left: 29px;margin-right: -640px ;color: red"> <div class='bannercontent'><h1>Doctor Connect</h1>  </div> </center>  
           	<!--<a href="http://www.templatemo.com" target="_parent">-->
<!--            	<img src="images/templatemo_logo.png" alt="free css template" />
            	<span>designed by templatemo.com</span>-->
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
            
            <div class="glidecontent" style="width:100%">
                <!--<img src="images/templatemo_image_01.jpg" alt="bird" />-->
                 <img src="images/Doctor1.jpg" alt="image" style="width:100%"/>
            </div>
            
            <div class="glidecontent" style="width:100%">
            <img src="images/Doctor2.jpg" alt="image" style="width:100%"/>
            </div>
            
            <div class="glidecontent" style="width:100%">
            <img src="images/Doctor3.jpg" alt="image" style="width:100%"/>
            </div>
            
            </div>
            
            <div id="p-select" class="cssbuttonstoggler">
            <a href="#" class="toc"><span>1</span></a> <a href="#" class="toc"><span>2</span></a> <a href="#" class="toc"><span>3</span></a>
            
            </div>
        
        
        </div> 
        
        <div >     
        <tr>
            <td><table   style="width: 930px;" border="0" bgcolor="#999999" >
      <tr>
           <td width="149"><div align="center" class="style1" > <li class ="selected"><a href="Viewprofile.jsp"><strong style="font-size: 17px; ;color: greenyellow">Profile</strong></a></li></div></td>
<!--                    -->
        
 <% String type=(String) session.getAttribute("userType");
 if(type.equals("user")){
    %>
    <td width="149"><div align="center" class="style1" > <li class ="selected"><a href="Deduplication.jsp"><strong style="font-size: 17px; ;color: greenyellow">Upload Document</strong></a></li></div></td>
<!--<td width="166"><div align="center" class="style1"><a href="encryption.jsp"><strong style="font-size: 17px;color: greenyellow ">Upload Document</strong></a></div></td>-->
     
<!--          <td width="149"><div align="center" class="style1" > <li class ="selected"><a href="Fileview.jsp"><strong style="font-size: 17px; ;color: greenyellow">View Files</strong></a></li></div></td>-->
        <td width="166"><div align="center" class="style1"><a href="Adminresponse.jsp"><strong style="font-size: 17px;color: greenyellow ">Request Status</strong></a></div></td>
        <%}else{%>
        <td width="168"><div align="center" class="style1"><a href="Download.jsp"><strong style="font-size: 17px;color: greenyellow">File Download</strong></a></div></td>
       <%}%>
      </tr>
    </table></td>
  </tr></div>
    </body>
</html>
