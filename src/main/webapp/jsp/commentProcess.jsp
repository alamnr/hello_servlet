<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>Comment view</title>
</head>
<body>

<strong>Member comments</strong></br>
<hr/>
<table>
<c:forEach var="comment" items="${commentList}">
    <tr><td>${comment}</td></tr>
</c:forEach>
</table>
<hr/>
<c:if test="${param.userType eq 'member'}">
    <jsp:include page="inputComments.jsp"/>
</c:if>
</body>
</html>