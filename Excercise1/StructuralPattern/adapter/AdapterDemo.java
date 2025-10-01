package adapter;

import utils.InputHandler;
import utils.LoggerUtil;
import java.util.logging.Logger;

public class AdapterDemo {
    private static final Logger logger = LoggerUtil.getLogger(AdapterDemo.class);

    public static void main(String[] args) {
        boolean continueProgram = true;

        while (continueProgram) {
            System.out.println("\n=== Power Socket Adapter Menu ===");
            System.out.println("1. Use Old Socket / New Device based on voltage");
            System.out.println("2. Exit");

            int choice = InputHandler.getInt("Choose an option: ", 1, 2);

            switch (choice) {
                case 1 -> {
                    // Get voltage from user
                    int voltage = InputHandler.getInt("Enter input voltage (e.g., 110 or 220): ", 1, 1000);

                    if (voltage == 110) {
                        Socket oldSocket = new OldSocket();
                        oldSocket.provideElectricity();
                    } else if (voltage == 220) {
                        Socket adapter = new SocketAdapter(new NewDevice());
                        adapter.provideElectricity();
                    } else {
                        logger.warning("Unsupported voltage: " + voltage);
                    }
                }
                case 2 -> {
                    continueProgram = false;
                    logger.info("Exiting Adapter Demo...");
                }
            }
        }
    }
}
