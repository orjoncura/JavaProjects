package Main;

import Database.*;
import Lists.Contact;
import Lists.Customers;
import Lists.Doctors;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static Database.Add.*;
import static Database.DB.con;

public class Controller
{
    public java.sql.Statement statement = con.createStatement();
    public ResultSet rs;
    public MenuItem HomeNav;
    public MenuItem DoctorsNav;
    public MenuItem CustomersNav;
    public Pane homePane;
    public Pane DoctorsPane;
    public Pane CustomersPane;
    public TableView<Doctors> DocTable ;
    public TableColumn<Doctors, String> DocName;
    public TableColumn<Doctors, String> DocSurname ;
    public TableColumn<Doctors, String> DocDOB ;
    public TableColumn<Contact, String> DocAddress;
    public TableColumn<Contact, String> DocStreet;
    public TableColumn<Contact, String> DocPostcode;
    public TableColumn<Contact, String> DocMobile;
    public TableView<Contact> DocContactT;
    public TableView<Customers> CusTable;
    public TableColumn<Customers, String> CusName;
    public TableColumn<Customers, String> CusSurname;
    public TableColumn<Customers, String> CusDOB;
    public TableView<Contact> CusContactT;
    public TableColumn<Contact, String> CusAddress;
    public TableColumn<Contact, String> CusStreet;
    public TableColumn<Contact, String> CusPostcode;
    public TableColumn<Contact, String> CusMobile;
    public TextField NameText;
    public TextField SurnameText;
    public TextField DOBText;
    public TextField AddressText;
    public TextField StreetText;
    public TextField PostcodeText;
    public TextField MobileText;
    public Pane addPane;
    public Button Submit;
    public Label msg;
    public Button addBtn2;
    public Button deleteBtn2;
    public TableColumn<Customers, Integer>  CusID;
    public TableColumn<Doctors, Integer>  DocID;
    public String Turn;
    public    TextField IDTextField;
    public   Label msg2;
    public TextField IDTextField2;
    public Button EditBtn2;
    public Label msg3;


    public Controller() throws SQLException {
    }

    public void DoctorsNav(ActionEvent actionEvent) throws SQLException {
        msg2.setText("");
        homePane.setVisible(false);
        DoctorsPane.setVisible(true);
        CustomersPane.setVisible(false);
        addPane.setVisible(false);


        PropertyValueFactory<Doctors, Integer> IDProperty =
                new PropertyValueFactory<Doctors, Integer>("ID");
        PropertyValueFactory<Doctors, String> firstNameProperty =
                new PropertyValueFactory<Doctors, String>("Name");
        PropertyValueFactory<Doctors, String> SurnameProperty =
               new PropertyValueFactory<Doctors, String>("Surname");
        PropertyValueFactory<Doctors, String> DOBProperty =
                new PropertyValueFactory<Doctors, String>("DOB");
        PropertyValueFactory<Contact, String> AddressProperty =
                new PropertyValueFactory<Contact, String>("Address");
        PropertyValueFactory<Contact, String> StreetProperty =
                new PropertyValueFactory<Contact, String>("Street");
        PropertyValueFactory<Contact, String> PostcodeProperty =
                new PropertyValueFactory<Contact, String>("Postcode");
        PropertyValueFactory<Contact, String> MobileProperty =
                new PropertyValueFactory<Contact, String>("Mobile");


        DocID.setCellValueFactory( IDProperty );
        DocName.setCellValueFactory( firstNameProperty );
        DocSurname.setCellValueFactory( SurnameProperty );
        DocDOB.setCellValueFactory( DOBProperty );
        DocAddress.setCellValueFactory( AddressProperty );
        DocStreet.setCellValueFactory( StreetProperty );
        DocPostcode.setCellValueFactory( PostcodeProperty );
        DocMobile.setCellValueFactory( MobileProperty );

        DataSource data = new DataSource();
        ObservableList<Doctors> tableItems = data.getData();
        ObservableList<Contact> tableItems2 = data.getDataContact();
        DocTable.setItems( tableItems );
        DocContactT.setItems( tableItems2 );
    }

