/*
 * Class: CMSC203 
 * Instructor: Huseyin Aygun
 * Description: PropertyJUnitTestStudent class containing JUnit 5 tests for Property.
 * Due: 10/25/2026
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student.
 * Print your Name here: Udhaay Jayachandran
 */

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PropertyJUnitTestStudent {
    private Property property;

    /** Creates a fresh Property before each test. */
    @BeforeEach
    public void setUp() {
        property = new Property(
                "House", "Rockville", 1500.00, "Udhaay");
    }

    /** Tests the parameterized constructor and getters. */
    @Test
    public void testParameterizedConstructorAndGetters() {
        assertEquals("House", property.getPropertyName());
        assertEquals("Rockville", property.getCity());
        assertEquals(1500.00, property.getRentAmount(), 0.001);
        assertEquals("Udhaay", property.getOwner());
    }

    /** Tests the setters. */
    @Test
    public void testSetters() {
        property.setPropertyName("Lake House");
        property.setCity("Germantown");
        property.setRentAmount(1800.00);
        property.setOwner("John Lee");

        assertEquals("Lake House", property.getPropertyName());
        assertEquals("Germantown", property.getCity());
        assertEquals(1800.00, property.getRentAmount(), 0.001);
        assertEquals("John Lee", property.getOwner());
    }

    /** Tests the copy constructor. */
    @Test
    public void testCopyConstructor() {
        Property copy = new Property(property);

        assertEquals(property.getPropertyName(), copy.getPropertyName());
        assertEquals(property.getCity(), copy.getCity());
        assertEquals(property.getRentAmount(), copy.getRentAmount(), 0.001);
        assertEquals(property.getOwner(), copy.getOwner());
        assertNotSame(property, copy);
    }

    /** Tests the required toString format. */
    @Test
    public void testToString() {
        String expected =
                "House, Rockville, Rent: $1500.00, Owner: Udhaay";

        assertEquals(expected, property.toString());
    }
}
