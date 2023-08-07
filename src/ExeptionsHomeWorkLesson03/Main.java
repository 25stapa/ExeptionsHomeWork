package ExeptionsHomeWorkLesson03;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// Requesting data from the user
		System.out.println("Enter data in the format: \n" +
				"LastName FirstName MiddleName DateOfBirth(dd.mm.yyyy) PhoneNumber Gender(m/f)");
		String userData = scanner.nextLine();

		// Separating data by space
		String[] data = userData.split(" ");

		// Checking the amount of data
		if (data.length != 6) {
			System.out.println("Error: Wrong amount of data!");
			return;
		}

		// Data Extraction
		String surname = data[0];
		String name = data[1];
		String patronymic = data[2];
		String dateOfBirth = data[3];
		String phoneNumber = data[4];
		String gender = data[5];

		// Date of birth format check
		if (!dateOfBirth.matches("\\d{2}\\.\\d{2}\\.\\d{4}")) {
			System.out.println("Error: Wrong date of birth format!");
			return;
		}

		// Check phone number format
		if (!phoneNumber.matches("\\d+")) {
			System.out.println("Error: Wrong phone number format!");
			return;
		}

		// Checking the floor format
		if (!gender.matches("[mf]")) {
			System.out.println("Error: Wrong floor format!");
			return;
		}

		// Create a string to write to a file
		String line = surname + " "
				+ name + " "
				+ patronymic + " "
				+ dateOfBirth + " "
				+ phoneNumber + " "
				+ gender;

		// Write to file and error handling
		try (FileWriter writer = new FileWriter(surname + ".txt", true)) {
			writer.write(line);
			writer.write(System.lineSeparator());
			System.out.println("The data was successfully written to the file!");
		} catch (IOException e) {
			System.out.println("Error writing to file: " + e.getMessage());
			e.printStackTrace();
		} finally {
			scanner.close();
		}
	}
}