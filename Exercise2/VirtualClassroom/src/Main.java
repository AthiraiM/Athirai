import factory.EntityFactory;
import manager.IClassroomManager;
import manager.VirtualClassroomManager;
import ui.CommandProcessor;

public class Main {
    public static void main(String[] args) {
        // Create Factory
        EntityFactory factory = new EntityFactory();

        // Create Classroom Manager using factory
        IClassroomManager manager = new VirtualClassroomManager(factory);

        // Start menu
        CommandProcessor processor = new CommandProcessor(manager);
        processor.start();
    }
}
