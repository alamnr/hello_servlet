<%-- <%@ page import="com.bean.Person"%> --%>
<!DOCTYPE html>
<html lang="en">
<head>

<title> El test </title>
</head>
<body>
    <%-- <h1> Hello : <%= request.getAttribute("name") %></h1>   
    <h1> Person is: <%= ((Person)request.getAttribute("person")).getName()  %>  </h1> --%>
    <%-- <h1> Hello: <jsp:getProperty name="name" /></h1> --%>
    <jsp:useBean id="person" type="com.bean.Employee" class="com.bean.Employee" scope="request">
       <%--  <jsp:setProperty name="person" property="name" value="Not Found"/> --%>
       <%-- <jsp:setProperty name="person" property="name" value='<%= request.getParameter("e_name") %>'/> --%>
       <%-- <jsp:setProperty name="person" property="empId" value='<%= request.getParameter("e_empId") %>'/> --%>
       <%-- <jsp:setProperty name="person" property="name" param="e_name"/>
       <jsp:setProperty name="person" property="empId" param="e_empId"/> --%>
       <jsp:setProperty name="person" property="*"/>
    </jsp:useBean>
    <%-- <% person.setName(request.getParameter("e_name"));%> --%>
    <h1>Employee name : <jsp:getProperty name="person" property="name" /></h1>
    <h1>Employee id : <jsp:getProperty name="person" property="empId" /></h1>
    <%-- <h1>Dog name: <%= ((com.bean.Employee)request.getAttribute("person")).getDog().getName()  %></h1> --%>
    <h1> Dog name is : ${person["dog"].name} </h1>
    <h1>Music: ${musicList[numbers[0]]}</h1>
    <h1>Music: ${musicList[numbers[0]+1]}</h1>
    <h1>Music: ${musicList[numbers["2"]]}</h1>
    <h1>Music: ${musicList[numbers[numbers[1]]]}</h1>

    <jsp:useBean id="employee"  class="com.bean.Employee" scope="request" />
    <h1>${employee["name"]}'s dog ${employee["dog"].name}'s toys are : 
    ${employee["dog"]["toys"]["0"]["name"]},
    ${employee["dog"]["toys"]["1"]["name"]},
    ${employee["dog"]["toys"]["2"]["name"]} </h1>
</body>

</html>