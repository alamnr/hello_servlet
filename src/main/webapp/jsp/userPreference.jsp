<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<html>
<head>
<title>User preference </title>
</head>
<body>
<h1>When you buying a car , what is important to you?</h1>
<form action="${pageContext.request.contextPath}/tester" method="post">
    <input type="radio" id="per"  name="userPref" value="Performance"><label for="per">Performance</label></br>
    <input type="radio" id="safety" name="userPref" value="Safety"><label for="safety">Safety</label></br>
    <input type="radio" id="main" name="userPref" value="Maintenance"><label for="main">Maintenance</label></br>
    <input type="submit"  value="Submit">
</form>

<c:set var="first" value="Crouching Pixels"/>
<c:set var="last" value="Hidden Cursor"/>

<%-- <c:url value="jsp/contact.jsp?first=${first}&last=${last}" var="inputUrl"/> --%>
<c:url value="jsp/contact.jsp" var="inputUrl">
    <c:param name="firstName" value="${first}"/>
    <c:param name="lastName" value="${last}"/>
</c:url>
The url using param is : ${inputUrl} <br/>

<p>For any help, please <a href="<%= response.encodeURL("jsp/contact.jsp")  %>">contact from scriptlet encoding</a> us</p> 
<p>For any help, please <a href="<c:url value='jsp/contact.jsp?first=${first}&last=${last}'/>">contact from c:url encoding</a> us</p>

</body>
</html>
