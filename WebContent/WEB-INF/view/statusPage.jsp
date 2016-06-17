<%
HttpSession sessionObj=request.getSession(false);
System.out.println("ses id="+sessionObj.getId());
String userType=(String)sessionObj.getAttribute("userType");
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome To Progen Employee Daily Work Status Page</title>
<link type="text/css"
	href="<%=request.getContextPath() %>/css/bootstrap.min.css"
	rel="stylesheet">
<link type="text/css"
	href="<%=request.getContextPath() %>/css/mainLayout.css"
	rel="stylesheet">


<style type="text/css">
input[type='text'], input[type='number'] {
	height: 35px;
}

.mycontainer {
	overflow: scroll;
	height: 100%;
	width: 100%;
	margin: 0px;
	padding: 0px;
	float: left;
	position: fixed;
}

.col-6 {
	height: 100%;
	width: 50%;
	margin: 0px;
	padding: 0px;
	float: left;
}

.col-12 {
	height: 100%;
	width: 100%;
	margin: 0px;
	padding: 0px;
	float: left;
}

fieldset {
	padding: 15px;
	border: 1px dotted #d1d1d1;
}

#addTaskSheetId {
	overflow: auto;
	max-height: 300px;
}

.thead-td {
	padding: 12px;
	border-bottom: 0.5px dotted #d2d2d2;
}

tbody tr {
	border-bottom: 0.5px dotted #d2d2d2;
	padding: 5px;
	margin: 5px;
}
/* td{border-left: 1px solid #d2d2d2;border-right: 1px solid #d2d2d2;} */
</style>
</head>

<body>
	<div class="col-xs-12 rootContainer">
		<!-- This is for Header -->
		<div class="col-xs-12 headerContainer"><jsp:include
				page="header.jsp"></jsp:include></div>
		<div id='adminNavigation' class='col-xs-12'>
			<span class='adminMnu '
				onclick='openUrl("<%=request.getContextPath() %>/adminHome")'>Home</span>
			<span class='adminMnu'
				onclick='openUrl("<%=request.getContextPath() %>/adminManageUser")'>Manage
				Users</span> <span class='adminMnu'
				onclick='openUrl("<%=request.getContextPath() %>/adminhome")'>Manage
				Session</span> <span class='adminMnu '
				onclick='openUrl("<%=request.getContextPath() %>/registrationPage")'>Register
				User</span> <span class='adminMnu active'
				onclick='openUrl("<%=request.getContextPath() %>/statusPage")'>User
				Status</span>
		</div>
		<!-- This is for Body Content -->
		<div class="col-xs-12 contentContainer">
			<div class="mycontainer">
				<!-- This is for Message Div -->
				<div id="messageDiv"
					style="display: none; font-size: 20px; text-align: center;">
				</div>
				<!-- This is for Status Content -->
				<%-- <form class="form-horizontal"  method="POST" action="<%=request.getContextPath()%>/savestatus" commandname="UserStatusList"> --%>
				<div class="col-12  table-responsive">

					<table id="my-status-table">
						<thead>
							<tr>
								<th class="thead-td">TaskId</th>
								<th class="thead-td">Task Description</th>
								<th class="thead-td">Task Status</th>
								<th class="thead-td">Time</th>
							</tr>
						</thead>
						<tbody id="addTaskSheetId">
							<tr id="tr0">
								<td style="width: 10%;"><input type="text"
									name="dailyTaskId" id="dailyTaskId0" required
									placeholder="Enter Task Id" /></td>
								<td style="width: 55%;"><input type="text"
									name="taskDetail" id="taskDetail0" style="width: 90%;"
									maxlength="400" required placeholder="Enter Task Detail " /></td>

								<td style="width: 15%;">
								<select name="taskStatus0" id="taskStatusId0">
									<option>-- Select --</option>
									<option value="Working"> Working </option>
									<option value="Completed"> Completed </option>
									<option value="Dev Testing"> Dev Testing </option>
									<option value="QA Testing"> QA Testing </option>
								</select>
								</td>



								<td style="width: 20%;"><input type="text" name="totalTime"
									id="totalTime0" required
									placeholder="Integer only" /></td>

							</tr>
						</tbody>
						<tfoot>
							<tr>
								<td></td>
								<td
									style="text-align: right; font-weight: bold; font-size: 14px;">
									DownTime</td>
								<td>
								<input type="text" name="downTime" id="downTimeId" 	value="0" placeholder="Enter Down Time in Hours" />
								<input  type="hidden" name="userId" id="userId" value="${userId }" />
								</td>

							</tr>
							<tr>
								<td></td>
								<td style="text-align: center;"><input type="button"
									class="btn btn-success" onclick="deleteTaskSheet();"
									value="Delete Task" /> <input type="button"
									class="btn btn-success" onclick="addTaskSheet();"
									value="Add Task" /> <input type="button"
									class="btn btn-success" value="Send Status"
									onclick="sendStatus();" /></td>
								<td></td>
							</tr>
						</tfoot>
					</table>
				</div>
				<!-- </form> -->



			</div>
		</div>
		<!-- This is for Footer -->
		<div class="footerContainer"><jsp:include page="footer.jsp"></jsp:include>
		</div>
	</div>
