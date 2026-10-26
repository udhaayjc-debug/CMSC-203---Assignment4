/*
 * Class: CMSC203 
 * Instructor: Huseyin Aygun
 * Description: Property class used to store information about one rental property.
 * Due: 10/25/2026
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student.
 * Print your Name here: Udhaay Jayachandran
 */

public class Property {
    private String propertyName;
    private String city;
    private double rentAmount;
    private String owner;

    /** Creates an empty Property object. */
    public Property() {
        propertyName = "";
        city = "";
        rentAmount = 0.0;
        owner = "";
    }

    /** Creates a Property using the supplied values. */
    public Property(String propertyName, String city, double rentAmount, String owner) {
        this.propertyName = propertyName;
        this.city = city;
        this.rentAmount = rentAmount;
        this.owner = owner;
    }

    /** Creates a separate copy of another Property object. */
    public Property(Property property) {
        this.propertyName = property.propertyName;
        this.city = property.city;
        this.rentAmount = property.rentAmount;
        this.owner = property.owner;
    }

    /** Returns the property name. */
    public String getPropertyName() {
        return propertyName;
    }

    /** Updates the property name. */
    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    /** Returns the city. */
    public String getCity() {
        return city;
    }

    /** Updates the city. */
    public void setCity(String city) {
        this.city = city;
    }

    /** Returns the monthly rent amount. */
    public double getRentAmount() {
        return rentAmount;
    }

    /** Updates the monthly rent amount. */
    public void setRentAmount(double rentAmount) {
        this.rentAmount = rentAmount;
    }

    /** Returns the owner name. */
    public String getOwner() {
        return owner;
    }

    /** Updates the owner name. */
    public void setOwner(String owner) {
        this.owner = owner;
    }

    /** Returns the property information in the required display format. */
    @Override
    public String toString() {
        return String.format("%s, %s, Rent: $%.2f, Owner: %s",
                propertyName, city, rentAmount, owner);
    }
}
