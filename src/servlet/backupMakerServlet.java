package servlet;

import logic.Core;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;


public class backupMakerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
    {
        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment; filename=\"backup.csv\"");
        try
        {
            OutputStream outputStream = response.getOutputStream();
            String outputResult = service.csvBackup.getInstance().make_backup();;
            outputStream.write(outputResult.getBytes());
            outputStream.flush();
            outputStream.close();
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
    }
}