</body>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery-1.12.1.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/datatables.min.js"></script>

<script type="text/javascript">
$('#my-status-table').DataTable({
    "scrollY":  "60vh",
    "scrollCollapse": true,
    "paging":         false,
    "info":     false,
    "filter":false,
    "scrollX": false,
    "fixedHeader": true,
    "columns": [
        { "width": "20%" },
        { "width": "60%" },
        { "width": "10%" },
        { "width": "10%" },
       ],

});
var count=1;
	function sendStatus(){

		var tskIds=[];
		var tskDtl=[];
		var tskTtime=[];
		var tskStatus=[];
		var userId=$("#userId").val();
		var downtime=$("#downTimeId").val();
		for(var i=0;i<count;i++){
			tskIds.push($("#dailyTaskId"+i).val());
			tskDtl.push($("#taskDetail"+i).val());
			tskTtime.push($("#totalTime"+i).val());
			tskStatus.push($("#taskStatusId"+i).val());
		}
		var ct="<%=request.getContextPath()%>";
		$.ajax({
		    type: "get",
		    url: ct+"/savestatus1/"+tskIds+"/"+tskDtl+"/"+tskTtime+"/"+userId+"/"+downtime+"/"+tskStatus,
		    success: function(data){
		    	if(data===""){
		    		$("#messageDiv").html("Your status Saved Successfully");
		    		$("#messageDiv").css({"display":"block","color":"Green"})
		    		setTimeout(function(){
		    			$("#messageDiv").css({"display":"none","color":"Green"});
		    			openUrl("<%=request.getContextPath() %>/statusPage");
		    		}, 10000);

		    	}else{
		    		$("#messageDiv").html(data);
		    		$("#messageDiv").css({"display":"block","color":"Red"});
		    		setTimeout(function(){
			    		$("#messageDiv").css({"display":"none","color":"Red"});
		    		}, 6000);
		    	}
		    },
    		error:function() {
    			alert("Status not saved Please try again ");
    		}
    	});
	}



	function addTaskSheet(){

	var	statushtml="";
	    statushtml+="<tr id='tr"+count+"' >";
		statushtml+="<td><input type='text' name='dailyTaskId"+count+"' id='dailyTaskId"+count+"' required placeholder='Enter Task Id'/></td>";
		statushtml+="<td><input type='text' name='taskDetail"+count+"'  style='width: 90%;' maxlength='400'  id='taskDetail"+count+"' required placeholder='Enter Task Detail '/></td>";
		statushtml+="<td style='width: 15%;'><select name='taskStatus"+count+"' id='taskStatusId"+count+"'>";
		statushtml+="	<option>-- Select --</option><option value='Working'> Working </option><option value='Completed'> Completed </option>";
		statushtml+="	<option value='Dev Testing'> Dev Testing </option><option value='QA Testing'> QA Testing </option></select></td>";

		statushtml+="<td><input type='text' name='totalTime"+count+"' id='totalTime"+count+"' required placeholder='Time in Integer only'/></td>";
		statushtml+="</tr>";

		$("#addTaskSheetId").append(statushtml);
		count++;
	}

	function deleteTaskSheet(){

		if(count>0||count==1){

			if(count==0||count==1){
				count=1;
			}else{
				count--;
			}
			$("#tr"+count).remove();
		}//alert(count)
	}
	 // THE SCRIPT THAT CHECKS IF THE KEY PRESSED IS A NUMERIC OR DECIMAL VALUE.
	   function isNumber(evt, element) {
	        var charCode = (evt.which) ? evt.which : event.keyCode
	        if (
	            (charCode != 45 || $(element).val().indexOf('-') != -1) &&      // “-” CHECK MINUS, AND ONLY ONE.
	            (charCode != 46 || $(element).val().indexOf('.') != -1) &&      // “.” CHECK DOT, AND ONLY ONE.
	            (charCode <= 47 || charCode >= 57)){
	        	//$(this).value="";

	        	$(this).focus();
	        	return false;
	        }


	        return true;
	    }

	 $(document).ready(function() {
	        $('.numberclass').keypress(function (event) {
	            return isNumber(event, this)
	        });
	    });

</script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery-1.12.1.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
</html>
