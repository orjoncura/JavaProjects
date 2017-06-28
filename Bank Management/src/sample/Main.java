package sample;

import database.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Main extends Application
{
    public static Stage stage;
    public static   Connection con = null;
    public static   ResultSet rs = null;
    public static java.sql.Statement statement = null;

    @Override
    public void start(Stage primaryStage) throws Exception {

        try {
            con = ConnectDB.ConnectDB();
            if (con != null)
                System.out.println("Succes");
            else
                System.out.println("UnSuccesfull");
            java.sql.Statement statement = con.createStatement();
            rs =  statement.executeQuery("use bank_management");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        } finally {
            if (statement != null)
                statement.close();
        }

        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Bank Management");
        primaryStage.setScene(new Scene(root, 500, 400));
        primaryStage.maximizedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue)
                primaryStage.setMaximized(false);
        });
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }

    public static void addClient(Client temp) throws SQLException {
        PreparedStatement stat = null;
        try {
            stat = con.prepareStatement("INSERT INTO `bank_management`.`client` (`Name`, `Surname`, `DateOfBirth`, `CountryOfBirth`, `Phone`, `HomePhone`, `Email`, `Country`, `City`, `Postcode`, `Street`, `AccountBalance`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?);");

            stat.setString(1, temp.getName());
            stat.setString(2, temp.getSurname());
            stat.setString(3, temp.getDateOfBirth());
            stat.setString(4, temp.getCountryOfBirth());
            stat.setString(5, temp.getPhone());
            stat.setString(6, temp.getHomePhone());
            stat.setString(7, temp.getEmail());
            stat.setString(8, temp.getCountry());
            stat.setString(9, temp.getCity());
            stat.setString(10, temp.getPostcode());
            stat.setString(11, temp.getStreet());
            stat.setString(12, temp.getAccountBalance());
            stat.executeUpdate();
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
        finally
        {
            stat.close();
            rs.close();

        }
    }


}