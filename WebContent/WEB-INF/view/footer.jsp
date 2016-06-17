<%
HttpSession sessionObj=request.getSession(false);
if(!sessionObj.isNew()){
%>
<div class="footer">Footer</div>
<%} %>
