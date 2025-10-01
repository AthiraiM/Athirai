package command;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Light light = new Light();
        Command onCommand  = new LightOnCommand(light);
        Command offCommand = new LightOffCommand(light);
        RemoteControl remote = new RemoteControl();

        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("=== Remote Control ===");
            System.out.println("Type 'on' to turn light on, 'off' to turn light off, 'exit' to quit.\n");

            while (true) {
                System.out.print("Enter command: ");
                String input = sc.nextLine().trim().toLowerCase();

                if (input.equals("exit")) break;
                else if (input.equals("on"))  remote.setCommand(onCommand);
                else if (input.equals("off")) remote.setCommand(offCommand);
                else {
                    System.out.println("Unknown command!");
                    continue;
                }

                remote.pressButton();
            }
        }

        System.out.println("Goodbye!");
    }
}
