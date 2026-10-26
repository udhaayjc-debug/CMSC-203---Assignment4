/*
 * Class: CMSC203 
 * Instructor: Huseyin Aygun
 * Description: ManagementCompany class that stores and manages Property objects.
 * Due: 10/25/2026
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student.
 * Print your Name here: Udhaay Jayachandran
 */

public class ManagementCompany {
    public static final int MAX_PROPERTIES = 3;

    private String name;
    private String taxId;
    private Property[] properties;
    private int propertyCount;

    /** Creates a company with an empty Property array. */
    public ManagementCompany(String name, String taxId) {
        this.name = name;
        this.taxId = taxId;
        properties = new Property[MAX_PROPERTIES];
        propertyCount = 0;
    }

    /** Creates a deep copy of another ManagementCompany. */
    public ManagementCompany(ManagementCompany other) {
        this.name = other.name;
        this.taxId = other.taxId;
        this.properties = new Property[MAX_PROPERTIES];
        this.propertyCount = other.propertyCount;

        for (int i = 0; i < other.propertyCount; i++) {
            this.properties[i] = new Property(other.properties[i]);
        }
    }

    /** Adds a copy of a Property and returns its index, or -1 if full. */
    public int addProperty(Property p) {
        if (p == null || propertyCount >= MAX_PROPERTIES) {
            return -1;
        }

        properties[propertyCount] = new Property(p);
        int index = propertyCount;
        propertyCount++;
        return index;
    }

    /** Calculates and returns the total monthly rent. */
    public double totalRent() {
        double total = 0.0;

        for (int i = 0; i < propertyCount; i++) {
            total += properties[i].getRentAmount();
        }

        return total;
    }

    /** Returns the number of stored properties. */
    public int getPropertyCount() {
        return propertyCount;
    }

    /** Returns the company name. */
    public String getName() {
        return name;
    }

    /** Updates the company name. */
    public void setName(String name) {
        this.name = name;
    }

    /** Returns the company tax ID. */
    public String getTaxId() {
        return taxId;
    }

    /** Updates the company tax ID. */
    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    /** Returns a Property at a valid index, or null if invalid. */
    public Property getProperty(int index) {
        if (index < 0 || index >= propertyCount) {
            return null;
        }
        return properties[index];
    }

    /** Returns a formatted summary of the company and properties. */
    @Override
    public String toString() {
        String result = "Management Company: " + name
                + " (Tax ID: " + taxId + ")\n";
        result += "Properties:\n";

        for (int i = 0; i < propertyCount; i++) {
            result += " " + i + ": " + properties[i] + "\n";
        }

        result += String.format("Total Rent: $%.2f", totalRent());
        return result;
    }
}
