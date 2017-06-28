package sample;

import database.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static sample.Main.*;

public class Controller{
    public javafx.scene.control.Label  nameL;
    public Label surnameL;
    public Label emailL;
    public Label homePhoneL;
    public Label phoneL;
    public Label cobL;
    public Label dobL;
    public Label cityL;
    public Label countryL;
    public Label postcodeL;
    public Label accountBalanceL;
    public Label StreetL;
    public  javafx.scene.control.TextField nameTxt;
    public  javafx.scene.control.TextField surname;
    public  javafx.scene.control.TextField dob;
    public  javafx.scene.control.TextField cob;
    public  javafx.scene.control.TextField mobile;
    public  javafx.scene.control.TextField homeP;
    public  javafx.scene.control.TextField email;
    public  javafx.scene.control.TextField country;
    public  javafx.scene.control.TextField city;
    public  javafx.scene.control.TextField postcode;
    public  javafx.scene.control.TextField street;
    public  javafx.scene.control.TextField accountBalance;
    public   javafx.scene.control.TextField searchTxt;
    public ObservableList<String> searchByList
            = FXCollections.observableArrayList("Name", "Surname");
    public ComboBox<String> searchBy;
    public Label message;
    public Pane sample;
    public  GridPane  display;
    public Pane paneList;
    @FXML
    public TextArea textArea1;
    @FXML
    public TextArea textArea2;
    @FXML
    public TextArea textArea3;
    @FXML
    public TextArea textArea4;
    @FXML
    public TextArea textArea5;
    @FXML
    public TextArea textArea;
    @FXML
    public MenuBar menuBar;
    @FXML
    public  ResultSet rs = null;
    @FXML
    public java.sql.Statement statement = con.createStatement();
    @FXML
    public TextField text_id;
    @FXML
    public TabPane tabPane;
    @FXML
    public Button edibtn;
    @FXML
    public Button submitbtn;

    public Controller() throws SQLException {
    }

    public void search(MouseEvent mouseEvent)
    {
        searchBy.setItems(searchByList);
    }

    public void submit(ActionEvent actionEvent) throws IOException, SQLException
    {

        if (searchBy.getSelectionModel().isEmpty())
            searchBy.setValue("Name");

        if (searchBy.getSelectionModel().getSelectedItem().equals("Name")) {
            ResultSet rs = null;
            java.sql.Statement statement = con.createStatement();
            rs = statement.executeQuery("Select * From  client");
            rs.last();
            if (rs.getRow() > 0)
            {
                rs.beforeFirst();
                while (rs.next())
                    if (rs.getString("Name").toUpperCase().equals(searchTxt.getText().toUpperCase()))
                    {
                        nameL.setText(rs.getString("Name"));
                        surnameL.setText(rs.getString("Surname"));
                        emailL.setText(rs.getString("Email"));
                        phoneL.setText(rs.getString("Phone"));
                        homePhoneL.setText(rs.getString("HomePhone"));
                        cobL.setText(rs.getString("CountryOfBirth"));
                        dobL.setText(rs.getString("DateOfBirth"));
                        countryL.setText(rs.getString("Country"));
                        cityL.setText(rs.getString("City"));
                        postcodeL.setText(rs.getString("Postcode"));
                        StreetL.setText(rs.getString("Street"));
                        accountBalanceL.setText(rs.getString("AccountBalance"));

                        sample.setVisible(false);
                        display.setVisible(true);
                        message.setText("");
                        break;
                    }
                    else
                        message.setText("There Is No Customer With That Name");
            } else
                message.setText("There Is No Data");
        }
         else
             {
        ResultSet rs = null;
        java.sql.Statement statement = con.createStatement();
        rs = statement.executeQuery("Select * From  client");
        rs.last();
        if (rs.getRow() > 0)
        {
            rs.beforeFirst();
            while (rs.next())
                if (rs.getString("Surname").toUpperCase().equals(searchTxt.getText().toUpperCase()))
                {
                    nameL.setText(rs.getString("Name"));
                    surnameL.setText(rs.getString("Surname"));
                    emailL.setText(rs.getString("Email"));
                    phoneL.setText(rs.getString("Phone"));
                    homePhoneL.setText(rs.getString("HomePhone"));
                    cobL.setText(rs.getString("CountryOfBirth"));
                    dobL.setText(rs.getString("DateOfBirth"));
                    countryL.setText(rs.getString("Country"));
                    cityL.setText(rs.getString("City"));
                    postcodeL.setText(rs.getString("Postcode"));
                    StreetL.setText(rs.getString("Street"));
                    accountBalanceL.setText(rs.getString("AccountBalance"));

                    sample.setVisible(false);
                    display.setVisible(true);
                }
                else
                    message.setText("There Is No Customer With That Name");
        }
        else
            message.setText("There Is No Data");
            }
    }

    public void register(ActionEvent actionEvent) throws IOException
    {
        submitbtn.setVisible(true);
        edibtn.setVisible(false);
        message.setText("");

        tabPane.setVisible(true);
        sample.setVisible(false);

        nameTxt.setText("");
        surname.setText("");
        dob.setText("");
        cob.setText("");
        mobile.setText("");
        homeP.setText("");
        email.setText("");
        country.setText("");
        city.setText("");
        postcode.setText("");
        street.setText("");
        accountBalance.setText("");
    }

