<%
HttpSession sessionObj=request.getSession(false);
System.out.println("ses id="+sessionObj.getId());
String userType=(String)sessionObj.getAttribute("userType");
%>
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
			<span class='adminMnu active' onclick='openUrl("<%=request.getContextPath() %>/adminHome")'>Home</span>
			<span class='adminMnu' onclick='openUrl("<%=request.getContextPath() %>/adminManageUser")'>Manage Users</span>
			<span class='adminMnu' onclick='openUrl("<%=request.getContextPath() %>/adminhome")'>Manage Session</span>
			<span class='adminMnu' onclick='openUrl("<%=request.getContextPath() %>/registrationPage")'>Register User</span>
			<span class='adminMnu' onclick='openUrl("<%=request.getContextPath() %>/statusPage")'>User Status</span>
		</div>
		<!-- This is for Body Content -->
		<div class="col-xs-12 contentContainer">
			<div id='adminLoadPage' class="col-xs-12 rmpd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
.adminUsrCtrlDiv{
	height: 50px;
	padding: 10px 15px;
}
.headerTxt{
	font-size: 16px;
	font-weight: bold;
	padding: 0px 5px;
}
.tblDiv>div{
	border: 1px solid #888;
	text-align: left;
	}
</style>
<div class='col-xs-12 rootContainer'>
	<div class='col-xs-12 adminUsrCtrlDiv'>
		<span class='fllt headerTxt'>User List</span>
		<div id='adminMgUserCtrl' class='flrt'>
			<button class='btn mateCol'><i class='fa fa-refresh'></i></button>
			<button class='btn mateCol'><i class='fa fa-plus'></i></button>
			<button class='btn mateCol'><i class='fa fa-pencil'></i></button>
			<button class='btn mateCol'><i class='fa fa-trash'></i></button>
		</div>
	</div>
	<div class='col-xs-12 tblDiv'>
		<table id='adminMgUsrTbl' class='table '>
			<thead>
				<tr>
					<td>Select</td>
					<td><span>Sno</span></td>
					<td><span>User Id</span></td>
					<td><span>User Name</span></td>
					<td><span>User Type</span></td>
					<td><span>Phone No</span></td>
					<td><span>Mobile No</span></td>

				</tr>
			</thead>
			<tbody>
			<c:set var="j" value="1"></c:set>
			<c:forEach var="i"  items="${userList}">
				<tr>
					<td><input type='checkbox'></td>
					<td><span>${j }</span></td>
					<td><span>${i.USER_ID }</span></td>
					<td><span>${i.userType }</span></td>
					<td><span>${i.emailId }</span></td>
					<td><span>${i.status }</span></td>
					<td><span>${i.activeFrom }</span></td>
				</tr>
				<c:set var="j" value="${j+1}"></c:set>
			</c:forEach>
			</tbody>
		</table>
	</div>
</div>

	</div>
		</div>
	<!-- This is for Footer -->
	<div class="footerContainer"><jsp:include page="footer.jsp"></jsp:include> </div>
</div>
</body>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.12.1.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/datatables.min.js"></script>

</html>

