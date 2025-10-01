package decorator;

import utils.InputHandler;
import utils.LoggerUtil;
import java.util.logging.Logger;

public class DecoratorDemo {
    private static final Logger logger = LoggerUtil.getLogger(DecoratorDemo.class);

    public static void main(String[] args) {
        boolean continueProgram = true;
        Sandwich sandwich = new BasicSandwich(); // Start with a basic sandwich

        while (continueProgram) {
            System.out.println("\n=== Sandwich Builder Menu ===");
            System.out.println("1. Add Cheese");
            System.out.println("2. Add Tomato");
            System.out.println("3. Show Sandwich");
            System.out.println("4. Exit");

            int choice = InputHandler.getInt("Choose an option: ", 1, 4);

            switch (choice) {
                case 1 -> {
                    sandwich = new CheeseDecorator(sandwich);
                    logger.info("Cheese added to the sandwich.");
                }
                case 2 -> {
                    sandwich = new TomatoDecorator(sandwich);
                    logger.info("Tomato added to the sandwich.");
                }
                case 3 -> {
                    System.out.println("Current Sandwich: " + sandwich.make());
                }
                case 4 -> {
                    continueProgram = false;
                    logger.info("Exiting Sandwich Builder. Enjoy your sandwich!");
                }
                default -> logger.warning("Invalid choice. Please select 1-4.");
            }
        }
    }
}
