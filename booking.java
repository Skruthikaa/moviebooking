package com.example.moviebooking;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class BookingServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String movieName = request.getParameter("movie");
        HttpSession session = request.getSession(false);

        if (session != null && session.getAttribute("user") != null) {
            request.setAttribute("movieName", movieName);
            RequestDispatcher rd = request.getRequestDispatcher("bookingSuccess.jsp");
            rd.forward(request, response);
        } else {
            response.sendRedirect("login.jsp");
        }
    }
}
