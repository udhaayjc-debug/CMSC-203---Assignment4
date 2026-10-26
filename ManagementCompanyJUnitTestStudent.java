/*
 * Class: CMSC203 
 * Instructor: Huseyin Aygun
 * Description: ManagementCompanyJUnitTestStudent class containing JUnit 5 tests for ManagementCompany.
 * Due: 10/25/2026
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student.
 * Print your Name here: Udhaay Jayachandran
 */

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ManagementCompanyJUnitTestStudent {

    /** Tests adding properties and total rent. */
    @Test
    public void testAddPropertyAndTotalRent() {
        ManagementCompany mc =
                new ManagementCompany("Udhaay Realty", "123-45-6789");

        Property p1 = new Property("Apt 1", "Germantown", 1200.0, "Udhaay");
        Property p2 = new Property("Apt 2", "Germantown", 1500.0, "Udhaay");

        assertEquals(0, mc.addProperty(p1));
        assertEquals(1, mc.addProperty(p2));
        assertEquals(2, mc.getPropertyCount());
        assertEquals(2700.0, mc.totalRent(), 0.001);
    }

    /** Tests the full-array error return value. */
    @Test
    public void testAddPropertyWhenFull() {
        ManagementCompany mc =
                new ManagementCompany("Udhaay Realty", "123-45-6789");

        for (int i = 0; i < ManagementCompany.MAX_PROPERTIES; i++) {
            mc.addProperty(
                    new Property("P" + i, "City", 1000.0 + i, "Owner"));
        }

        int result =
                mc.addProperty(
                        new Property("Extra", "City", 2000.0, "OwnerX"));

        assertEquals(-1, result);
    }

    /** Tests that the copy constructor performs a deep copy. */
    @Test
    public void testManagementCompanyCopyConstructor() {
        ManagementCompany mc1 =
                new ManagementCompany("Udhaay Realty", "123-45-6789");

        mc1.addProperty(new Property("Apt 1", "Germantown", 1200.0, "Udhaay"));
        mc1.addProperty(new Property("Apt 2", "Germantown", 1500.0, "Udhaay"));

        ManagementCompany mc2 = new ManagementCompany(mc1);

        assertEquals(mc1.getName(), mc2.getName());
        assertEquals(mc1.getTaxId(), mc2.getTaxId());
        assertEquals(mc1.getPropertyCount(), mc2.getPropertyCount());
        assertEquals(mc1.totalRent(), mc2.totalRent(), 0.001);
        assertNotSame(mc1.getProperty(0), mc2.getProperty(0));
    }

    /** Tests the company toString output. */
    @Test
    public void testToString() {
        ManagementCompany mc =
                new ManagementCompany("Udhaay Realty", "123-45-6789");

        mc.addProperty(
                new Property("Property-1", "Germantown", 3500.0, "Udhaay"));

        String output = mc.toString();

        assertTrue(output.contains("Management Company: Udhaay Realty"));
        assertTrue(output.contains("Property-1"));
        assertTrue(output.contains("Total Rent: $3500.00"));
    }
}
