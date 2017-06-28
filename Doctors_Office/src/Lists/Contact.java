package Lists;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created by Orion on 6/23/2017.
 */
public class Contact
{
    private final SimpleStringProperty Address;
    private final SimpleStringProperty Street;
    private final SimpleStringProperty Postcode;
    private final SimpleStringProperty Mobile;

    public Contact (String Address,String Street, String Postcode, String Mobile)
    {
        this.Address = new SimpleStringProperty(Address);
        this.Street = new SimpleStringProperty(Street);
        this.Postcode = new SimpleStringProperty(Postcode);
        this.Mobile = new SimpleStringProperty(Mobile);
    }

    public String getAddress() {
        return Address.get();
    }

    public void setAddress(String address) {
        this.Address.set(address);
    }

    public String getStreet() {
        return Street.get();
    }

    public void setStreet(String street) {
        this.Street.set(street);
    }

    public String getPostcode() {
        return Postcode.get();
    }

    public void setPostcode(String postcode) {
        this.Postcode.set(postcode);
    }

    public String getMobile() {
        return Mobile.get();
    }

    public void setMobile(String mobile) {
        this.Mobile.set(mobile);
    }
    @Override
    public String toString() {
        return "Contact{" +
                "Address='" + Address + '\'' +
                ", Street='" + Street + '\'' +
                ", Postcode='" + Postcode + '\'' +
                ", Mobile='" + Mobile + '\'' +
                '}';
    }
}
