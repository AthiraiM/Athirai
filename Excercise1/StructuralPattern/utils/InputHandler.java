package utils;

import java.util.Scanner;
import java.util.logging.Logger;

public class InputHandler {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Logger logger = LoggerUtil.getLogger(InputHandler.class);

    public static int getInt(String prompt, int min, int max) {
        while (true) {
            try {
                System.out.print(prompt);
                int value = Integer.parseInt(scanner.nextLine());
                if (value < min || value > max) {
                    throw new IllegalArgumentException("Value must be between " + min + " and " + max);
                }
                return value;
            } catch (NumberFormatException e) {
                logger.warning("Invalid number format. Please enter a valid integer.");
            } catch (IllegalArgumentException e) {
                logger.warning(e.getMessage());
            } catch (Exception e) {
                logger.severe("Unexpected error: " + e.getMessage());
            }
        }
    }
}
