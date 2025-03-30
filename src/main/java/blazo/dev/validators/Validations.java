package blazo.dev.validators;

import java.util.Scanner;

public class Validations {
    public static String askForNonEmptyString(Scanner scanner, String prompt) {
        String input;
        while ((input = getUserInput(scanner, prompt)).isEmpty()) {
            System.out.println("⚠️ Name cannot be empty.");
        }
        return input;
    }

    private static String getUserInput(Scanner scanner, String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    public static int askForPositiveInt(Scanner scanner, String prompt) {
        while (true) {
            String input = getUserInput(scanner, prompt);

            try {
                int value = Integer.parseInt(input);

                if (isPositive(value)) {
                    return value;
                }

                System.out.println("⚠️ Number must be positive.");
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Please enter a valid number.");
            }
        }
    }

    private static boolean isPositive(int number) {
        return number >= 0;
    }

}
