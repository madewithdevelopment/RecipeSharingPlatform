<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List, model.Recipe" %>
<%
  List<Recipe> recipes = (List<Recipe>) request.getAttribute("recipes");
%>
<html>
<head><title>All Recipes</title></head>
<body>

<div>
    <a href="listRecipes">Home</a> |
    <a href="addRecipe.jsp">Add Recipe</a> |
    <a href="logout">Logout</a>
</div>

<form action="searchRecipes" method="get" style="margin-top:10px;">
    <input type="text" name="q"
           placeholder="Search by title"
           value="<%= request.getAttribute("keyword") != null ? request.getAttribute("keyword") : "" %>" />
    <button type="submit">Search</button>
    <a href="listRecipes">Clear</a>
</form>
<hr/>

<h2>All Recipes</h2>

<% if (recipes != null && !recipes.isEmpty()) { %>
  <ul>
  <% for (Recipe r : recipes) { %>
    <li>
      <strong><%= r.getTitle() %></strong><br/>
      <em>Ingredients:</em> <%= r.getIngredients() %><br/>
      <em>Steps:</em> <%= r.getSteps() %><br/>
      By user id: <%= r.getUserId() %>
    </li>
  <% } %>
  </ul>
<% } else { %>
  <p>No recipes found.</p>
<% } %>

</body>
</html>
