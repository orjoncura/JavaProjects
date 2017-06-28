package Lists;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.Date;

/**
 * Created by Orion on 6/23/2017.
 */
public class Customers
{

    private SimpleIntegerProperty ID;
    private SimpleStringProperty Name;
    private SimpleStringProperty Surname;
    private SimpleStringProperty DateOfBirth;

    public String getName() {
        return Name.get();
    }

    public void setName(String name) {
        this.Name.set(name);
    }

    public String getSurname() {
        return Surname.get();
    }

    public void setSurname(String surname) {
        this.Surname.set(surname);
    }

    public String getDateOfBirth() {
        return DateOfBirth.get();
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.DateOfBirth.set(dateOfBirth);
    }

    public Customers(int id,String Name, String Surname, String DateOfBirth)
    {
        this.Name = new SimpleStringProperty(Name);
        this.Surname = new SimpleStringProperty(Surname);
        this.DateOfBirth = new SimpleStringProperty(DateOfBirth);
        this.ID = new SimpleIntegerProperty(id);


    }

    public int getID() {
        return ID.get();
    }

    public SimpleIntegerProperty IDProperty() {
        return ID;
    }

    public void setID(int ID) {
        this.ID.set(ID);
    }

    @Override
    public String toString() {
        return "Customers{" +
                "ID=" + ID +
                ", Name=" + Name +
                ", Surname=" + Surname +
                ", DateOfBirth=" + DateOfBirth +
                '}';
    }
}
