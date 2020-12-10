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
        resp.setContentType("text/html");
        resp.getWriter().write("Thank you client! "+reqBody);
        //creating a JSON response
        resp.setContentType("application/json");
        //how do i pull in the patient value from client?
        //String reqBody2 = req.getReader().lines().collect(Collectors.joining());
    }
    public void makeQuery(){
        //establishing connection
        String dbUrl = "jdbc:postgresql://localhost:5432/postgres";
        try {
            // Registers the driver
            Class.forName("org.postgresql.Driver");
        } catch (Exception e) {
        }
        try {
            Connection conn= DriverManager.getConnection(dbUrl, "postgres", "690922@Yd");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        //inputting things into database
        try {
            Connection conn = null;
            //creating a statement from extracting createstatement from conn
            Statement s=conn.createStatement();
            //creating a string in SQL language
            String sqlStr = "INSERT INTO patientofdoctor (patientid,doctorid) values (1,2);";
            s.execute(sqlStr);
            sqlStr = "INSERT INTO patientofdoctor (patientid,doctorid) values (2,2);”;
            s.execute(sqlStr);
            s.close();
            conn.close();
        }
        catch (Exception e){
        }
        try {
            Connection conn = null;
            Statement s=conn.createStatement();
            String sqlStr = "SELECT * FROM patients WHERE id>1;”;
            ResultSet rset=s.executeQuery(sqlStr);
            while(rset.next()){
                System.out.println(rset.getInt("id")+" "+ rset.getString("familyname"));
            }
            rset.close();
            s.close();
            conn.close();
        }
        catch (Exception e){
        }
    }

}