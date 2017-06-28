package database;

/**
 * Created by Orion on 3/10/2017.
 */
public class Client
{
    private String Name;
    private String Surname;
    private String DateOfBirth;
    private String CountryOfBirth;
    private String Phone;
    private String HomePhone;
    private String Email;
    private String Country;
    private String City;
    private String Postcode;
    private String Street;
    private String AccountBalance;

    public Client(String Name,String Surname,String DateOfBirth,String CountryOfBirth,String Phone,
                  String HomePhone,String Email,String Country,String City,String Postcode,String Street,String AccountBalance)
    {

        this.Name = Name;
        this.Surname = Surname;
        this.DateOfBirth = DateOfBirth;
        this.CountryOfBirth = CountryOfBirth;
        this.Phone = Phone;
        this.HomePhone = HomePhone;
        this.Email = Email;
        this.Country = Country;
        this.City = City;
        this.Postcode = Postcode;
        this.Street =  Street;
        this.AccountBalance = AccountBalance;

    }
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    public String getSurname() {
        return Surname;
    }
    public void setSurname(String surname) {
        Surname = surname;
    }
    public String getDateOfBirth() {
        return DateOfBirth;
    }
    public void setDateOfBirth(String dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }
    public String getCountryOfBirth() {
        return CountryOfBirth;
    }
    public void setCountryOfBirth(String countryOfBirth) {
        CountryOfBirth = countryOfBirth;
    }
    public String getPhone() {
        return Phone;
    }
    public void setPhone(String phone) {
        Phone = phone;
    }
    public String getHomePhone() {
        return HomePhone;
    }
    public void setHomePhone(String homePhone) {
        HomePhone = homePhone;
    }
    public String getEmail() {
        return Email;
    }
    public void setEmail(String email) {
        Email = email;
    }
    public String getCountry() {
        return Country;
    }
    public void setCountry(String country) {
        Country = country;
    }
    public String getCity() {
        return City;
    }
    public void setCity(String city) {
        City = city;
    }
    public String getPostcode() {
        return Postcode;
    }
    public void setPostcode(String postcode) {
        Postcode = postcode;
    }
    public String getStreet() {
        return Street;
    }
    public void setStreet(String street) {
        Street = street;
    }
    public String getAccountBalance() {
        return AccountBalance;
    }
    public void setAccountBalance(String accountBalance) {
        AccountBalance = accountBalance;
    }

    @Override
    public String toString() {
        return "Client{" +
                "Name='" + Name + '\'' +
                ", Surname='" + Surname + '\'' +
                ", DateOfBirth='" + DateOfBirth + '\'' +
                ", CountryOfBirth='" + CountryOfBirth + '\'' +
                ", Phone='" + Phone + '\'' +
                ", HomePhone='" + HomePhone + '\'' +
                ", Email='" + Email + '\'' +
                ", Country='" + Country + '\'' +
                ", City='" + City + '\'' +
                ", Postcode='" + Postcode + '\'' +
                ", Street='" + Street + '\'' +
                ", AccountBalance='" + AccountBalance + '\'' +
                '}';
    }
}
