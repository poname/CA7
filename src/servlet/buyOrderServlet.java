package servlet;

import exception.*;
import logic.Core;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class buyOrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String inst = request.getParameter("instrument");
        String price = request.getParameter("price");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String type = request.getParameter("type");

        String message = "successfully added" ;
        try {
            message = Core.getInstance().order_buy(id, inst, price , quantity , type);
        } catch (InvalidOrderTypeException | OrderIsDeclinedException | InvalidSymbolIdException | MismatchedParametersException | OrderIsQueuedException | UnknownUserIdException | NotEnoughCreditException e) {
            message = e.getMessage();
        }
        Core.getInstance().log();
        request.setAttribute("resultMessage", message);
        request.getRequestDispatcher("../result.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
