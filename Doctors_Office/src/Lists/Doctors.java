package Lists;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Created by Orion on 6/23/2017.
 */
public class Doctors
{
    private final SimpleIntegerProperty ID;
    private final SimpleStringProperty Name;
    private final SimpleStringProperty Surname;
    private final SimpleStringProperty DOB;

    public Doctors(int id,String Name, String Surname, String DOB)
    {
        this.Name = new SimpleStringProperty(Name);
        this.Surname = new SimpleStringProperty(Surname);
        this.DOB = new SimpleStringProperty(DOB);
        this.ID = new SimpleIntegerProperty(id);
    }

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

    public String getDOB() {
        return DOB.get();
    }

    public void setDOB(String DOB) {
        this.DOB.set(DOB);
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
        return "Doctors{" +
                "ID=" + ID +
                ", Name=" + Name +
                ", Surname=" + Surname +
                ", DOB=" + DOB +
                '}';
    }
}
