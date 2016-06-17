<%
HttpSession sessionObj=request.getSession(false);
System.out.println("ses id="+sessionObj.getId());
String userType=(String)sessionObj.getAttribute("userType");
%>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/datatables.min.css" type="text/css">
<link type="text/css" href="<%=request.getContextPath() %>/css/bootstrap.min.css" rel="stylesheet" >
<link type="text/css" href="<%=request.getContextPath() %>/css/font-awesome.min.css" rel="stylesheet" >
<link type="text/css" href="<%=request.getContextPath() %>/css/mainLayout.css" rel="stylesheet" >

<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.12.1.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/datatables.min.js"></script>
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

#cmpLogoDiv{
	height: 100%;
	width: 200px;
	margin-left: 20px;
	float: left;
}
#cmpLogoDiv img{
	width: 100%;
	height: 100%;
}
#topNavigation{
    height: 50%;
    margin-right: 50px;
    position: absolute;
    bottom: 0px;
    right: 0px;color: white;
font-weight: bold;
}
#topNavigation span{
	color:#fff;
	font-size: 20px;
	padding: 10px;
	cursor: pointer;
}
</style>
<style type="text/css">
#adminNavigation{
    background-color: #456065;
    height: 36px;
    color: #fff;
    font-size: 14px;
     top: 80px;
}
#adminNavigation .adminMnu{
    text-align: center;
    padding: 8px;
    float: left;
    cursor: pointer;
}
#adminNavigation span:hover{
	background-color: #545454;
}
#adminLoadPage{
	text-align: center;
}
.active{
	background-color: #545454;
}
</style>
<div class="header" style='height: 100%;width: 100%;background-color: #545454;position: relative;'>
<div id='cmpLogoDiv'> <img src="<%=request.getContextPath() %>/images/logo.png" ></div>
<input type="hidden" id="headerUserId" value="<%=session.getAttribute("userId")%>"/>
<div id='topNavigation' style="color:white;">
				<%-- <label>Welcome</label>&nbsp&nbsp&nbsp<%=session.getAttribute("UserName")%> --%>
 				<a style="color:white;" id='admin' href='<%=request.getContextPath() %>/registrationPage'><i class="fa fa-user-plus" aria-hidden="true"></i> Register</a>
			   <!--  <a id='admin' href='#'><i class='fa fa-user-secret'></i> Admin</a> -->
				<a  style="color:white;" id='logout' href='logout'><i class='fa fa-power-off'></i> Logout</a>
				</div>
</div>
<script type="text/javascript">
	function openUrl(url){
		 window.open(url,"_self");
	}


	function adminLoadPage(obj,pageName){
		if(pageName=="adminHome"){
			$("#adminLoadPage").html("<h1>Welcome To Betsafe Admin</h1>");
	    	$(".adminMnu").removeClass("active");
	    	$(obj).addClass("active");
		}
		else{
			$.ajax({
			    type: "POST",
			    url: pageName,
			    success: function(data){
			    	$("#adminLoadPage").html(data);
			    	$(".adminMnu").removeClass("active");
			    	$(obj).addClass("active");
			    	if(pageName=="adminManageUser"){
			    		$('#adminMgUsrTbl').DataTable({
			                "scrollY":  "40vh",
			                "scrollCollapse": true,
			                "paging":         false,
			                "info":     false,
			                "filter":false,
			                "scrollX": true,
			                "fixedHeader": false,
			                "order": [[ 0, "desc" ]],
			                "columns": [
	                            { "width": "50px" },
	                            { "width": "50px" },
	                            { "width": "300px" },
	                            { "width": "300px" },
	                            { "width": "300px" },
	                            { "width": "300px" },
	                            { "width": "300px" },
	                            { "width": "300px" },
	                            { "width": "200px" }           ]
			            });
			    	}
			    },
			    error: function(e){
			    	alert("Under Construction!!!");
			    	//alert('Error: ' + JSON.stringify(e));
			    }
			});
		}
	}

	<%-- window.setInterval(function(){ // Set interval for checking
	    var date = new Date(); // Create a Date object to find out what time it is
	    alert("alert at "+date);
	    if(date.getHours() === 3 && date.getMinutes() === 0){ // Check the time
	    	var ct="<%=request.getContextPath()%>";
			$.ajax({
			    type: "get",
			    url: ct+"/getStatus",
			    success: function(data){

			    },
	    		error:function() {
	    			alert("Status not saved Please try again ");
	    		}
	    	});
	    }
	}, 30000); // Repeat every 60000 milliseconds 1 minute

 --%>

<%-- 	$(window).load(function(){
		$("#topNavigation").append("<a id='admin' href='#'><i class='fa fa-user-secret'></i> Admin</a>"+
				"<a id='logout' href='logout'><i class='fa fa-power-off'></i> Logout</a>"+
				"<label>Welcome</label>&nbsp&nbsp&nbsp<%=session.getAttribute("UserName")%>");
	}); --%>
</script>
