<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Add Recipe</title></head>
<body>

<div>
    <a href="listRecipes">Home</a> |
    <a href="addRecipe.jsp">Add Recipe</a> |
    <a href="logout">Logout</a>
</div>
<hr/>

<h2>Add Recipe</h2>

<% String error = (String) request.getAttribute("error"); %>
<% if (error != null) { %>
  <p style="color:red;"><%= error %></p>
<% } %>

<form action="addRecipe" method="post">
    <label>Title:</label><br/>
    <input type="text" name="title" required maxlength="100"><br/><br/>

    <label>Ingredients:</label><br/>
    <textarea name="ingredients" rows="4" cols="40" required></textarea><br/><br/>

    <label>Steps:</label><br/>
    <textarea name="steps" rows="4" cols="40" required></textarea><br/><br/>

    <button type="submit">Save</button>
</form>

</body>
</html>
