<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%
    HttpSession session = request.getSession(false);
    if (session == null || session.getAttribute("user") == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>Available Movies</title>
</head>
<body>
    <h2>Welcome, <%= session.getAttribute("user") %>!</h2>
    <h3>Select a movie to book:</h3>
    <form action="book" method="post">
        <select name="movie" required>
            <option value="Inception">Inception</option>
            <option value="Interstellar">Interstellar</option>
            <option value="Avengers">Avengers</option>
            <option value="Jawan">Jawan</option>
        </select>
        <br><br>
        <input type="submit" value="Book Ticket">
    </form>
</body>
</html>
