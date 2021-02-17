package servlets;

import org.apache.commons.text.StringEscapeUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/")
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (PrintWriter out = response.getWriter()) {
            out.println("<html><body>");
            out.println("<h3>Enter your name:</h3>");
            out.println("<form method='post'>");
            out.println("<input type='text' name='firstName'>");
            out.println("<input type='text' name='lastName'>");
            out.println("<input type='submit' name='Say Hello'>");
            out.println("</form>");
            out.println("</body></html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (PrintWriter out = resp.getWriter()) {
            out.println("<html><body>");
            String firstName = StringEscapeUtils.escapeHtml4(req.getParameter("firstName"));
            String lastName = StringEscapeUtils.escapeHtml4(req.getParameter("lastName"));
            out.println("Hello " + firstName + " " + lastName);
            out.println("</body></html>");
        }
    }
}
