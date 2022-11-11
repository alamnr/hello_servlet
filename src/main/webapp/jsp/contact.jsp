<!DOCTYPE html>
<html lang="en">
<head>
    <title>Contact page</title>
</head>
<body>
<%-- <%@ include file="header.jsp" %> --%>
<jsp:include page="header.jsp">
    <jsp:param name="subTitle" value="We know how to make soap suck less" />
</jsp:include>
<br/><em>We can help.</em><br/><br/>
Contact us at: ${initParam["mainEmail"]}

<%@ include file="footer.html" %>
</body>
</html>