import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.stream.Collectors;


@WebServlet(urlPatterns = {"/patients"},loadOnStartup = 1)
public class MyServlet extends HttpServlet {
    //recall doGet means to read some material
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {
        resp.setContentType("text/html"); //setting type of response
        resp.getWriter().write("Hello, World!"); //writing hello world to response
        resp.getWriter().write("<title>Adele's Servlet</title>");
        PrintWriter out = resp.getWriter();
        out.println("<HTML>\n" +
                "\n" +
                "<HEAD>\n" +
                "\n" +
                "<TITLE>Adele's Servlet</TITLE>\n" +
                "\n" +
                "</HEAD>\n" +
                "\n" +
                "<BODY BGCOLOR=\"FFFFFF\">\n" +
                "\n" +
                "<CENTER><IMG SRC=\"clouds.jpg\" ALIGN=\"BOTTOM\"> </CENTER>\n" +
                "\n" +
                "<HR>\n" +
                "\n" +
                "<a href=\"http://google.com\">This Link</a>\n" +
                "\n" +
                "MY LINK\n" +
                "\n" +
                "<H1>Welcome to  my Servlet!</H1>\n" +
                "\n" +
                "<H2>First Servlet of the year</H2>\n" +
                "\n" +
                "Send me mail at <a href=\"mailto:support@yourcompany.com\">\n" +
                "\n" +
                "support@yourcompany.com</a>.\n" +
                "\n" +
                "<P> hello there!\n" +
                "\n" +
                "<P> <B>morning!</B>\n" +
                "\n" +
                "<BR> <B><I>this is a very important sentence.</I></B>\n" +
                "\n" +
                "<HR>\n" +
                "\n" +
                "</BODY>\n" +
                "\n" +
                "</HTML>");
        System.out.print(req.getServletPath());

    }
    //recall doPost means to create something
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {
        String reqBody=req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        Gson gson = new Gson();
        Patient p = gson.fromJson(reqBody,Patient.class);
        //creating a JSON response
        resp.setContentType("application/json");
        resp.getWriter().write("Patient Received!" + reqBody);
        /*
        resp.setContentType("text/html");
        resp.getWriter().write("Thank you client! "+reqBody);
         */

    }
    /*public class MyClass {

        SQLQuery query = new SQLQuery();
        public void execute() {
            query.makeQuery();
        }
    }
     */
}