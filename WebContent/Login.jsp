<%-- 
    Document   : login
    Created on : Oct 30, 2014, 5:47:26 PM
    Author     : Raja
--%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Cloud</title>
<meta name="keywords" content="free css, web template, cloudy" />
<meta name="description" content="Cloudy - free website template provided by templatemo.com" />
<link rel="stylesheet" href="css/style.css" media="screen" type="text/css" />
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

	<!-- end of templatemo_banner -->
        <jsp:include page="header.jsp" />
    	    <form action="Login2" method="post">
                <div style="float:left; color: #cccccc ;margin-left:30px; ">

        <img src="images1/Login.jpg" alt="image" width="550"  ></img>
  
    </div>
<div class="login-card">
   <%
String s=request.getAttribute("msg1")!=null?request.getAttribute("msg1").toString():"";
String s1=request.getAttribute("msg")!=null?request.getAttribute("msg").toString():"";
String s3=request.getAttribute("name")!=null?request.getAttribute("name" ).toString():"";
String s4=request.getAttribute("pwd")!=null?request.getAttribute("pwd" ).toString():"";

%>
  <p style=" color:orangered ;font-size: large;font:bold ">   <%=s%> </p>

    <h1>Log-in</h1><br>
  <form>
      <input type="text" name="uid"  placeholder="Userid"/>
          <input type="password" name="pwd" placeholder="Password"/>
        <select  input type="text" name="type" placeholder="User Type">
              <!--<select name="type">-->
<option value="doctor">Doctor</option>
<option value="user">User Login</option>   
<option value="lab">Lab Assistant</option>
<!--<option value="admin">Service Provider</option>
<option value="tpa">Third Parity Auditor</option><br>-->
</select>
  <br>  <input type="submit" name="login" class="login login-submit" value="login">
  </form>


</div>
    

</div><div id="templatemo_content_wrapper_bottom"></div> <!-- end of templatemo_wrapper -->

        <div id="templatemo_footer">
   	    Copyright © 2048 <a href="#">Your Company Name</a> | <a href="http://www.iwebsitetemplate.com" target="_parent">Website Templates</a> by <a href="http://www.templatemo.com" target="_parent">Free CSS Templates</a></div>
</div>
</div>
<div align=center>This template  downloaded form <a href='http://all-free-download.com/free-website-templates/'>free website templates</a></div></body>
</html>