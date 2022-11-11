<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Forward test</title>
</head>
<body>
Welcome to our page :<%--  <% out.flush(); %> --%>
<%-- <% if(request.getParameter("userName")==null || "".equals(request.getParameter("userName"))){ %>
    <jsp:forward page="handleIt.jsp"/>
<%}%>  --%>
<c:if test="${empty param.userName}">
    <jsp:forward page="handleIt.jsp"/>
</c:if>
</br>
Divide: ${5/0}</br>
<%-- Mod:${8%0}</br> --%>


Hello : <c:out value="${param.userName}"  default="guest" /></br>

 Hobbies-1:${paramValues.hobbies[0]}   -   ${param.hobbies}  -  ${paramValues.hobbies[1]}   
${paramValues.hobbies}   </br>

<table>
<% String[] items = {"Abc","def","ghi"};
    String var = null;
    for (int i=0;i<items.length;i++){
        var = items[i]; 
%>
<tr><td><%= var %> </td></tr>
<%  }  %>
</table>

</br>
Hobby list:  <table>

<c:forEach var="hob" items = "${paramValues.hobbies}" varStatus="loopCount">
<tr>    
    <td>Count-${loopCount.count}: ${hob} </td>
</tr>
</c:forEach>
</table>

</body>
</html>