    public void CustomersNav(ActionEvent actionEvent) throws SQLException {
        msg3.setText("");
        homePane.setVisible(false);
        DoctorsPane.setVisible(false);
        CustomersPane.setVisible(true);
        addPane.setVisible(false);

        PropertyValueFactory<Customers, Integer> IDProperty =
                new PropertyValueFactory<Customers, Integer>("ID");
        PropertyValueFactory<Customers, String> firstNameProperty =
                new PropertyValueFactory<Customers, String>("Name");
        PropertyValueFactory<Customers, String> SurnameProperty =
                new PropertyValueFactory<Customers, String>("Surname");
        PropertyValueFactory<Customers, String> DOBProperty =
                new PropertyValueFactory<Customers, String>("DateOfBirth");
        PropertyValueFactory<Contact, String> AddressProperty =
                new PropertyValueFactory<Contact, String>("Address");
        PropertyValueFactory<Contact, String> StreetProperty =
                new PropertyValueFactory<Contact, String>("Street");
        PropertyValueFactory<Contact, String> PostcodeProperty =
                new PropertyValueFactory<Contact, String>("Postcode");
        PropertyValueFactory<Contact, String> MobileProperty =
                new PropertyValueFactory<Contact, String>("Mobile");

        CusID.setCellValueFactory( IDProperty );
        CusName.setCellValueFactory( firstNameProperty );
        CusSurname.setCellValueFactory( SurnameProperty );
        CusDOB.setCellValueFactory( DOBProperty );
        CusAddress.setCellValueFactory( AddressProperty );
        CusStreet.setCellValueFactory( StreetProperty );
        CusPostcode.setCellValueFactory( PostcodeProperty );
        CusMobile.setCellValueFactory( MobileProperty );

        DataSource2 data = new DataSource2();
        ObservableList<Customers> tableItems = data.getData();
        ObservableList<Contact> tableItems2 = data.getDataContact();
        CusTable.setItems( tableItems );
        CusContactT.setItems( tableItems2 );
    }

    public void HomeNav(ActionEvent actionEvent)
    {
        homePane.setVisible(true);
        DoctorsPane.setVisible(false);
        CustomersPane.setVisible(false);
        addPane.setVisible(false);
    }

    public void addBtn(ActionEvent actionEvent) {
        homePane.setVisible(false);
        DoctorsPane.setVisible(false);
        CustomersPane.setVisible(false);
        addPane.setVisible(true);
        Turn = "Doc";

        NameText.setText("");
        SurnameText.setText("");
        DOBText.setText("");
        AddressText.setText("");
        StreetText.setText("");
        PostcodeText.setText("");
        MobileText.setText("");

    }

