<%@page session="false" import="java.util.Date,java.text.SimpleDateFormat"%>

Output from async1.jsp

Type is <%= request.getDispatcherType() %>

<%
    System.out.println("Inside Async 1");
    if (request.isAsyncStarted()) {
    request.getAsyncContext().complete();
  }
  Date date = new Date(System.currentTimeMillis());
  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z");
%>

Completed async request at <%=sdf.format(date)  %>

