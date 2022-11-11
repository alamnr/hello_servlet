<%-- <%@ taglib prefix="mine" uri="DiceFunctions" %> --%>
<%@ taglib prefix="mine"  uri="/WEB-INF/function.tld" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title>El to test request param</title>
</head>
<body>
  Request param name is : ${param.name} <br/><br/>
  Request param empId is : ${param.empId}  <br/><br/>
  Request param food is : ${param.food}  <br/><br/>
  First food request param: ${paramValues.food[0]}<br/><br/>
  Second food request param: ${paramValues.food[1]}<br/><br/>
  Request param name : ${paramValues.name[0]}<br/><br/>
  Host is: <%=request.getHeader("host")%><br/><br/>
  Host is: ${header.host}<br/><br/>
  Host is: ${header["host"]}<br/><br/>
  Request Method: <%= request.getMethod()  %> <br/><br/>  
  Request Method: ${pageContext.request.method}<br/><br/>
  Cookie: ${cookie.JSESSIONID.value}<br/><br/>
  Cookie: ${cookie["JSESSIONID"]["value"]}<br/><br/>
  <% Cookie[]  cookies = request.getCookies();
  for(int i = 0; i<cookies.length;i++){
    if((cookies[i].getName()).equals("JSESSIONID")){
        out.println("<p>Cookie using scriptlet: "+cookies[i].getValue()+"</p><br/><br/>");
    }
  } %>

   Email is : <%= application.getInitParameter("mainEmail")  %></br><br/>
   Email is : ${initParam["mainEmail"]}</br><br/>

   Dice Value: ${mine:rollIt()}
</body>

</html>