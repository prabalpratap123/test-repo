<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Proge Status</title>
<link type="text/css" href="<%=request.getContextPath() %>/css/bootstrap.min.css" rel="stylesheet" >
<link type="text/css" href="<%=request.getContextPath() %>/css/mainLayout.css" rel="stylesheet" >
<style type="text/css">
#loginDiv{
	border: 1px solid #aaa;
	border-radius: 3px;
	padding: 20px;
	text-align: center;
	margin-top: 50px;
}
#loginDiv:hover{box-shadow: 1px 1px 2px 2px #888;}
#loginDiv input:nth-child(1){
	margin-bottom: 10px;
}
#loginDiv button:nth-child(3),
#loginDiv button:nth-child(4){
	background-color: #545454;
	color: #fff;
	width: 120px;
	font-weight: bold;
	margin-top: 10px;
}
#loginDiv button:nth-child(4){
	background-color: #27b1b1;
}
</style>
</head>
<body>
<div class="col-xs-12 rootContainer">
	<div class="col-xs-12 headerContainer"><jsp:include page="header.jsp"></jsp:include></div>
	<div class="col-xs-12 contentContainer">
		<div class="col-xs-offset-12 col-xs-12 ">
		<h2>Sorry This user Not exist. Please try again.</h2>
		</div>
		<div id='loginDiv' class="col-xs-offset-4 col-xs-3 ">
			<form action="login" method="post">
			<input id='txtUsercode' name="userCode" type="text" class="form-control" placeholder="Usercode">
			<input id='txtPassword' name="password" type="password" class="form-control" placeholder="Password">
			<button type="submit" class="btn" >LOGIN</button>
			<button class="btn" onclick="ClearAll()">CLEAR</button>
			</form>
		</div>

	</div>
	<div class="footerContainer"><jsp:include page="footer.jsp"></jsp:include> </div>
</div>
</body>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.12.1.min.js"></script>
<script type="text/javascript">
/* function loginUser(){
	$.ajax({
	    type: "POST",
	    url: "login",
	    data: "userCode=" + $("#txtUsercode").val() + "&password="+$("#txtPassword").val(),
	    success: function(data){
	    	alert(data)

	    },
	    error: function(e){
	    	alert('Error: ' + JSON.stringify(e));
	    }
	});
} */
function ClearAll(){
	$("#txtUsercode").val(" ");
	$("#txtPassword").val(" ");
}
</script>
</html>