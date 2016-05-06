package servlet;

import exception.MismatchedParametersException;
import exception.NotEnoughCreditException;
import exception.RepeatedIdException;
import exception.UnknownUserIdException;
import logic.Core;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class depositCustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");

        String amount = request.getParameter("amount");

        String message = "successfully" ;
        try {
            Core.getInstance().customer_deposit(id, Integer.valueOf(amount));
        } catch (MismatchedParametersException | UnknownUserIdException e) {
            message = e.getMessage();
        }
        Core.getInstance().log();
        request.setAttribute("resultMessage", message);
        request.getRequestDispatcher("../result.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
