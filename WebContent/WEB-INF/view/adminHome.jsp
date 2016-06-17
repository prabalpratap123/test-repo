<%
HttpSession sessionObj=request.getSession(false);
System.out.println("ses id="+sessionObj.getId());
String userType=(String)sessionObj.getAttribute("userType");
%>
<%@page import="com.itextpdf.text.log.SysoLogger"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%-- <link rel="stylesheet" href="<%=request.getContextPath() %>/css/datatables.min.css" type="text/css">
<link type="text/css" href="<%=request.getContextPath() %>/css/bootstrap.min.css" rel="stylesheet" >
<link type="text/css" href="<%=request.getContextPath() %>/css/font-awesome.min.css" rel="stylesheet" >
<link type="text/css" href="<%=request.getContextPath() %>/css/mainLayout.css" rel="stylesheet" >
 --%>
</head>
<body>
<div class="col-xs-12 rootContainer">
	<!-- This is for RootHeader -->
	<div class="col-xs-12 headerContainer"><jsp:include page="header.jsp"></jsp:include></div>
	<!-- This is for Menubar -->
		<div id='adminNavigation' class='col-xs-12'>
			<span class='adminMnu active' ><a href="<%=request.getContextPath() %>/adminHome" >Home</a></span>
			<span class='adminMnu'   ><a href="<%=request.getContextPath() %>/adminManageUser">Manage Users</a></span>
			<span class='adminMnu'   ><a href="<%=request.getContextPath() %>/adminhome">Manage Session</a></span>
			<span class='adminMnu'   ><a href="<%=request.getContextPath() %>/registrationPage">Register User</a></span>
			<span class='adminMnu'   ><a href="<%=request.getContextPath() %>/statusPage">User Status</a></span>
		</div>
		<!-- This is for Body Content -->
		<div class="col-xs-12 contentContainer">
			<div id='adminLoadPage' class="col-xs-12 rmpd">
				<h1>Welcome To Progen Status Panel</h1>
			</div>
		</div>
	<!-- This is for Footer -->
	<div class="footerContainer"><jsp:include page="footer.jsp"></jsp:include> </div>
</div>
</body>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.12.1.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/datatables.min.js"></script>

</html>
