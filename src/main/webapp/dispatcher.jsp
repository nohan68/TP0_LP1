<%@ page import="java.util.ArrayList" %>
<html>
    <head>

    </head>
    <body>
        <h1>Dispatcher JSP</h1>
    </body>
    <table>
    <%
        for (String s : (ArrayList<String>) request.getAttribute("list")){ %>
          <td><%=s%></td>
        <%}%>
    </table>
</html>