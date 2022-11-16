<%@ taglib prefix="myTag" tagdir="/WEB-INF/tags" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Contact page</title>
</head>
<body>
<%-- <%@ include file="header.jsp" %> --%>
<%-- <jsp:include page="header.jsp">
    <jsp:param name="subTitle" value="We know how to make soap suck less" />
</jsp:include> --%>
<%-- We use tag file header with attribute here <br/>
<myTag:header subTitle="We take the sting out of SOAP" /> --%>

We use tag file header with body content and without attribute here <br/>
<myTag:header fontColor="#660099">
    2 09:08:29.784 INFO [main] org.apache.catalina.startup.Catalina.start Server startup in [3614] milliseconds
15-Nov-2022 09:09:08.199 INFO [http-nio-8080-exec-2] com.async.listener.RequestAttributeListener.attributeReplaced P : org.apache.catalina.ASYNC_SUPPORTED -> true
15-Nov-2022 09:10:17.765 INFO
</myTag:header>
<br/><em>We can help.</em><br/><br/>
Contact us at: ${initParam["mainEmail"]}

<%@ include file="footer.html" %>
</body>
</html>