<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Login - Recipe Sharing</title>
</head>
<body>
<h2>Login</h2>

<% String error = (String) request.getAttribute("error"); %>
<% if (error != null) { %>
    <p style="color:red;"><%= error %></p>
<% } %>

<form action="login" method="post">
    <label>Email:</label><br/>
    <input type="email" name="username" required /><br/><br/>

    <label>Password:</label><br/>
    <input type="password" name="password" minlength="4" required /><br/><br/>

    <button type="submit">Login</button>
</form>

</body>
</html>
