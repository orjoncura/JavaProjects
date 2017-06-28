package Database;

import Lists.Contact;
import Lists.Customers;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static Database.DB.con;

public class DataSource2 {

    private final ObservableList<Customers> data =
            FXCollections.observableArrayList();
    private final ObservableList<Contact> dataContact =
            FXCollections.observableArrayList();
    public Statement statement= con.createStatement();
    public ResultSet rs = null;

    public ObservableList<Customers> getData() {
        return data;
    }

    public ObservableList<Contact> getDataContact() {
        return dataContact;
    }

    public DataSource2() throws SQLException {


        rs = statement.executeQuery("select * from customers");
        while (rs.next())
        {
            data.add(new Customers(rs.getInt("idCustomers"),rs.getString("Customer_Name"), rs.getString("Customer_Surname"), rs.getString("Customer_DOB")));
        }
        rs = statement.executeQuery("select * from  contact");
        while (rs.next())
        {
            if(rs.getString("CustomersID") != null) {
                dataContact.add(new Contact(rs.getString("Address"), rs.getString("Street"), rs.getString("Postcode"), rs.getString("Mobile")));
            }
        }
    }

}