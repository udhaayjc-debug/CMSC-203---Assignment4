/*
 * Class: CMSC203 
 * Instructor: Huseyin Aygun
 * Description: PropertyDriver class that provides the console menu for Assignment 4.
 * Due: 10/25/2026
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student.
 * Print your Name here: Udhaay Jayachandran
 */

import java.util.Scanner;

public class PropertyDriver {

    /** Runs the console Property Management application. */
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        ManagementCompany company =
                new ManagementCompany("Udhaay Realty", "123-45-6789");

        int choice = 0;

        do {
            displayMenu();

            while (!keyboard.hasNextInt()) {
                System.out.println("Invalid choice. Enter a number from 1 to 4.");
                keyboard.nextLine();
                System.out.print("Enter choice (1-4): ");
            }

            choice = keyboard.nextInt();
            keyboard.nextLine();

            switch (choice) {
            case 1:
                addProperty(keyboard, company);
                break;
            case 2:
                System.out.println(company);
                break;
            case 3:
                System.out.printf("Total rent: $%.2f%n", company.totalRent());
                break;
            case 4:
                System.out.println("Program complete.");
                System.out.println("Programmer: Udhaay Jayachandran");
                break;
            default:
                System.out.println("Invalid choice. Enter a number from 1 to 4.");
            }

            System.out.println();
        } while (choice != 4);

        keyboard.close();
    }

    /** Displays the required menu. */
    public static void displayMenu() {
        System.out.println("====================================");
        System.out.println("  Assignment 4: Property Manager");
        System.out.println("====================================");
        System.out.println("1 - Add Property");
        System.out.println("2 - Display All Properties");
        System.out.println("3 - Show Total Rent");
        System.out.println("4 - Exit");
        System.out.print("Enter choice (1-4): ");
    }

    /** Reads property information and adds it to the company. */
    public static void addProperty(Scanner keyboard, ManagementCompany company) {
        if (company.getPropertyCount() >= ManagementCompany.MAX_PROPERTIES) {
            System.out.println("The property list is full.");
            return;
        }

        System.out.print("Enter property name: ");
        String propertyName = keyboard.nextLine();

        System.out.print("Enter city: ");
        String city = keyboard.nextLine();

        double rentAmount = readRent(keyboard);

        System.out.print("Enter owner name: ");
        String owner = keyboard.nextLine();

        Property property =
                new Property(propertyName, city, rentAmount, owner);

        int index = company.addProperty(property);

        if (index >= 0) {
            System.out.println("Property added at index " + index + ".");
        } else {
            System.out.println("Property could not be added.");
        }
    }

    /** Reads and validates a nonnegative rent amount. */
    private static double readRent(Scanner keyboard) {
        double rent = -1.0;

        while (rent < 0) {
            System.out.print("Enter monthly rent: ");

            if (keyboard.hasNextDouble()) {
                rent = keyboard.nextDouble();
                keyboard.nextLine();

                if (rent < 0) {
                    System.out.println("Rent cannot be negative.");
                }
            } else {
                System.out.println("Invalid rent amount.");
                keyboard.nextLine();
            }
        }

        return rent;
    }
}