    public void Submit(ActionEvent actionEvent) throws SQLException {
        msg.setText("");
        if (
                (NameText.getText().toString().equals(null)) ||
                        (SurnameText.getText().toString().equals("")) ||
                        (DOBText.getText().toString().equals("")) ||
                        (AddressText.getText().toString().equals("")) ||
                        (StreetText.getText().toString().equals("")) ||
                        (PostcodeText.getText().toString().equals("")) ||
                        (MobileText.getText().toString().equals("") )
                )
        {
            msg.setText("Please Fill All The TextFields");
        }
        else
        {
            if ( Turn == "Doc")
            {
                addDoctor(new Doctors(1,NameText.getText(),SurnameText.getText(),DOBText.getText()));
                addContact(new Contact(AddressText.getText(),StreetText.getText(),PostcodeText.getText(),MobileText.getText()));

            }else if(Turn == "Cus")
            {
                addCustomers(new Customers(1,NameText.getText(),SurnameText.getText(),DOBText.getText())) ;
                addContact2(new Contact(AddressText.getText(),StreetText.getText(),PostcodeText.getText(),MobileText.getText()));
            }else if(Turn == "DocE")
            {
                rs = statement.executeQuery("select * from   doctors");
                int id = Integer.parseInt(IDTextField.getText());
                while(rs.next()) {
                    if (id == rs.getInt("idDoctors")) {
                        try {
                            PreparedStatement stat;
                            stat = null;
                            stat = con.prepareStatement("UPDATE `doctors_office`.`doctors` SET Name=?, Surname=?,DOB=?" +
                                    " WHERE idDoctors=" + id);


                            stat.setString(1, NameText.getText());
                            stat.setString(2, SurnameText.getText());
                            stat.setString(3, DOBText.getText());

                            stat.executeUpdate();

                            rs = statement.executeQuery("select * from  contact");
                            while (rs.next()) {
                                if (rs.getInt("DoctorsID") == id) {

                                    stat = con.prepareStatement("UPDATE `doctors_office`.`contact` SET Address=?, Street=?, Postcode=?, Mobile=? " +
                                            "WHERE DoctorsID=" + id);

                                    stat.setString(1, AddressText.getText());
                                    stat.setString(2, StreetText.getText());
                                    stat.setString(3, PostcodeText.getText());
                                    stat.setString(4, MobileText.getText());

                                    stat.executeUpdate();
                                    stat.close();

                                }

                            }

                        } catch (Exception e) {
                            System.out.print(e.getMessage());
                            e.printStackTrace();
                        }

                    }
                }
            }else if(Turn == "CusE")
            {
                rs = statement.executeQuery("select * from   customers");
                int id = Integer.parseInt(IDTextField2.getText());
                while(rs.next()) {
                    if (id == rs.getInt("idCustomers")) {
                        try {
                            PreparedStatement stat;
                            stat = null;
                            stat = con.prepareStatement("UPDATE `doctors_office`.`customers` SET Customer_Name=?, Customer_Surname=?, Customer_DOB=?" +
                                    " WHERE idCustomers=" + id);


                            stat.setString(1, NameText.getText());
                            stat.setString(2, SurnameText.getText());
                            stat.setString(3, DOBText.getText());

                            stat.executeUpdate();

                            rs = statement.executeQuery("select * from  contact");
                            while (rs.next()) {
                                if (rs.getInt("CustomersID") == id) {

                                    stat = con.prepareStatement("UPDATE `doctors_office`.`contact` SET Address=?, Street=?, Postcode=?, Mobile=? " +
                                            "WHERE CustomersID=" + id);

                                    stat.setString(1, AddressText.getText());
                                    stat.setString(2, StreetText.getText());
                                    stat.setString(3, PostcodeText.getText());
                                    stat.setString(4, MobileText.getText());

                                    stat.executeUpdate();
                                    stat.close();

                                }

                            }

                        } catch (Exception e) {
                            System.out.print(e.getMessage());
                            e.printStackTrace();
                        }

                    }
                }
            }

            homePane.setVisible(true);
            DoctorsPane.setVisible(false);
            CustomersPane.setVisible(false);
            addPane.setVisible(false);
        }

    }

    public void addBtn2(ActionEvent actionEvent)
    {
        homePane.setVisible(false);
        DoctorsPane.setVisible(false);
        CustomersPane.setVisible(false);
        addPane.setVisible(true);
        Turn = "Cus";

        NameText.setText("");
        SurnameText.setText("");
        DOBText.setText("");
        AddressText.setText("");
        StreetText.setText("");
        PostcodeText.setText("");
        MobileText.setText("");
    }

    public void deleteBtn(ActionEvent actionEvent) throws SQLException {

        if(IDTextField.getText().equals(""))
        {
            msg2.setText(" Please Enter A Valid Id");
        }
        else
        {
            rs = statement.executeQuery("select * from contact");
            int id = Integer.parseInt(IDTextField.getText());
            while (rs.next())
            {
                    if(rs.getInt("DoctorsID") == id)
                    {
                        PreparedStatement statement = con.prepareStatement("DELETE FROM `doctors_office`.`contact` WHERE `DoctorsID`='" + id + "';");
                        statement.executeUpdate();
                        statement.close();
                        msg2.setText("");
                    }
                    else
                        msg2.setText("Wrong Id");

            }

            rs = statement.executeQuery("select * from  doctors");
            while (rs.next())
            {
                if (rs.getInt("idDoctors") == id)
                {
                    PreparedStatement statement = con.prepareStatement("DELETE FROM `doctors_office`.`doctors` WHERE `idDoctors`='" + id + "';");
                    statement.executeUpdate();
                    statement.close();

                    homePane.setVisible(true);
                    DoctorsPane.setVisible(false);
                    CustomersPane.setVisible(false);
                    addPane.setVisible(false);
                }
            }
        }
    }

