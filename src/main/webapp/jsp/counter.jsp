<%-- <%@ page import = "com.util.*" %>  --%>

<%@ page import = "java.util.*" %> 

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Page count</title>
</head>
<body>
    <%-- <h1>The Page count is: <%  out.println(Counter.getCount());    %></h1> --%>
    <%! int doubleCount(){
            count = count*2;
            return count;
    }  %>
    <%! int count = 1; %>
    <h1>The Page count is: <%= doubleCount() %></h1>
    <%! int x = 42; %>
    <% int x = 22; %>
     <% int z = 2; %>
    <% int y = 5+z; %>
   
    <p>value of x : <%= x %> </p>
    <% 
        //String hobbyName = request.getParameter("hobbyName");
        //ArrayList<String> friends = new ArrayList<>(Arrays.asList("Fred","Pradeep","Philippe"));
        //friends.add()
        ArrayList<String> al = (ArrayList<String>)request.getAttribute("names");

    %>
    <p>The friends who you share your hobby of <%=request.getParameter("hobbyName")%> are : </p>
    <%-- <% for(String name : friends ) 
        {
            out.println(name+"<br>");
        }
    %> --%>
    <% Iterator it = al.iterator();
    while(it.hasNext()) {%>
    <%= it.next() %> <br>
    <%}%>
</body>
</html>