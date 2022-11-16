<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page errorPage="globalError.jsp"%>
<html>
<head>
</head>
<body>
About to do a risky thing: <br>
<c:catch var="myException">
 
 <% int x = 10/0; %>
 
</c:catch>
<c:if test="${myException !=null}">
    There was an exception: ${myException.message}
</c:if>
<%-- There was an exception: ${pageContext.exception} --%>
<br/>
If you see this, we survived.
</body>

</html>
