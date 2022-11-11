<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- Hello: <c:out value="${param.userName}"  default="guest" /></br> --%>
Hello: <c:out value="${param.userName}">guest</c:out></br>
We're sorry , you need to log in again.
</br>
<c:if test="${not empty movies}">
   <table>
   <c:forEach var="listItem" items="${movies}">
        <c:forEach var="movie" items="${listItem}">
            <tr>
                <td>${movie}</td>
            </tr>
        </c:forEach>
   </c:forEach>
   </table>
</c:if>

<form action="${pageContext.request.contextPath}/jsp/hello.jsp" method="get">

Name:<input type="text" name = "userName"></br>
Hobbies: 
<input type="checkbox" name="hobbies" value="play">Play football </br>
<input type="checkbox" name="hobbies" value="sing">Sing a song </br>
<input type="checkbox" name="hobbies" value="duck">duck duck </br>
<input type="checkbox" name="hobbies" value="fishing">Fishing </br>
<input type ="submit">
</form>