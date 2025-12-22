<%@ page contentType="text/html;charset=UTF-8" isErrorPage="true" %>
<html>
<head><title>Error</title></head>
<body>
<h2>Something went wrong</h2>

<p style="color:red;">
    <%= request.getAttribute("error") != null 
        ? request.getAttribute("error") 
        : "Unexpected error occurred. Please try again later." %>
</p>

<a href="login.jsp">Go to Login</a>
</body>
</html>
