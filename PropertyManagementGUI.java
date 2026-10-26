/*
 * Class: CMSC203 
 * Instructor: Huseyin Aygun
 * Description: PropertyManagementGUI class that provides a simple JavaFX interface for the Property Management application.
 * Due: 10/25/2026
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student.
 * Print your Name here: Udhaay Jayachandran
 */

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PropertyManagementGUI extends Application {
	private ManagementCompany company;
	private TextArea outputArea;

	/** Creates and displays the JavaFX interface. */
	@Override
	public void start(Stage stage) {
		company = new ManagementCompany("Udhaay Realty", "123-45-6789");

		//Input text fields
		TextField nameField = new TextField();
		TextField cityField = new TextField();
		TextField rentField = new TextField();
		TextField ownerField = new TextField();

		//Adding buttons in the grid
		Button addButton = new Button("Add Property");
		Button displayButton = new Button("Display Properties");
		Button totalButton = new Button("Show Total Rent");
		HBox buttonBox = new HBox(10, addButton, displayButton, totalButton);

		// Output area 
		outputArea = new TextArea();
		outputArea.setEditable(false);

		
		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);

		//Adding name and text box in the grid
		grid.add(new Label("Property Name:"), 0, 0);
		grid.add(nameField, 1, 0);
		grid.add(new Label("City:"), 0, 1);
		grid.add(cityField, 1, 1);
		grid.add(new Label("Monthly Rent:"), 0, 2);
		grid.add(rentField, 1, 2);
		grid.add(new Label("Owner:"), 0, 3);
		grid.add(ownerField, 1, 3);

		// Add Property
		addButton.setOnAction(event -> {
			try {
				double rent = Double.parseDouble(rentField.getText());

				Property property = new Property(nameField.getText(), cityField.getText(), rent, ownerField.getText());

				int index = company.addProperty(property);

				if (index >= 0) {
					outputArea.setText("Property added at index " + index + ".");
					
					// Clear fields
					nameField.clear();
					cityField.clear();
					rentField.clear();
					ownerField.clear();
				} else {
					outputArea.setText("Property could not be added.");
				}
			} catch (NumberFormatException e) {
				outputArea.setText("Enter a valid rent amount.");
			}
		});

		// Show Properties
		displayButton.setOnAction(event -> outputArea.setText(company.toString()));

		// Total Rent
		totalButton.setOnAction(event -> outputArea.setText(String.format("Total rent: $%.2f", company.totalRent())));

		// Max layout in the grid
		VBox root = new VBox(12, grid,buttonBox , outputArea);
		root.setPadding(new Insets(15));

		stage.setScene(new Scene(root, 500, 450));
		stage.setTitle("Assignment 4: Property Manager");
		stage.show();
	}

	/** Starts the JavaFX program. */
	public static void main(String[] args) {
		launch(args);
	}
}
