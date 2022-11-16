<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="mine" uri ="DiceFunctions" %>
<html>
<head>
<title>Result of user preference</title>
</head>
<body>
    <h2>
    <%-- <%   
        String pref = (String)session.getAttribute("userPref");

        if(pref.equals("Performance")){
            out.println("Now you can stop even if you <em>do</em> drive insanely fast ...");
        }
        else if (pref.equals("Safety")){
            out.println("Our brakes won't lock up no matter how bad a driver you are.");
        }
        else if (pref.equals("Maintenance")){
            out.println("Lost your tech job? No problem--you won't have to service these brakes  for at least three years.");
        }
        else {
            out.println("Our breaks are the best");
        }
    %> --%>
    <%-- <c:if test="${userPref eq 'Performance'}">
        Now you can stop even if you <em>do</em> drive insanely fast ...
    </c:if>
    <c:if test="${userPref eq 'Safety'}" >
        Our brakes won't lock up no matter how bad a driver you are.
    </c:if>
    <c:if test="${userPref eq 'Maintenance'}">
        Lost your tech job? No problem--you won't have to service these brakes
        for at least three years.
    </c:if> --%>
    <c:choose>
        <c:when test="${userPref eq 'Performance'}">
            Now you can stop even if you <em>do</em> drive insanely fast ...
        </c:when>
        <c:when test="${userPref eq 'Safety'}">
             Our brakes won't lock up no matter how bad a driver you are.
        </c:when>
        <c:when test="${userPref eq 'Maintenance'}">
            Lost your tech job? No problem--you won't have to service these brakes
            for at least three years.
        </c:when>
        <c:otherwise>
            Our breaks are the best
        </c:otherwise>

    </c:choose>
</h2>
    <strong>The Brakes</strong> <br>
Our advanced anti-lock brake system (ABS) is engineered to give you the ability to 
steer even as you're stopping. We have the 
best speed sensors of any car this size. <br/>

<%-- <c:set var="userLevel" scope="session" value="Cowboy"/> --%>

<c:set var="userLevel" scope="session" >
    Sheriff, Bartender, Cowgirl
</c:set>
<h1>user level -  ${userLevel}</h1>

<c:set var="userLevel" scope="session" />
<h1>user level - ${userLevel}</h1>
<%  Map<String,String> eduMap= new HashMap();
    eduMap.put("sex","Female");
    request.getSession().setAttribute("eduMap",eduMap);
  %> 
<%-- <c:set target="${eduMap}"  property = "name"  value="Sabita"/> --%>
<c:set target="${eduMap}"  property = "name"  >
    Kabita
</c:set>
<p>map: ${eduMap["name"]} -  ${eduMap["sex"]}</p>

<c:set var="userStatus" scope="request" value="Brilliant"/>
<p>User status - ${userStatus}</p>
<c:remove var="userStatus" scope="request"/>
<p>User status now: ${userStatus}</p>
<c:import url="http://localhost:8080/hello_servlet/jsp/inputComments.jsp"/>

<%-- <c:import url="https://www.prothomalo.com/"/> --%>

<c:import url="header.jsp">
    <c:param name="subTitle" value="We take the sting out of SOAP"/>
</c:import>
<br/>
<c:set var="userName" value="Jane"/>
Advisor tag:

<mine:advice user="${userName}" /><br/>

<mine:advice>
    <jsp:attribute name="user">${userName}</jsp:attribute>
</mine:advice>

</body>

</html>
