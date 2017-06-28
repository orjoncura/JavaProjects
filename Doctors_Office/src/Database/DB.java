package Database;

import Lists.Doctors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Orion on 6/23/2017.
 */

public class DB
{
    public static Connection con = null;
    public static ResultSet rs = null;
    public static java.sql.Statement statement = null;
    public static ObservableList<Doctors> DoctorsList = FXCollections.observableArrayList();
    public static ResultSet rs2;

    public DB() throws SQLException {
        try {
            con = ConnectDB.ConnectDB();
            if (con != null)
                System.out.println("Succes");
            else
                System.out.println("UnSuccesfull");

          java.sql.Statement statement = con.createStatement();
            rs = statement.executeQuery("use doctors_office");
        } catch (Exception e) {

            e.printStackTrace();
            System.out.println(e.getMessage());
        } finally {
            if (statement != null)
                try {
                    statement.close();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
        }
    }

}
