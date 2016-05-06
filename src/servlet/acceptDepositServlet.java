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
import java.util.HashMap;


public class acceptDepositServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
        String id = request.getParameter("id");
        int amount = Integer.parseInt(request.getParameter("amount"));

        String message = "successfully" ;
        try {
            Core.getInstance().accept_deposit(id, amount);
        } catch (MismatchedParametersException | UnknownUserIdException e) {
            message = e.getMessage();
        }
        request.setAttribute("resultMessage", message);
        request.getRequestDispatcher("result.jsp").forward(request, response);
        */
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
        String op = request.getParameter("op");
        if(op == null){
            HashMap list = (HashMap) Core.getInstance().getDepositRequests();
            request.setAttribute("requestList", list);
            request.getRequestDispatcher("deposit_request_list.jsp").forward(request, response);
        }
        else {
            String id = request.getParameter("id");
            String amount = request.getParameter("amount");

            String message = "successfully" ;
            try {
                if(op.equals("accept"))
                    Core.getInstance().acceptDeposit(id, amount);
                else if(op.equals("decline"))
                    Core.getInstance().declineDepositRequest(id, amount);
            } catch (MismatchedParametersException | UnknownUserIdException e) {
                message = e.getMessage();
            }
            Core.getInstance().log();
            request.setAttribute("resultMessage", message);
            request.getRequestDispatcher("../result.jsp").forward(request, response);
        }
        */
    }
}
