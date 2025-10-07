package com.example.moviebooking;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if ("admin".equals(username) && "password".equals(password)) {
            HttpSession session = request.getSession();
            session.setAttribute("user", username);
            response.sendRedirect("movies.jsp");
        } else {
            response.setContentType("text/html");
            response.getWriter().println("<h3>Invalid credentials!</h3>");
            response.getWriter().println("<a href='login.jsp'>Try again</a>");
        }
    }
}
