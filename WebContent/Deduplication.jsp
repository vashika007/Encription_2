<%-- 
    Document   : Deduplication
    Created on : Nov 3, 2014, 4:15:47 PM
    Author     : Raja
--%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Cloud</title>
<meta name="keywords" content="free css, web template, cloudy" />
<meta name="description"
	content="Cloudy - free website template provided by templatemo.com" />
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css"
	href="css/featuredcontentglider.css" />
<link href="css/style_2.css" rel="stylesheet" type="text/css" />
<link href="style.css" rel="stylesheet" type="text/css" />

<script language="javascript" type="text/javascript">
	
</script>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"></script>
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
			<br> <br>
					<div align="center">
						<img width="400" height="200" src="images1/duplication.jpg" alt=""
							style="border-radius: 20px" />
					</div> <br> </br>
					<form action="gotocheck" enctype="multipart/form-data"
						method="post">
						<div class="login4" align="center">
							<table border="0" bgcolor="#999999" style="">
								<tr>
									<input class="login-inputex" type="file" name="file"
										style="width: 200px; color: red; font-size: 20px;"
										value="Choose File"></input> &nbsp; &nbsp; &nbsp; &nbsp;
									&nbsp; &nbsp; &nbsp;
									<input class="login-submitex" type="submit"
										value="Submit to Check File"
										style="width: 200px; color: green; font-size: 20px;"></input>
								</tr>
							</table>
							<%
								String b = request.getAttribute("id1") != null ? request.getAttribute("id1").toString() : "";
							%><p style="font: larger; font-size: x-large; color: crimson">
								<%=b%></p>
						</div>
					</form>
		</div>



		<div id="templatemo_content_wrapper_bottom"></div>
		<!-- end of templatemo_wrapper -->

		<div id="templatemo_footer">
			Copyright © 2048 <a href="#">Your Company Name</a> | <a
				href="http://www.iwebsitetemplate.com" target="_parent">Website
				Templates</a> by <a href="http://www.templatemo.com" target="_parent">Free
				CSS Templates</a>
		</div>
	</div>
	</div>
	<div align=center>
		This template downloaded form <a
			href='http://all-free-download.com/free-website-templates/'>free
			website templates</a>
	</div>
</body>
</html>