package servlet;

import exception.MismatchedParametersException;
import exception.RepeatedIdException;
import logic.Core;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class addCustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String family = request.getParameter("family");

        String message = "successfully added" ;
        try {
            Core.getInstance().customer_add(id, name, family);
        } catch (RepeatedIdException | MismatchedParametersException e) {
            message = e.getMessage();
        }
        Core.getInstance().log();

        response.setContentType("text/plain");
        response.setHeader("Content-Type", "text/plain");
        response.getWriter().print(message);

        //request.setAttribute("resultMessage", message);
        //request.getRequestDispatcher("../result.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
