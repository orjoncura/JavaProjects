package Database;

import Lists.Contact;
import Lists.Customers;
import Lists.Doctors;

import java.sql.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static Database.DB.con;

/**
 * Created by Orion on 6/27/2017.
 */
public class Add
{

    public static Statement  statement;

    static {
        try {
            statement = DB.con.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Integer ID;

    public Add() throws SQLException {
    }


    public static void addDoctor(Doctors temp) throws SQLException {
        PreparedStatement stat = null;
        stat = con.prepareStatement("INSERT INTO `doctors_office`.`doctors` (`Name`, `Surname`, `DOB`) VALUES (?,?,?);");
        stat.setString(1, temp.getName());
        stat.setString(2, temp.getSurname());
        stat.setString(3, temp.getDOB());
        stat.executeUpdate();
        ResultSet rs = statement.executeQuery("select * from  doctors");

        try{
            rs.last();
            ID = rs.getInt("idDoctors");
            System.out.print(ID);
        }catch (Exception e)
        {
            System.out.print(e.getMessage());
        }
    }
    public static void addContact(Contact temp) throws SQLException {
        PreparedStatement stat = null;
        stat = con.prepareStatement("INSERT INTO `doctors_office`.`contact` (`Address`, `Street`, `Postcode`, `Mobile` , `DoctorsID`) VALUES (?,?,?,?,?);");
        stat.setString(1, temp.getAddress());
        stat.setString(2, temp.getStreet());
        stat.setString(3, temp.getPostcode());
        stat.setString(4, temp.getMobile());
        stat.setInt(5,  ID);
        stat.executeUpdate();
    }

    public static void addCustomers(Customers temp) throws SQLException {
        PreparedStatement stat = null;
        stat = con.prepareStatement("INSERT INTO `doctors_office`.`customers` (`Customer_Name`, `Customer_Surname`, `Customer_DOB`) VALUES (?,?,?);");
        stat.setString(1, temp.getName());
        stat.setString(2, temp.getSurname());
        stat.setString(3, temp.getDateOfBirth());
        stat.executeUpdate();
        ResultSet rs = statement.executeQuery("select * from  customers");

        try{
            rs.last();
            ID = rs.getInt("idCustomers");
            System.out.print(ID);
        }catch (Exception e)
        {
            System.out.print(e.getMessage());
        }
    }
    public static void addContact2(Contact temp) throws SQLException {
        PreparedStatement stat = null;
        stat = con.prepareStatement("INSERT INTO `doctors_office`.`contact` (`Address`, `Street`, `Postcode`, `Mobile` , `CustomersID`) VALUES (?,?,?,?,?);");
        stat.setString(1, temp.getAddress());
        stat.setString(2, temp.getStreet());
        stat.setString(3, temp.getPostcode());
        stat.setString(4, temp.getMobile());
        stat.setInt(5,  ID);
        stat.executeUpdate();
    }


}
