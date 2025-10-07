<!DOCTYPE html>
<html>
<head>
    <title>Booking Successful</title>
</head>
<body>
    <h2>Booking Confirmed!</h2>
    <p>You have successfully booked the movie:
        <strong><%= request.getAttribute("movieName") %></strong></p>
    <a href="movies.jsp">Book another</a> | <a href="login.jsp">Logout</a>
</body>
</html>
