package Database;

import Lists.Contact;
import Lists.Doctors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static Database.DB.con;

public class DataSource {

    private final ObservableList<Doctors> data =
            FXCollections.observableArrayList();
    private final ObservableList<Contact> dataContact =
            FXCollections.observableArrayList();
    public Statement statement= con.createStatement();
    public ResultSet rs = null;

    public ObservableList<Doctors> getData() {
        return data;
    }

    public ObservableList<Contact> getDataContact() {
        return dataContact;
    }

    public DataSource() throws SQLException {


        rs = statement.executeQuery("select * from  doctors");
        while (rs.next())
        {
            data.add(new Doctors(rs.getInt("idDoctors"),rs.getString("Name"), rs.getString("Surname"), rs.getString("DOB")));
        }
        rs = statement.executeQuery("select * from  contact");
        while (rs.next())
        {
            if(rs.getString("DoctorsID") != null) {
                dataContact.add(new Contact(rs.getString("Address"), rs.getString("Street"), rs.getString("Postcode"), rs.getString("Mobile")));
            }
        }
    }


}