package servlet;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import service.SampleDataLoader;
import sun.nio.ch.IOUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;


public class SampleDataServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        InputStream input = getServletContext().getResourceAsStream("sampleData.txt");
        String resp = SampleDataLoader.getInstance().load(input);

        response.getWriter().print(resp);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}