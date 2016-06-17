<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/datatables.min.css" type="text/css">
<link type="text/css" href="<%=request.getContextPath() %>/css/bootstrap.min.css" rel="stylesheet" >
<link type="text/css" href="<%=request.getContextPath() %>/css/font-awesome.min.css" rel="stylesheet" >
<link type="text/css" href="<%=request.getContextPath() %>/css/mainLayout.css" rel="stylesheet" >
<style type="text/css">
.mycontainer{overflow: scroll;
height:100%;width:100%; margin: 0px;padding: 0px;float: left;position: fixed;
}
.col-6{
height: 100%;
width: 46%;
margin: 25px;
padding: 0px;
float: left;
}
fieldset{padding: 15px; border: 1px dotted #d1d1d1;
}

</style>
</head>

<body >
<div class="col-xs-12 rootContainer">
	<!-- This is for Header -->
	<div class="col-xs-12 headerContainer"><jsp:include page="header.jsp"></jsp:include></div>

	<!-- This is for Body Content -->
	<div class="col-xs-12 contentContainer">
	<div  class="mycontainer">
	<c:if test="${  empty  msg   }">
	<div>
	${msg }
	</div>

	</c:if>

<form class="form-horizontal"  method="POST" action="<%=request.getContextPath()%>/regitrationProcess" commandname="Userpojo">
  <div id="legend" style="text-align: center;">
              <legend class="">Register User</legend>
            </div>
       <div class="col-6">
          <fieldset>


              <div class="control-group">
           <!--    <label class="control-label" onblur="validateUserName(this.value,this.id) for="firstname">Firstname</label> -->
              <div class="controls">
                <input name="firstname"  id="firstNameId" " placeholder="Enter First Name" class="form-control input-lg" required type="text">
                <p class="help-block">Firstname can contain any letters or numbers</p>
              </div>
            </div>

            <div class="control-group">
           <!--    <label class="control-label" onblur="validateUserName(this.value,this.id)" for="lastName">LastName</label> -->
              <div class="controls">
                <input name="lastName"  id="lastNameId"  placeholder="Enter lastName" class="form-control input-lg" type="text"  required>
                <p class="help-block">Please provide your LastName</p>
              </div>
            </div>

            <div class="control-group">
             <!--  <label class="control-label" for="userType">User Type</label> -->
              <div class="controls">
               <select required  name="userType" class="form-control input-lg"  >
				  <option value="Developer">Developer</option>
				  <option value="Delivery">Delivery</option>
				  <option value="admin">admin</option>
			  </select>
                <p class="help-block">userType</p>
              </div>
            </div>

           <div class="control-group">
             <!--  <label class="control-label" for="emailId">E-mail</label> -->
              <div class="controls">
                <input  type="email" name="emailId"  id="emailId"  placeholder="Enter email"	onblur="validateEmail(this.value)" required  class="form-control input-lg" >
                <p class="help-block">Please provide your E-mail</p>
              </div>
            </div>
          </fieldset>

</div>
<div class="col-6">

          <fieldset>
           <div id="legend" >
            </div>

            <div class="control-group">
              <!-- <label class="control-label" for="contactNo">Contact</label> -->
              <div class="controls">
                <input type="text" name="contactNo" id="contactNo" onblur="mobileNumberValidator(this.id)" placeholder="Enter mobileNo" required  class="form-control input-lg" >
                <p class="help-block">Mobile Number must be 10 digit</p>
              </div>
            </div>

            <div class="control-group">
              <!-- <label class="control-label" for="address">Address</label> -->
              <div class="controls">
                <textarea name="address" class="form-control" style="height: 45px;" rows="3"></textarea>
                <p class="help-block">Enter Address Here</p>
              </div>
            </div>

            <div class="control-group">
             <!--  <label class="control-label" for="password">Password</label> -->
              <div class="controls">
                <input id="password" name="password" placeholder="" class="form-control input-lg" type="password">
                <p class="help-block">Password should be at least 6 characters</p>
              </div>
            </div>

            <div class="control-group">
              <!-- <label class="control-label" for="password_confirm">Password (Confirm)</label> -->
              <div class="controls">
                <input id="password_confirm" name="password_confirm" placeholder="" class="form-control input-lg" type="password">
                <p class="help-block">Please confirm password</p>
              </div>
            </div>

            <div class="control-group">


            </div>
          </fieldset>
          </div>
		     <div class="controls" style="text-align: center; ">
                <button  type="submit" style="margin-top: 5px;" class="btn btn-success">Register</button>
              </div>
 </form>



</div>
	</div>
	<div class="footerContainer"><jsp:include page="footer.jsp"></jsp:include> </div>
