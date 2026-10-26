/*
 * Class: CMSC203 
 * Instructor: Huseyin Aygun
 * Description: PropertyDriverJUnitTestStudent class containing JUnit 5 tests for PropertyDriver.
 * Due: 10/25/2026
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student.
 * Print your Name here: Udhaay Jayachandran
 */

import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;

public class PropertyDriverJUnitTestStudent {

    /** Tests that the menu displays all required choices. */
    @Test
    public void testDisplayMenu() {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        System.setOut(new PrintStream(output));
        PropertyDriver.displayMenu();
        System.setOut(originalOut);

        String result = output.toString();

        assertTrue(result.contains("Assignment 4: Property Manager"));
        assertTrue(result.contains("1 - Add Property"));
        assertTrue(result.contains("2 - Display All Properties"));
        assertTrue(result.contains("3 - Show Total Rent"));
        assertTrue(result.contains("4 - Exit"));
    }
}
