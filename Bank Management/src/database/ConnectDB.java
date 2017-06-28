package database;
import java.sql.*;

/**
 * Created by student on 15-Dec-16.
 */
public class ConnectDB
{
    public static  Connection ConnectDB() throws Exception {
        Connection con = null;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_management?UseSSL=false","root","03280530");
            if(con != null)
                System.out.println("SuccesFully");
            else
                System.out.println("UnSuccesfully");
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return con;
    }

}
