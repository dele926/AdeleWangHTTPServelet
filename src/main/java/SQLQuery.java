import java.sql.*;

public class SQLQuery {
    public void makeQuery(){
        //establishing connection
        String dbUrl = System.getenv("JDBC_DATABASE_URL");
        try {
            // Registers the driver
            Class.forName("org.postgresql.Driver");
        } catch (Exception e) {
        }
        try {
            Connection conn= DriverManager.getConnection(dbUrl);
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
            sqlStr = "INSERT INTO patientofdoctor (patientid,doctorid) values (2,2);";
            s.execute(sqlStr);
            s.close();
            conn.close();
        }
        catch (Exception e){
        }
        try {
            Connection conn = null;
            Statement s=conn.createStatement();
            String sqlStr = "SELECT * FROM patients WHERE id>1";;
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
