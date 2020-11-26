import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(urlPatterns = {"/patients"},loadOnStartup = 1)
public class MyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {
        resp.setContentType("text/html"); //setting type of response
        //resp.getWriter().write("Hello, World!"); //writing hello world to response
        //resp.getWriter().write("<title>This is the Title of my Servlets</title>");
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
                "is a link to another nifty site\n" +
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

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {
    }
}
