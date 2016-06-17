<%
HttpSession sessionObj=request.getSession(false);
if(!sessionObj.isNew()){
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%String ctxPath=request.getContextPath(); %>
   <link rel="stylesheet" href="<%= ctxPath%>/css/datatables.min.css" type="text/css">
    <link rel="stylesheet" href="<%= ctxPath%>/css/bootstrap.min.css" type="text/css"/>
    <link rel="stylesheet" href="<%= ctxPath%>/css/font-awesome.min.css" type="text/css"/>
    <link rel="stylesheet" href="<%= ctxPath%>/css/global.css" type="text/css">
    <link href="<%= ctxPath%>/css/entryPanel.css" type="text/css" rel="stylesheet">
</head>
<body>
    <div id='entryPanel' class="rootContainer">
    <div class="leftSection">
        <div class="top">
            <div class="tblDiv">
            <table id='entryPanelTbl1' class="table table-striped table-hover table-condensed">
            <thead>
                <tr>
                    <td>SL</td>
                    <td>NAME</td>
                    <td>RATE</td>
                    <td>RUN</td>
                    <td>AMOUNT</td>
                    <td>YN</td>
                    <td>NO</td>
                    <td>YES</td>
                    <td>AT TIME</td>
                    <td>AT TIME 1</td>
                    <td>AT TIME 2</td>
                    <td>AT TIME 3</td>
                    <td>AT TIME 4</td>
                    <td>AT TIME 5</td>
                </tr>
            </thead>
            <tbody>
            <c:forEach var='i' begin="0" end="30">
            	<tr>
                    <td>Demo Data 1</td>
                    <td>Demo Data 2</td>
                    <td>Demo Data 3</td>
                    <td>Demo Data 4</td>
                    <td>Demo Data 5</td>
                    <td>Demo Data 6</td>
                    <td>Demo Data 7</td>
                    <td>Demo Data 8</td>
                    <td>Demo Data 9</td>
                    <td>Demo Data 9</td>
                    <td>Demo Data 9</td>
                    <td>Demo Data 9</td>
                    <td>Demo Data 9</td>
                    <td>Demo Data 9</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
                </div>
        </div>
        <div class="bottom">
            <div class="first">
                <button class="btn btn-primary fllt mgrt">Modify</button>
                <span class="fllt mgrt"><input class='form-control fllt mgrt' type="text"></span>
                <span class="fllt mgrt"><input class='form-control fllt mgrt' type="text"></span>
                <button class="btn btn-primary fllt mgrt">Show All</button>
            </div>
            <div class="second">
                <div class="top">
                    <span class="fllt mgrt">Rate</span>
                    <span class="fllt mgrt">Run</span>
                    <span class="fllt mgrt">Amount</span>
                    <span class="fllt mgrt">Y/N</span>
                    <span class="fllt mgrt">Name</span>
                </div>
                <div class="bottom">
                    <input class="form-control fllt mgrt" type="text">
                    <input class="form-control fllt mgrt" type="text">
                    <input class="form-control fllt mgrt" type="text">
                    <select class="form-control fllt mgrt">
                        <option>Demo 1</option>
                        <option>Demo 2</option>
                        <option>Demo 3</option>
                    </select>
                    <select class="form-control fllt mgrt">
                        <option>Demo 1</option>
                        <option>Demo 2</option>
                        <option>Demo 3</option>
                    </select>
                    <button class="btn btn-primary fllt mgrt">Ok</button>
                    <button class="btn btn-primary  fllt mgrt">Close</button>
                </div>
            </div>
        </div>
    </div>
    <div class="rightSection">
    <div class="tblDiv">
    	<table id='entryPanelTbl2'  class="table table-striped table-hover table-condensed">
            <thead>
                <tr>
                    <td>RUNS</td>
                    <td>AMOUNT</td>
                </tr>
            </thead>
            <tbody>
            <c:forEach var='i' begin="0" end="30">
                <tr>
                    <td>Demo Data 1</td>
                    <td>Demo Data 2</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    </div>
    </div>
</body>
     <script src="js/jquery-1.12.1.min.js" type="text/javascript"></script>
   <script src="js/datatables.min.js" type="text/javascript"></script>
    <script type="text/javascript">
        function adjustments(){
            $('#entryPanelTbl1').DataTable({
                "scrollY":  "70vh",
                "scrollCollapse": true,
                "paging":         false,
                "info":     false,
                "filter":false,
                "scrollX": true,
                "fixedHeader": false,
                "order": [[ 0, "desc" ]],
                 "columns": [
                   { "width": "100px" },
                   { "width": "200px" },
                   { "width": "200px" },
                   { "width": "200px" },
                   { "width": "200px" },
                   { "width": "200px" },
                   { "width": "200px" },
                   { "width": "200px" },
                   { "width": "200px" },
                   { "width": "200px" },
                   { "width": "200px" },
                   { "width": "200px" },
                   { "width": "200px" },
                   { "width": "200px" },
                  ]
            });
            $('#entryPanelTbl2').DataTable({
                "scrollY":        "85vh",
                "scrollCollapse": true,
                "paging":         false,
                "info":     false,
                "filter":false
            });
        }
        function resizeDoc(){
        }
        $(document).ready(function(){
            //alert("hi")
            adjustments();
            resizeDoc();
        });
        $(window).resize(function(){resizeDoc();});
    </script>
</html>


<%}%>