    public void deleteBtn2(ActionEvent actionEvent) throws SQLException {

        if(IDTextField2.getText().equals(""))
        {
            msg3.setText(" Please Enter A Valid Id");
        }
        else
        {
            rs = statement.executeQuery("select * from contact");
            int id = Integer.parseInt(IDTextField2.getText());
            while (rs.next())
            {
                if(rs.getInt("CustomersID") == id)
                {;
                    PreparedStatement statement = con.prepareStatement("DELETE FROM `doctors_office`.`contact` WHERE `CustomersID`='" + id + "';");
                    statement.executeUpdate();
                    statement.close();
                    msg2.setText("");
                }
                else
                    msg2.setText("Wrong Id");

            }

            rs = statement.executeQuery("select * from  customers");
            while (rs.next())
            {
                if (rs.getInt("idCustomers") == id)
                {
                    PreparedStatement statement = con.prepareStatement("DELETE FROM `doctors_office`.`customers` WHERE `idCustomers`='"+ id +"';");
                    statement.executeUpdate();
                    statement.close();

                    homePane.setVisible(true);
                    DoctorsPane.setVisible(false);
                    CustomersPane.setVisible(false);
                    addPane.setVisible(false);
                }
            }
        }
    }

    public void editBtn(ActionEvent actionEvent) throws SQLException {
        msg2.setText("");
        rs = statement.executeQuery("select * from  doctors");
        if(IDTextField.getText().equals(""))
            msg2.setText("Please Enter A Valid Id");
        else
        {
            int id = Integer.parseInt(IDTextField.getText());
            while (rs.next())
            {
                if(rs.getInt("idDoctors") == id)
                {
                    Turn = "DocE";
                    homePane.setVisible(false);
                    DoctorsPane.setVisible(false);
                    CustomersPane.setVisible(false);
                    addPane.setVisible(true);

                    NameText.setText(rs.getString("Name"));
                    SurnameText.setText(rs.getString("Surname"));
                    DOBText.setText(rs.getString("DOB"));
                    break;

                }
                else
                    msg2.setText("Wrong Id");
            }
            rs = statement.executeQuery("select * from  contact");
            while (rs.next())
            {
                if(rs.getInt("DoctorsID") == id)
                {

                    AddressText.setText(rs.getString("Address"));
                    StreetText.setText(rs.getString("Street"));
                    PostcodeText.setText(rs.getString("Postcode"));
                    MobileText.setText(rs.getString("Mobile"));

                    break;

                }
                else
                    msg2.setText("Wrong Id");
            }

        }
    }

    public void EditBtn2(ActionEvent actionEvent) throws SQLException {
        msg3.setText("");
        rs = statement.executeQuery("select * from  customers");
        if(IDTextField2.getText().equals(""))
            msg3.setText("Please Enter A Valid Id");
        else
        {
            int id = Integer.parseInt(IDTextField2.getText());
            while (rs.next())
            {
                if(rs.getInt("idCustomers") == id)
                {
                    Turn = "CusE";
                    homePane.setVisible(false);
                    DoctorsPane.setVisible(false);
                    CustomersPane.setVisible(false);
                    addPane.setVisible(true);

                    NameText.setText(rs.getString("Customer_Name"));
                    SurnameText.setText(rs.getString("Customer_Surname"));
                    DOBText.setText(rs.getString("Customer_DOB"));
                    break;

                }
                else
                    msg3.setText("Wrong Id");
            }
            rs = statement.executeQuery("select * from  contact");
            while (rs.next())
            {
                if(rs.getInt("CustomersID") == id)
                {

                    AddressText.setText(rs.getString("Address"));
                    StreetText.setText(rs.getString("Street"));
                    PostcodeText.setText(rs.getString("Postcode"));
                    MobileText.setText(rs.getString("Mobile"));

                    break;

                }
                else
                    msg3.setText("Wrong Id");
            }

        }
    }
}