</div>
	<%-- <form action="<%=request.getContextPath()%>/regitrationProcess" commandname="Userpojo">
	<div id="messageDiv" style="font-size: 20px;color:red;display:none;"></div>
		    <input type="text" name="firstname"  id="firstNameId" onblur="validateUserName(this.value,this.id)" placeholder="Enter firstName" required /><br>
			 <input type="text"	name="lastName"  id="lastNameId" onblur="validateUserName(this.value,this.id)" placeholder="Enter lastName" required /><br>
			  <select required  name="userType" >
			  <option value="Developer">Developer</option>
			  <option value="Delivery">Delivery</option>
			  <option value="admin">admin</option>
			  </select></br>
		   <input type="email" name="emailId"  id="emailId"  placeholder="Enter email"	onblur="validateEmail(this.value)" required /><br>

	     	<input type="text" name="contactNo" id="contactNo" onblur="mobileNumberValidator(this.id)" placeholder="Enter mobileNo" required /><br>
			<textarea rows="3" cols="7" name="address"></textarea><br>
	     <input	type="password" name="password" onblur="checkPassword(this.value)" id="textpassword" placeholder="Enter password" required /><br>
			<input type="password" name="re-password"  onkeypress="Validatepassword()" id="retextpassword" placeholder="re Enter password" required /><br>

		<input type="submit" value="submit">
	</form> --%>
</body>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.12.1.min.js"></script>
<script type="text/javascript"	src="<%=request.getContextPath()%>/js/datatables.min.js"></script>

<script type="text/javascript">


	function Validatepassword() {
        var password = document.getElementById("textpassword").value;
        var confirmPassword = document.getElementById("retextpassword").value;
        if (password != confirmPassword  ) {
            document.getElementById("retextpassword").focus();
            return false;
        }
        return true;
    }
	 function checkPassword(str)
	  {//alert(str);
	    var re = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}$/;
	    if(re.test(str)===false){
	    	 document.getElementById("textpassword").focus();
	    	 return false;
	    }else{
	    	return true;
	    }
	  }
	/* function validateUserName(username,thiso){
		 re = /^\ w+$/;
		    if(!re.test(username)) {
		      alert("Error: Username must contain only letters, numbers and underscores!");
		     // document.getElementById(thiso).value="";
		      document.getElementById(thiso).focus();
		      return false;
		    }else{
		    	return true;
		    }

	} */

	function mobileNumberValidator(txtMobId) {
		/* var fld = document.getElementById(txtMobId);
		if (fld.value == "") {
			alert("You didn't enter a phone number.");
			fld.value = "";
			fld.focus();
			return false;
		} else if (isNaN(fld.value)) {
			alert("The phone number contains illegal characters.");
			fld.value = "";
			fld.focus();
			return false;
		} else if (!(fld.value.length == 10)) {
			alert("The phone number is the wrong length. \nPlease enter 10 digit mobile no.");
			fld.value = "";
			fld.focus();
			return false;
		}
		return true; */
	}
	 $(document).ready(function() {
	        $('.numberclass').keypress(function (event) {
	            return isNumber(event, this)
	        });
	    });
	    // THE SCRIPT THAT CHECKS IF THE KEY PRESSED IS A NUMERIC OR DECIMAL VALUE.
	    function isNumber(evt, element) {
	        var charCode = (evt.which) ? evt.which : event.keyCode
	        if (
	            (charCode != 45 || $(element).val().indexOf('-') != -1) &&      // “-” CHECK MINUS, AND ONLY ONE.
	            (charCode != 46 || $(element).val().indexOf('.') != -1) &&      // “.” CHECK DOT, AND ONLY ONE.
	            (charCode <= 47 || charCode >= 57)){
	        	$(this).value="";
	        	$(this).focus();
	        	return false;
	        }


	        return true;
	    }


/* 	    $(function() {
		$.getJSON("https://api.ipify.org?format=jsonp&callback=?", function(
				json) {
			$("#ipaddress").attr("value",json.ip);
			//alert(json.ip);
		});
	}); */
	function validateRegisterEmailId(){
		var emailId=$("#emailId").val();

		$.ajax({
		    type: "post",
		    url: "validateRegisterEmailId?emailId="+emailId,
		    success: function(data){//alert(data)
		    	if(data==""){
		    		$("#messageDiv").css("display","none");
		    	}else{
		    	document.getElementById("User_NameId").focus();
		    	$("#messageDiv").css("display","block");
		    	$("#messageDiv").css("color","red");
		    	$("#messageDiv").html(data);
		    	}
		    },
    		error:function() {
    			alert("validateRegisterEmailId error")
    		}
    	});
	}
	function validateEmail(email) {
		validateRegisterEmailId();
		var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
		if (!filter.test(email)) {
			email.focus;
			return false;

		}
	}
</script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.12.1.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/bootstrap.min.js" ></script>
</html>