    public void submitRegister(ActionEvent actionEvent) throws SQLException {
            if (
                 (nameTxt.getText().toString().equals(null)) ||
                (surname.getText().toString().equals("")) ||
                (dob.getText().toString().equals("")) ||
                (cob.getText().toString().equals("")) ||
                (mobile.getText().toString().equals("")) ||
                (homeP.getText().toString().equals("")) ||
                (email.getText().toString().equals("")) ||
                (country.getText().toString().equals("")) ||
                (city.getText().toString().equals("")) ||
                (postcode.getText().toString().equals("")) ||
                (street.getText().toString().equals("")) ||
                (accountBalance.getText().toString().equals(""))
                  )
                message.setText("Please Fill All The TextFields");
            else
             {
                 addClient(new Client(nameTxt.getText(), surname.getText(), dob.getText(), cob.getText(), mobile.getText(),
                        homeP.getText(), email.getText(), country.getText(), city.getText(), postcode.getText(), street.getText(),
                        accountBalance.getText()));
                 message.setText("The Registration Is Completed");
            }
    }

    public void ShowAll(ActionEvent actionEvent) throws SQLException
    {
        textArea.setText("");
        textArea1.setText("");
        textArea2.setText("");
        textArea3.setText("");
        textArea4.setText("");
        textArea5.setText("");

        rs = statement.executeQuery("Select * From  client");
        String newLine = System.getProperty("line.separator");
            while (rs.next())
            {
                textArea.setText(textArea.getText() + rs.getString("idClient")  + newLine );
                textArea1.setText(textArea1.getText() + rs.getString("Name") + newLine );
                textArea2.setText(textArea2.getText() + rs.getString("Surname") + newLine );
                textArea3.setText(textArea3.getText() + rs.getString("DateOfBirth") + newLine );
                textArea4.setText(textArea4.getText() + rs.getString("CountryOfBirth") + newLine );
                textArea5.setText(textArea5.getText() + rs.getString("Phone") + newLine );
            }
            paneList.setVisible(true);
    }

    public void home(ActionEvent actionEvent)
    {
        sample.setVisible(true);
        paneList.setVisible(false);
        display.setVisible(false);
        tabPane.setVisible(false);
        message.setText("");
    }

    public void delete(ActionEvent actionEvent) throws SQLException {
        rs = statement.executeQuery("Select * From  client");
        if(text_id.getText().equals(""))
            message.setText("          Please Enter A Valid Id");
            else
                {
                    int id = Integer.parseInt(text_id.getText());
                    while (rs.next())
                    {
                        System.out.println(text_id.getText());
                        if(rs.getInt("idClient") == id)
                        {
                            PreparedStatement statement = con.prepareStatement("DELETE FROM `bank_management`.`client` WHERE `idClient`='" + id + "';");

                            statement.executeUpdate();
                            statement.close();
                            message.setText("");
                        }
                        else
                            message.setText("         Wrong Id");
                    }

                }

    }

    public void edit(ActionEvent actionEvent) throws SQLException {
        rs = statement.executeQuery("Select * From  client");
        if(text_id.getText().equals(""))
            message.setText("          Please Enter A Valid Id");
        else
        {
            int id = Integer.parseInt(text_id.getText());
            while (rs.next())
            {
                System.out.println(text_id.getText());
                if(rs.getInt("idClient") == id)
                {
                    tabPane.setVisible(true);
                    sample.setVisible(false);
                    paneList.setVisible(false);
                    display.setVisible(false);
                    message.setText("");

                    nameTxt.setText(rs.getString("Name"));
                    surname.setText(rs.getString("Surname"));
                    email.setText(rs.getString("Email"));
                    mobile.setText(rs.getString("Phone"));
                    homeP.setText(rs.getString("HomePhone"));
                    cob.setText(rs.getString("CountryOfBirth"));
                    dob.setText(rs.getString("DateOfBirth"));
                    country.setText(rs.getString("Country"));
                    city.setText(rs.getString("City"));
                    postcode.setText(rs.getString("Postcode"));
                    street.setText(rs.getString("Street"));
                    accountBalance.setText(rs.getString("AccountBalance"));

                    submitbtn.setVisible(false);
                    edibtn.setVisible(true);
                    message.setText("");
                    break;

                }
                else
                    message.setText("         Wrong Id");
            }

        }
    }

    public void submitEdit(ActionEvent actionEvent) throws SQLException {
        try {
        PreparedStatement stat = con.prepareStatement("UPDATE `bank_management`.`client` SET" +
                " Name=?,Surname=?,DateOfBirth=?,CountryOfBirth=?,Phone=?,HomePhone=?,Email=?," +
                "Country=?,City=?,Postcode=?,Street=?,AccountBalance=?"
                + " WHERE idClient=" + rs.getInt("idClient"));

        stat.setString(1, nameTxt.getText());
        stat.setString(2,  surname.getText());
        stat.setString(3, dob.getText());
        stat.setString(4, cob.getText());
        stat.setString(5, mobile.getText());
        stat.setString(6, homeP.getText());
        stat.setString(7, email.getText());
        stat.setString(8, country.getText());
        stat.setString(9,city.getText());
        stat.setString(10,postcode.getText());
        stat.setString(11,street.getText());
        stat.setString(12,accountBalance.getText());

        stat.executeUpdate();
        stat.close();
        message.setText("Editing Is Completed");
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}




